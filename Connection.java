import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL; 
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Connection 
{
	
	private String jsonText;
	
	/**
	*   This methods takes in parameter of a url, connects to url and get a Json formatted 
	*	response back in byte stream.
	*   InputStreamReader converts byte stream to a character stream
	*   Saving response to string  
	**/
	
	public void createConnection(String url) 
	{
	
		try 
		{
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Accept", "application/json");

			BufferedReader br = new BufferedReader( 
		     	new InputStreamReader(con.getInputStream()));
			
			String jsonTextLine = "";

			while((jsonTextLine = br.readLine()) != null)
			{
				jsonText += jsonTextLine;
			}

			//Close buffered reader
			br.close();
		}
		
		catch(Exception e) 
		{ 
			JOptionPane.showMessageDialog(null, "Make sure internet connection is available.");
		}	
		
		
	}

	/**
	*  There was no Json library in Java SE 7 so a method was created to parse the response.
	*  Method takes in Json text in a string and returns first 6 movies in a Hashmap	
	**/
	
	public HashMap<String,Movie> getMovieList()
	{
		int startIndex = 0; 
		int endIndex = 0;
		int count = 0;
		String movie = null;
		HashMap<String,String> movieMap = new HashMap<>();
		HashMap<String,Movie> movieList = new HashMap<>();
		String s = jsonText;

		//Showing 6 movies
		do 
		{
			startIndex = s.indexOf("{", startIndex + 1);
			endIndex = s.indexOf("}", endIndex + 1);
			movie = s.substring(startIndex, endIndex);
		

			String[] attr =  movie.split(",\"");
			String[] attrB = null;
			
			for (int i = 0; i < attr.length; i++) 
			{
				attr[i] = attr[i].replaceAll("\"","").replace("{","");
				attrB = attr[i].split(":");
				movieMap.put(attrB[0],attrB[1]);
				
			}
			
			Movie m = new Movie();
			m.setTitle(movieMap.get("title"));
			m.setReleaseDate(movieMap.get("release_date"));
			m.setOriginLang(movieMap.get("original_language"));
			m.setVoteAvg(movieMap.get("vote_average"));
			m.setPopularity(movieMap.get("popularity"));
			m.setOverview(movieMap.get("overview"));
			m.setVoteCount(movieMap.get("vote_count"));
			m.setPosterPath(movieMap.get("poster_path"));
			movieList.put(m.getTitle(),m);

			count++;
		}
		
		while (count < 6);

		return movieList;
	}	


}