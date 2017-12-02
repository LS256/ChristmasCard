package pl.codeforfun;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

/**
 * @author LS256
 *	Class responsible for creating single snow flake
 */
public class SnowFlake {
	
	private Random random = new Random();
	private boolean status = true;
	private int xSnowFlakePosition;
	private int ySnowFlakePosition;
	private int widthOfSnowFlake = 10;
	private int heightOfSnowFlake = 10;
	private int dySnowFlakePosition = random.nextInt(20) + 5;
	private Color color;
	
	/*
	 * Method which inform is snow flake is still on the screen
	 * @return true when snowFlake in area of frame 
	 * @return false when snowFlake is out of frame area
	 */
	public boolean getStatus(){
		return status;
	}
	
	/*
	 *	Method to set color of created snow flake. Know that snow is white but in this method is also implemented transparency factor to visualize Z dimension.
	 *	@return color - color include generated random value for transparency of single snow flake
	 */
	private void setColor() {
		int transparencyFactor = random.nextInt(200)+55;
		color = new Color(255, 255, 255, transparencyFactor);
	}
	
	/*
	 * Provide other class with color of single snow flake
	 * @return color - color include generated random value for transparency of single snow flake
	 */
	public Color getColor() {
		return color;
	}
	
	/*
	 *	Construcotr which creates single snow flake 
	 *	@param windowSize - provide size of Christmas card window - only in this area snow flake will be generated 
	 */
	public SnowFlake(Rectangle2D windowSize) {		
		xSnowFlakePosition = random.nextInt((int) windowSize.getWidth())+1;
		ySnowFlakePosition = 0;
		setColor();
	}
	
	/*
	 *	Method responsible for move of single snow flake
	 *	@param windowSize - provide size of Christmas card window - only in this area snow flake will move
	 */
	public void move(Rectangle2D windowSize) {
		if(ySnowFlakePosition > windowSize.getHeight()) {
			status = false;
		}
		ySnowFlakePosition += dySnowFlakePosition;
	}	
	
	/*
	 * Method for creating snow flake shape
	 * @return Ellipse2D - snow flake shape
	 */
	public Ellipse2D getShape(){
		return new Ellipse2D.Double(xSnowFlakePosition,  ySnowFlakePosition,  widthOfSnowFlake, heightOfSnowFlake);
	}

}
