package io.egen.rentalflix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import io.egen.rentalflix.database.MovieDatabase;

/**
 * Service implementing IFlix interface
 * You can use any Java collection type to store movies
 */
public class MovieService implements IFlix {
	Map<Integer,Movie> movies = MovieDatabase.getMovies();
	Map<Integer, String> rentedMovies = MovieDatabase.getRentedMovies();

	@Override
	public List<Movie> findAll() {
		return (ArrayList<Movie>) movies.values();
	}
	
	@Override
	public List<Movie> findByName(String name) {
		List<Movie> result = new ArrayList<Movie>();
		for(Integer i: movies.keySet()){
			Movie m = movies.get(i);
			if(m.getTitle().equals(name)){
				//Add it to the Result list
				result.add(m);
			}	
		}
		return result;
	}

	@Override
	public Movie create(Movie movie) {
		if(movies.containsKey(movie.getId())){
			throw new IllegalArgumentException("Movie exists. Please use update() to update.");
		}
		return movies.put(movie.getId(), movie); //returns old movie
	}

	@Override
	public Movie update(Movie movie) {
		if(!movies.containsKey(movie.getId())){
			throw new IllegalArgumentException("No such Movie exists");
		}
		return movies.put(movie.getId(), movie); //returns old movie
	}

	@Override
	public Movie delete(int id) {
		return movies.remove(id);
	}

	@Override
	public boolean rentMovie(int movieId, String user) {
		return (movies.containsKey(movieId) && !rentedMovies.containsKey(movieId))?true:false;
	}

}
