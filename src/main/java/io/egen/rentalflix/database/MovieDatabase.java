package io.egen.rentalflix.database;

import java.util.HashMap;
import java.util.Map;

import io.egen.rentalflix.Movie;

public class MovieDatabase {
	private static Map<Integer,Movie> movies = new HashMap<Integer,Movie>();
	private static Map<Integer,String> rentedMovies = new HashMap<Integer,String>();

	public static Map<Integer,Movie> getMovies(){
		return movies;
	}
	
	public static Map<Integer,String> getRentedMovies(){
		return rentedMovies;
	}

}
