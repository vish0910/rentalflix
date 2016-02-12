package io.egen.rentalflix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import io.egen.rentalflix.database.MovieDatabase;

/**
 * Service implementing IFlix interface.
 * Uses List to store movies.
 * Implements a singleton pattern.
 */
public final class MovieService2 implements IFlix {
	private List<Movie> movies = MovieDatabase.getMovieList();
	private Map<Integer, String> rentedMovies = MovieDatabase.getRentedMovies();
	
	private static MovieService2 ms = null;
	
	private MovieService2() {}

	public static synchronized MovieService2 getInstance() {
		if (ms == null) {
			ms = new MovieService2();
		}
		return ms;
	}

	@Override
	public List<Movie> findAll() {
		return new ArrayList<Movie>(movies);
	}

	@Override
	public List<Movie> findByName(String name) {
		List<Movie> result = new ArrayList<Movie>();
		synchronized (movies) {
			Iterator<Movie> iterator = movies.iterator();
			while (iterator.hasNext()) {
				Movie m = iterator.next();
				if (m.getTitle().equals((name))) {
					result.add(m);
				}
			}
		}
		return result;
	}

	@Override
	public Movie create(Movie movie) {
		if (movies.contains(movie)) {
			throw new IllegalArgumentException("Movie exists. Please use update() to update.");
		}
		movies.add(movie);
		return movie;
	}

	@Override
	public Movie update(Movie movie) {

		synchronized (movies) {
			Iterator<Movie> iterator = movies.iterator();
			while (iterator.hasNext()) {
				Movie m = iterator.next();
				if (m.getId() == movie.getId()) {
					movies.remove(m);
					return create(movie);
				}
			}
		}
		throw new IllegalArgumentException("No such Movie exists");
	}

	@Override
	public Movie delete(int id) {
		synchronized (movies) {
			Iterator<Movie> iterator = movies.iterator();
			while (iterator.hasNext()) {
				Movie m = iterator.next();
				if (m.getId() == id) {
					movies.remove(m);
					return m;
				}
			}
		}
		throw new IllegalArgumentException("No such Movie exists");
	}

	@Override
	public boolean rentMovie(int movieId, String user) {
		synchronized (movies) {
			Iterator<Movie> iterator = movies.iterator();
			while (iterator.hasNext()) {
				Movie m = iterator.next();
				if (m.getId() == movieId) {
					return (!rentedMovies.containsKey(movieId)) ? true : false;
				}
			}
		}
//		throw new IllegalArgumentException("No such Movie exists");
		return false;
	}
}
