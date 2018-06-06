import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;

public class MovieGrid extends JFrame 
{
	
	//UI elements
	private JButton[] btns;
	private JLabel label;
	private JFrame frame;
	
	//Get method which returns arrays of JButtons
	public JButton[] getButtons(){return this.btns;}
	
	//Set method to set label 
	public void setLabelText(String text) {label.setText(text);}

	
	/*
	* Constructor which create a frame with 6 Jbuttons
	* JButton text is set based on the String[] passed in	
	*/
	public MovieGrid(String[] movieCat){
		
		frame = new JFrame(MovieProperties.FRAME_NAME + " " + MovieDiscovery.caption.toUpperCase());
		
		label = new JLabel();
		frame.add(label);
		
		Font font = new Font("Verdana", Font.BOLD,13);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,3));
		
		btns = new JButton[movieCat.length];
		
		for(int i = 0; i < btns.length; i++) 
		{
			btns[i] = new JButton(movieCat[i]);

			//Here we want to alternate color. Even = Gray and Odd = Red
			if(i % 2 == 0) btns[i].setBackground(Color.LIGHT_GRAY);
			else btns[i].setBackground(Color.RED);
			
			//Setting font color to white
			btns[i].setForeground(Color.WHITE);
			btns[i].setFont(font);
			
			//Text Alignment = Center
			btns[i].setHorizontalTextPosition(SwingConstants.LEFT);
			panel.add(btns[i]);
			
		}
		
		frame.add(panel);
		frame.setSize(600,300);
		frame.setVisible(true);
	}
	



}