import java.io.*; 
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*
 * Class contains main method which brings up the main frame
*/
public class MovieDiscovery
{
	static MovieGrid movieType;
	static String[] movieNames;
	static MovieGrid mgrid; 
	static MovieDetail md;
	static HashMap<String,Movie> movieList;
	static ArrayList<Movie> mlist = null;
	static String caption = "";
	
	
	public MovieDiscovery()
	{
	
		//Creating movie tiles UI with movie categories for user selection
		movieType = new MovieGrid(MovieProperties.MOVIE_CAT);
		mlist = new ArrayList<Movie>();

		JButton[] abtn = movieType.getButtons();
		movieType.setLabelText("Select category to explore");
		
		ActionListener al = null;

		//Adding an action listener to the JButtons
		for(JButton jb: abtn) 
		{
			jb.addActionListener(al = new ActionListener()
			{

				public void actionPerformed(ActionEvent e) 
				{  
					//Build url based on category selected
					caption = ((JButton) e.getSource()).getText();
					String url = MovieProperties.BASE_PATH + MovieProperties.getMoviePath(caption);

					//Creating connection to API to get movie details
					Connection c = new Connection();
					c.createConnection(url);
					
					//Hashmap of a movie list is returned where movie name is key
					movieList = c.getMovieList();
					
					//Storing movie names in an array to present in tiles fashion
					movieNames = movieList.keySet().toArray(new String[movieList.size()]);
					
					//Creating UI with movie list for user selection
					mgrid = new MovieGrid(movieNames);
					
					JButton[] jbutts = mgrid.getButtons();
					
				
					for (JButton j : jbutts) 
					{
						//Adding an action listener to show movie details when user
						//clicks on a movie
						
						j.addActionListener(new ActionListener()
						
						{
							public void actionPerformed(ActionEvent e) 
							{ 
								String mname = ((JButton)e.getSource()).getText();
								md = new MovieDetail(movieList.get(mname));
							
							}
						});
					}
					
				}
			});
		}	
	}
	
	//Main Method
	public static void main(String[] args)
	{
		
		MovieDiscovery md = new MovieDiscovery();
		

	}

}