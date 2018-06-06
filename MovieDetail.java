import java.awt.*;
import javax.swing.text.JTextComponent;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.net.URL;
import javax.imageio.*;
import javax.swing.*;
import java.util.*;

/**
	Class which creates the UI presenting the user with movie details
**/

public class MovieDetail extends JFrame implements ActionListener, ItemListener
{
	private JCheckBox cb;
	private JButton btnGoToFav;
	private Movie movie;
	private MovieFavorite mf = null;
	
	//Constructor which presents user with new frame containing movie details
	
	public MovieDetail(Movie m) 
	{
		
		this.movie = m;

		JFrame frame = new JFrame(MovieProperties.FRAME_NAME);
		
		//Creating right panel where we want to display movie detail description
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));

		// Creating textfield to contain movie information
		JTextField tfReleaseDate  = new JTextField("Release Date : " + m.getReleaseDate());
		JTextField tfRating  = new JTextField("Rating : " + m.getVoteAvg() + "/10");
		JTextField tfVoteCount  = new JTextField("Vote Count : " + m.getVoteCount());
		JTextField tfPopularity  = new JTextField("Popularity Score : " + m.getPopularity());
		JTextField tfOriginLang  = new JTextField("Original Language : " + m.getOriginLang()); 
		
		//Holding JTextField in an array of JTextField
		JTextField[] tfa = {tfReleaseDate,tfRating,tfVoteCount,tfPopularity,tfOriginLang};

		for (int i = 0; i < tfa.length; i++) 
		{
			tfa[i].setEditable(false);
			tfa[i].setBackground(Color.lightGray);
			rightPanel.add(tfa[i]);
		}

		//Creating an image panel to hold movie poster
		ImagePanel ip = new ImagePanel(MovieProperties.POSTER_BASE_PATH,movie.getPosterPath());
		
		//JLabel will have movie name
		JLabel lblTitle = new JLabel(m.getTitle());
		lblTitle.setFont( new Font("Verdana", Font.BOLD,13));
		lblTitle.setForeground(Color.RED);
		
		//Creating left panel where we want to movie title and image
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
		leftPanel.setBackground(Color.lightGray);
		leftPanel.add(lblTitle);
		leftPanel.add(ip);

		// Creating a JTextArea for movie overview and wrapping text
		JTextArea ta = new JTextArea();
		ta.setEditable(false);
		ta.setText("Movie Overview:  \n \n" + movie.getOverview());
		ta.setLineWrap(true);
		ta.setWrapStyleWord(true);

		// Creating a JCheckBox & JButton 
		cb = new JCheckBox("Add to Favorites", false);
		btnGoToFav = new JButton("Go To Favorites");
		
		// Creating a header panel to add JCheckBox & JButton 
		JPanel headerPanel = new JPanel();
		headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.LINE_AXIS));
		headerPanel.add(cb);
		btnGoToFav.setBackground(new Color(23,154,19));
		headerPanel.add(btnGoToFav);

		btnGoToFav.addActionListener(this);
		cb.addItemListener(this);

		JPanel topPanel = new JPanel(new GridLayout(1,1));
		topPanel.add(leftPanel);
		topPanel.add(rightPanel);
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(headerPanel, BorderLayout.NORTH);
		panel.add(topPanel, BorderLayout.CENTER);
		panel.add(ta, BorderLayout.SOUTH);
		
		frame.add(panel);	
		frame.setSize(400,500);
		frame.setVisible(true);
	}

	
	/*
	 * Methods which performs an action when checkbox is checked and unchecked
	 * When user checks movie as favorite, movie is added to favorite list
	 * When user unchecks movie as favorite, movie is removed from favorite list
	*/
	public void itemStateChanged(ItemEvent e) 
	{
        if (cb.isSelected()) 
        {
        	if (MovieDiscovery.mlist.indexOf(movie) == - 1) 
        	{
				MovieDiscovery.mlist.add(movie);
			}
		}	

		else 
		{
			if (MovieDiscovery.mlist.indexOf(movie) != - 1) 
				  MovieDiscovery.mlist.remove(movie);
		}	
    }
     
	//When Go To Favorites button is clicked, user is brought to his movieFavorites page
	public void actionPerformed(ActionEvent e) 
	{ 
		mf = new MovieFavorite();
	}

}


	
	
