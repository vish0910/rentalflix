package io.egen.rentalflix.database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.egen.rentalflix.Movie;

public class MovieDatabase {
	private static Map<Integer,Movie> movies = new ConcurrentHashMap<Integer,Movie>();
	private static Map<Integer,String> rentedMovies = new ConcurrentHashMap<Integer,String>();
	private static List<Movie> movieList = Collections.synchronizedList(new ArrayList<Movie>());
	
	public static List<Movie> getMovieList() {
		return movieList;
	}
	
	public static Map<Integer,Movie> getMovies(){
		return movies;
	}
	
	public static Map<Integer,String> getRentedMovies(){
		return rentedMovies;
	}

}
