import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;


/**
	Class creates user interface which displays the movies user has marked as favorites
	in a Jlist. UI contains print method which creates a text file with movie favorite.
**/	

public class MovieFavorite extends JFrame implements ActionListener
{

	private JButton btnPrint;
	private JList<String> jList;

	public MovieFavorite()
	{

		String[] data = new String[MovieDiscovery.mlist.size()];

		for(int i = 0; i < data.length; i++)
		{
			data[i] = MovieDiscovery.mlist.get(i).getTitle();
		}

		jList = new JList<String>(data);
		JScrollPane mListScrollPane = new JScrollPane(jList);  
		mListScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		JFrame frame = new JFrame(MovieProperties.FRAME_NAME);
		JPanel panel = new JPanel(new BorderLayout());

		btnPrint = new JButton("Print");
		btnPrint.addActionListener(this);

		JLabel lbl = new JLabel("My Favorite Movies");

		panel.add(lbl,BorderLayout.NORTH);
		panel.add(mListScrollPane, BorderLayout.CENTER);
		panel.add(btnPrint,BorderLayout.SOUTH);

		frame.add(panel);
		frame.setSize(400,400);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) 
	{ 

		if ((JButton)e.getSource() == btnPrint) 
		{
			
			PrintWriter out = null; 
			try
			{
				out = new PrintWriter("MyMovieList.txt");

				for(int i = 0; i < MovieDiscovery.mlist.size(); i++)
				{
				 out.println("Movie " + ( i + 1 )+ " : " + MovieDiscovery.mlist.get(i).getTitle());	
				}

				out.flush();
				out.close();
			}
				 
			catch(FileNotFoundException ee) 
			{ 
				System.out.println("Error with creating output file. Make sure file has a valid extension"); 
			}  

		}



	}



}