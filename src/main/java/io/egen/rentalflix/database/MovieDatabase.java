package io.egen.rentalflix.database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.egen.rentalflix.Movie;

public class MovieDatabase {
	// Map to save Movies using MovieService
	private static Map<Integer,Movie> movies = new ConcurrentHashMap<Integer,Movie>();
	
	// Map to save Rented Movies
	private static Map<Integer,String> rentedMovies = new ConcurrentHashMap<Integer,String>();
	
	// List to save Movies using MovieService2 
	private static List<Movie> movieList = Collections.synchronizedList(new ArrayList<Movie>());
	private static int counter = 100;
	
	//GETTERS
	public static List<Movie> getMovieList() {
		return movieList;
	}
	
	public static Map<Integer,Movie> getMovies(){
		return movies;
	}
	
	public static Map<Integer,String> getRentedMovies(){
		return rentedMovies;
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		MovieDatabase.counter = counter;
	}
	
}
