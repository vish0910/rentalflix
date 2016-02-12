package io.egen.rentalflix;

import java.util.ArrayList;
import java.util.Map;

import io.egen.rentalflix.database.MovieDatabase;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovieService2 ms = new MovieService2();
		Movie m1 = new Movie();
		m1.setId(101);
		m1.setTitle("Hello");
		m1.setLanguage("English");
		m1.setYear(2005);
		System.out.println(ms.create(m1));

		
		
		m1 = new Movie();
		m1.setId(102);
		m1.setTitle("Namaste");
		m1.setLanguage("Hindi");
		m1.setYear(1990);
		System.out.println(ms.create(m1));
		
		ArrayList<Movie> al = (ArrayList<Movie>) ms.findAll();
		System.out.println("Find All:"+ al);
		
		System.out.println("Looking for Hello:"+ms.findByName("Hello").toString());
//		System.out.println("Looking for Josh:"+ms.findByName("Josh").toString());
	
		m1 = new Movie();
		m1.setId(101);
		m1.setTitle("Josh");
		m1.setLanguage("Hindi");
		m1.setYear(1990);
//		System.out.println(ms.create(m1)); //Works
		
		System.out.println("Updating Hello -> Josh"+ms.update(m1));
		System.out.println("*Post Updating: "+ms.findAll());

		System.out.println("Looking for Josh:"+ms.findByName("Josh").toString());
		
//		m1 = new Movie();
//		m1.setId(201);
//		m1.setTitle("Hosh");
//		m1.setLanguage("Hindi");
//		m1.setYear(1991);
//		System.out.println("Updating Namaste -> Josh"+ms.update(m1)); //Works
		
//		System.out.println("Deleting 102"+ms.delete(102));
//		System.out.println("*Post Deleting: "+ms.findAll());
		
		Map<Integer, String> rentedMovies = MovieDatabase.getRentedMovies();
		rentedMovies.put(101, "Vishal");
//		rentedMovies.put(103, "Vishal");

		
		System.out.println("Rented Movies: "+ rentedMovies.toString());
		
		System.out.println("Can 101 rented?:"+ms.rentMovie(101, "Rohit"));
		System.out.println("Can 102 rented?:"+ms.rentMovie(102, "Sohit"));
		System.out.println("Can 103 rented?:"+ms.rentMovie(103, "Mohit"));


		
	}

}
