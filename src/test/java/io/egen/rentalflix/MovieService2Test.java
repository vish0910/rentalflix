package io.egen.rentalflix;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import io.egen.rentalflix.database.MovieDatabase;

/**
 * JUnit test cases for MovieService
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovieService2Test {
	private MovieService2 ms = null;

	private static List<Movie> lm = new ArrayList<Movie>();

	private static boolean createPassed = false;
	private static boolean dataLoaded = false;

	private static Movie m1 = null;
	private static Movie m2 = null;
	private static Movie m3 = null;
	private static Movie m4 = null;
	private static Movie doesnotExistMovie = null;

	/**
	 * Setup before any test begins.
	 * Load up all the mock data locally.
	 */
	@BeforeClass
	public static void beforeAnyTest() {

		m1 = new Movie();
		m1.setId(101);
		m1.setTitle("The Gift");
		m1.setLanguage("English");
		m1.setYear(2015);
		lm.add(m1);

		m2 = new Movie();
		m2.setId(102);
		m2.setTitle("The Ring");
		m2.setLanguage("English");
		m2.setYear(2005);
		lm.add(m2);

		m3 = new Movie();
		m3.setId(103);
		m3.setTitle("Talvar");
		m3.setLanguage("Hindi");
		m3.setYear(2015);
		lm.add(m3);

		m4 = new Movie();
		m4.setId(104);
		m4.setTitle("The Ring");
		m4.setLanguage("Japanese");
		m4.setYear(2015);
		lm.add(m4);

		doesnotExistMovie = new Movie();
		doesnotExistMovie.setId(201);
		doesnotExistMovie.setTitle("Speed");
		doesnotExistMovie.setLanguage("English");
		doesnotExistMovie.setYear(2000);

	}

	/**
	 * Run before every test. Get a singleton instance of MovieService for the test.
	 */
	@Before
	public void beforeEveryTest() {
		ms = MovieService2.getInstance();
	}

	/**
	 * Test create(Movie m). If successful -> set flag so that future test can use create().
	 */
	@Test
	public void createTest1() {
		Assert.assertEquals(m1, ms.create(m1));
		createPassed = true;
	}

	/**
	 * Test create(Movie m) for duplicates() if the movie already exists in the database.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void createTest2() {
		Assert.assertEquals(m1, ms.create(m1));
	}

	/**
	 * Test findAll(). If successful -> set flag so that future test can know
	 * that the data is already loaded.
	 */
	@Test
	public void findAllTest() {
		if (createPassed == false)
			Assert.fail("Create failed. Fix create first");
		ms.create(m2);
		ms.create(m3);
		ms.create(m4);
		dataLoaded = true;
		Assert.assertEquals(lm, ms.findAll());
	}

	/**
	 * Test findByName(String title).
	 */
	@Test
	public void findByNameTest() {
		if (dataLoaded == false)
			Assert.fail("Data loading failed.");
		List<Movie> lm = new ArrayList<Movie>();
		lm.add(m2);
		lm.add(m4);
		Assert.assertEquals(lm, ms.findByName("The Ring"));
	}

	/**
	 * Test update(Movie m).
	 */
	@Test
	public void updateTest1() {
		if (dataLoaded == false)
			Assert.fail("Data loading failed.");
		Movie m1 = new Movie();
		m1.setId(102);
		m1.setTitle("Tamasha");
		m1.setLanguage("Hindi");
		m1.setYear(2015);
		Assert.assertEquals(m1, ms.update(m1));
	}
	
	
	/**
	 * Test update(Movie m) by trying to update non-existent data.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void updateTest2() {
		ms.update(doesnotExistMovie);
	}

	/**
	 * Test delete(int movieId).
	 */
	@Test
	public void wdeleteTest1() {
		if (dataLoaded == false)
			Assert.fail("Data loading failed.");
		Assert.assertEquals(m1, ms.delete(m1.getId()));
	}

	/**
	 * Test delete(int movieId) by trying to delete non-existent data.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void wdeleteTest2() {
		ms.delete(doesnotExistMovie.getId());
	}

	/**
	 * Test rentMovie(int movieId, String user) when a book is available
	 */
	@Test
	public void vrentMovie1() {
		Assert.assertEquals(true, ms.rentMovie(m1.getId(), "Vishal"));
	}

	/**
	 * Test rentMovie(int movieId, String user) when a book is already rented.
	 */
	@Test
	public void vrentMovie2() {
		Map<Integer, String> rentedMovies = MovieDatabase.getRentedMovies();
		rentedMovies.put(m1.getId(), "Vishal");
		Assert.assertEquals(false, ms.rentMovie(m1.getId(), "Rohit"));
	}

	/**
	 * Test rentMovie(int movieId, String user) by trying to rent non-existent movie.
	 */
	
	@Test
	public void vrentMovie3() {
		Assert.assertEquals(false, ms.rentMovie(doesnotExistMovie.getId(), "Rohit")); // exist
	}
}
