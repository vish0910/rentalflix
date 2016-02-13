# rentalflix

* This project consists of 2 types of implementation of IFlix interface:
	1. MovieService.java : Uses ConcurrentHashMaps to store the data. ( I thought they'd be more efficient)
	2. MovieService2.java : Uses Lists to store the data, but still uses Map to store rented-movies data. (I have also implemented this service by making it "singleton")
	
* This project therefore contains 2 JUnit test files. Both have exactly same set of tests, and they just test MovieService and MovieService2 respectively)

* My approach is to use a MovieFactory in the MovieService to create a Movie.

----------------------------------------------
Java assessment for new training candidates.

1. Fork this repository on your own github account.
1. Clone the forked repository in your local machine.
1. Import the project in any Java IDE.
1. Develop MovieService by implementing IFlix interface. Instructions are given in IFlix.java
1. Use any Java collection type in MovieService to store movies.
1. Write JUnit test cases for MovieService in MovieServiceTest file.
1. Keep in mind about possibilities of concurrent access to MovieService.
1. Once completed, DIRECT MESSAGE Praveen on slack with the link of the repo.

-----------------------------------------------