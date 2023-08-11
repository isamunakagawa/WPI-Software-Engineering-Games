package game.entity;

import game.view.LevelView;

import java.awt.Color;
import java.util.TimerTask;

/**
 * 
 * 
 *
 */

public class LightningTimer extends TimerTask {

	protected LevelView levelView;
	protected int seconds = 0;
	protected int countdown;
	// note that you can pass in what you need
	public LightningTimer(int countdown, LevelView levelView) {
		this.levelView = levelView;
		this.countdown = countdown;
	}
	

	@Override
	public void run() {
		//System.out.println(new Integer(countdown).toString());
		levelView.decrementCountdown();
		seconds++;
		
		
		if(countdown <= 0) {
			levelView.setBackground(Color.red);
		}
		else{
			countdown--;
		}
	}

}
