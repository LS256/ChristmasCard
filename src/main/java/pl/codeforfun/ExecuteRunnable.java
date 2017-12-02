package pl.codeforfun;

import java.util.concurrent.TimeUnit;

/*
 * @autohor LS256
 * Class helps to generate new snow flakes. Generating snow flake by pressing for each snow flake a button is time consuming and wrong idea, that's why this role takes separate thread 
 * (thread created in this class), and this thread generates new snow flakes 
 */
public class ExecuteRunnable implements Runnable {
	private CardPanel cardPanel;
	private TimeMaker timeMaker;
	
	/*
	 * Constructor to assign following parameters
	 * @param cardPanel - area where our snow flakes are moving
	 * @param timeMaker - helps in time generation between next snow flakes. default value is 55ms, and when the program is running this value can be changed by the user by using slider
	 */
	ExecuteRunnable(CardPanel cardPanel, TimeMaker timeMaker) {
		this.cardPanel = cardPanel;
		this.timeMaker = timeMaker;;
	}
	
	
	public void run() {
		while(!Thread.interrupted() & timeMaker.getShouldSnowing()) {
		
				SnowFlake snowFlake = new SnowFlake(cardPanel.getBounds());
				cardPanel.addBall(snowFlake);
				Runnable ballRunnable = new SnowFlakeRunnable(snowFlake, cardPanel);
				Thread ballThread = new Thread(ballRunnable);
				ballThread.start();
				try{
					TimeUnit.MILLISECONDS.sleep(timeMaker.getBetweenSnowingTime());
				} catch(InterruptedException ie) {
					System.out.println("Error occoured during snow flake creating");
					ie.printStackTrace();
				}
		}

	}

}
