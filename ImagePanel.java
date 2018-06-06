import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.net.URL;
import javax.imageio.*;
import javax.swing.*;
import java.util.*;

	/**
	*    This class is used to construct an ImagePanel.
	*    Constructor takes in a base path and a poster path. 
	*  	 Paths are appended and a BufferedImage is returned.
	*    Graphics g is used to paint BufferedImage on panel
	**/
	
	public class ImagePanel extends JPanel {
    
	    private BufferedImage img;

	    public ImagePanel(String basePath , String posterPath) 
	    {
	    	this.setBackground(Color.GRAY);
	    	
			try 
	    	{
	            URL url = new URL(basePath + posterPath.replace("\\",""));
	            img = ImageIO.read(url);

	        } 

	        catch (IOException e) 
			{
				JOptionPane.showMessageDialog(null, "Oops cannot render image");
			}
	    }

	    public void paint(Graphics g) {
	       g.drawImage(img, 10, 2, null);
	    }

	}