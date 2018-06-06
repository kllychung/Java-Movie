# Java-Movie

Project Overview: 

The goal of this project is to create an interactive java program to allow users to discover highly rated and popular movies. The application has the following main features:
1.	An interface to allow user to select the types of movies they would like to discover (Most popular movies, kids movies, dramas, action etc)
2.	The ability to get information about a specific movie of interest. Movie information includes image of movie poster, overview, description, release date and average votes.
3.	The ability to make create an “interest list” of movies and save interest list to a text file for future review and reference.

Movie Data Source:

The movie information comes from themoviedb.org. They have a free web API where web requests can be made to obtain to get the necessary movie information. Note that the API has 2 end points that we used to get information from. The first end point was used to return a list of movies in JSON format based on movie category selection by the user. The second endpoint was used to return a movie poster in the form of an image for a given movie. 

Java Files Submission:

#	Java file Name	Java file Description
1	MovieDiscovery.java: 	This is the main program to compile and run. It will launch the main screen.
2.	Movie.java: 	Movie Object Class that allows Movie Objects to be constructors.
Contains gets and set methods for movie attributes/instance variables.  
3.	MovieGrid.java: 	Creates a GUI with a grid of JButtons. Names of button will be set to String[] passed in to constructor.
4	Connection.java:	Contains methods to create the connection to the API.
Contains methods to parse JSON text, extract relevant movie information and instantiate movie objects
5	ImagePanel.java:	Contains methods to get a buffered image from a poster url and creates a panel with the image
6	MovieDetail.java:	Creates a GUI with a detailed movie information, overview amd movie poster
Contains a checkbox to allow user to mark movie as favorite
Cotains a button to allow user to navigate to movie favorites page
7	MovieFavorite.java:	Create a GUI with a scrollable list of user movie favorites
Contains buttons to allow user to print movie favorite to a txt file
8	MovieProperties.java:	Contain static variables that the other java programs can reference


Notes:
1. Code was written using Java SE 7. Java EE features not avaibable

