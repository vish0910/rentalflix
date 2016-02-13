package io.egen.rentalflix;

import io.egen.rentalflix.database.MovieDatabase;

public class MovieFactory {
	
	/**
	 * Creates a Movie
	 * @param
	 * @return Movie
	 */
	public static Movie getMovie(String title,int year,String language ){
		Movie movie = new Movie();
		movie.setId(generateId());
		movie.setTitle(title);
		movie.setYear(year);
		movie.setLanguage(language);		
		return movie;
	}
	
	/**
	 * Generates a Movie ID
	 * @return int movieId
	 */
	public synchronized static int generateId(){
		MovieDatabase.setCounter(MovieDatabase.getCounter()+1); // increment counter
		return MovieDatabase.getCounter();
	}
	
}
