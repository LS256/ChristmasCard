package pl.codeforfun;

/*
 * Class responsible to manage time between next snow flakes.
 */
public class TimeMaker {
	
	private int betweenSnowingTime;
	private boolean shouldSnowing;
	
	/*
	 * set default time between next snow flakes for 55ms
	 */
	TimeMaker(){
		this.betweenSnowingTime = 50;
		shouldSnowing = true;
	}
	
	/*
	 * @return true if snowing should be visible, otherwise false
	 */
	public boolean getShouldSnowing(){
		return shouldSnowing;
	}
	
	/*
	 * @param shouldSnowing - true if snowing should be visible, otherwise false
	 */
	public void setShouldSnowing(boolean shouldSnowing) {
		this.shouldSnowing = shouldSnowing;
	}
	
	/*
	 * sets time between new snow flakes
	 * @param betweenSnowingTime - time between next snowFlakes. Values of this parameter comes from slider in class CardFrame
	 */
	public void setBetweenSnowingTime(int betweenSnowingTime) {
		this.betweenSnowingTime = betweenSnowingTime;
	}
	
	/*
	 * @return betweenSnowingTime - returns time between next snow flakes
	 */
	public int getBetweenSnowingTime() {
		return betweenSnowingTime;
	}

}
