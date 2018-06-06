/**
*   Movie class contains get and set methods to work with Movie    
**/

public class Movie 
{
	//Instance Variables of Movie Class
	String title;
	String releaseDate;
	String originLang;
	String voteAvg;
	String voteCount;
	String popularity;
	String posterPath;
	String overview;
	
	//Takes a String param title to set for Movie Object
	public void setTitle(String title) 
	{
		this.title = title;
	}
	
	//Returns title as a string for movie
	public String getTitle() 
	{
		return this.title;
	}
	
	//Takes a String param releaseDate to set for Movie Object
	public void setReleaseDate(String releaseDate) 
	{
		this.releaseDate = releaseDate;
	}
	
	//Returns releaseDate as a string for movie
	public String getReleaseDate() 
	{
		return this.releaseDate;
	}	

	//Takes a String param original language to set for Movie Object
	public void setOriginLang(String originLang) 
	{
		this.originLang = originLang;
	}

	//Returns originLanguage as a string for movie
	public String getOriginLang() 
	{
		return this.originLang;
	}	

	//Takes a string param voteAvg to set for Movie Object
	public void setVoteAvg(String voteAvg) 
	{
		this.voteAvg = voteAvg;
	}
	
	//Returns voteAvg as a string for movie
	public String getVoteAvg() 
	{
		return this.voteAvg;
	}	

	//Takes a string param voteCount to set for Movie Object
	public void setVoteCount(String voteCount) 
	{
		this.voteCount = voteCount;
	}
	
	//Returns voteCount as a string for movie
	public String getVoteCount() 
	{
		return this.voteCount;
	}	
	
	//Takes a string param popularity to set for Movie Object
	public void setPopularity(String popularity) 
	{
		this.popularity = popularity;
	}
	
	//Returns popularity rounded as a string for movie
	public String getPopularity() 
	{
		return Math.round(Double.parseDouble(this.popularity)) + "";
	}	
	
	//Takes a string param posterPath to set for Movie Object	
	public void setPosterPath(String posterPath) 
	{
		this.posterPath = posterPath;
	}
	
	//Returns posterPath as a string for movie
	public String getPosterPath() 
	{
		return this.posterPath;
	}

	//Takes a String param overview to set for Movie Object	
	public void setOverview(String overview) 
	{
		this.overview = overview;
	}
	
	//Returns overview as a string for movie
	public String getOverview() 
	{
		return this.overview;
	}
	
		
	
}