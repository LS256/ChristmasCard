package pl.codeforfun;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/*
 * 	Class responsible for moving single snow flake
 */
public class SnowFlakeRunnable implements Runnable {
	
	private int delay = 100;
	private SnowFlake snowFlake;
	private CardPanel cardPanel;
	private Random random = new Random();
	
	/*
	 *	Constructor responsible for creating movable snow flake
	 *	@param snowFlake - snow flake which will moving
	 *	@param cardPanel - area on which snow flake will move
	 */
	public SnowFlakeRunnable(SnowFlake snowFlake, CardPanel cardPanel) {
		this.snowFlake = snowFlake;
		this.cardPanel = cardPanel;
	}
	
	public void run() {
		while(snowFlake.getStatus()){
			snowFlake.move(cardPanel.getBounds());		
				cardPanel.repaint();
			try {
				TimeUnit.MILLISECONDS.sleep(random.nextInt(delay)+300);
			} catch(InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
}
