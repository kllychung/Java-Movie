public class MovieProperties 
{
	final static String BASE_PATH = "http://api.themoviedb.org/3/discover/movie?api_key=55ce0cbab99baeeda76432f98c2ea8b5&certification_country=US";

	final static  String[] MOVIE_CAT = {"Most Popular Movies", "Action",
							"Drama", "Movies For Kids", "Comedy", "Latest Releases"};

	final static String FRAME_NAME = "MOVIE DISCOVERY APP"; 
	
	final static String POSTER_BASE_PATH = "http://image.tmdb.org/t/p/w185";

	public static String getMoviePath(String caption)
	{
		String url = "";
		if (caption == "Most Popular Movies")
		url += "&sort_by=popularity.desc";

		else if (caption == "Action")
		url +=  "&with_genres=28";

		else if (caption == "Drama")
		url += "&with_genres=18";

		else if (caption == "Movies For Kids")
		url += "&certification.lte";

		else if (caption == "Comedy")
		url += "&with_genres=35";

		else if (caption == "Latest Releases")
		url += "&primary_release_year=2018";

		return url;
	} 							
}