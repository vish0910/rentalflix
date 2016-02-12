package io.egen.rentalflix;

import java.util.ArrayList;
import java.util.Map;

import io.egen.rentalflix.database.MovieDatabase;

public class Tester {

	public static void main(String[] args) {
//		MovieService ms = new MovieService();
		MovieService2 ms = MovieService2.getInstance();
		Movie m1 = new Movie();
		m1.setId(101);
		m1.setTitle("The Gift");
		m1.setLanguage("English");
		m1.setYear(2015);
		System.out.println("Created: "+ms.create(m1)); 
//		ms = new MovieService2();
//		ms = MovieService2.getInstance();
		m1 = new Movie();
		m1.setId(102);
		m1.setTitle("The Ring");
		m1.setLanguage("English");
		m1.setYear(2005);
		System.out.println("Created: "+ms.create(m1));
		
		ArrayList<Movie> al = (ArrayList<Movie>) ms.findAll();
		System.out.println("Find All:"+ al);
		
		System.out.println("Looking for The Gift:"+ms.findByName("The Gift").toString());
		System.out.println("Looking for Burfi:"+ms.findByName("Burfi").toString());
	
		m1 = new Movie();
		m1.setId(101);
		m1.setTitle("Talvar");
		m1.setLanguage("Hindi");
		m1.setYear(2015);
		//Try to create duplicate
//		System.out.println(ms.create(m1)); //Works
		
		System.out.println("Updating The Gift -> Talvar"+ms.update(m1));
		System.out.println("*Post Updating: "+ms.findAll());

		System.out.println("Looking for Talvar:"+ms.findByName("Talvar").toString());
		
		//Updating with non existent movie
		m1 = new Movie();
		m1.setId(201);
		m1.setTitle("Burfi");
		m1.setLanguage("Hindi");
		m1.setYear(2013);
//		System.out.println("Updating with non existent movie"+ms.update(m1)); //Works
		
//		System.out.println("Deleting 102"+ms.delete(102));
//		System.out.println("*Post Deleting: "+ms.findAll()); // Works
		
		Map<Integer, String> rentedMovies = MovieDatabase.getRentedMovies();
		rentedMovies.put(101, "Vishal");
		
		System.out.println("Rented Movies: "+ rentedMovies.toString());
		
		System.out.println("Can 101 rented?:"+ms.rentMovie(101, "Rohit"));
		System.out.println("Can 102 rented?:"+ms.rentMovie(102, "Sohit"));
		System.out.println("Can 103 rented?:"+ms.rentMovie(103, "Mohit"));
		
	}

}
