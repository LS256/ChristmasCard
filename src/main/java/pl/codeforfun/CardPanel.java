package pl.codeforfun;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/*
 * Class which creates JPanel on which snow flakes are moving
 */
public class CardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private BufferedImage image;
	List<SnowFlake> ballsList = new ArrayList<SnowFlake>();
	
	/*
	 * Constructor allows loading background picture
	 */
	public CardPanel(){
		try {
			image = ImageIO.read(new File("photo.jpg"));
			
		} catch (IOException e) {
			System.out.println("Looks that background file is missing or file name is incorrect.");
			e.printStackTrace();
		}
	}
	
	/*
	 * Method responsible for loading new ball to this panel
	 */
	public void addBall(SnowFlake snowFlake) {
		ballsList.add(snowFlake);
	}
	
	/*
	 * Method responsible for drawing snow flakes
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 */
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(image,  0,  0,  this);
		Graphics2D g2 = (Graphics2D) g;
		
		for(int i=0; i<ballsList.size(); i++ ) {
			g2.setColor(ballsList.get(i).getColor());
			g2.fill(ballsList.get(i).getShape());
		}
	}

}
