package game.controller;

import game.entity.LightningTimer;
import game.view.LevelView;

import java.util.Timer;

/**
 * Timer controller that updates the boundary 
 * as the timer counts down.
 * 
 *
 */
public class LightningTimerController {
	
	/** The set amount of time given.*/
	protected int countdown;
	
	/**
	 * Constructor for the controller that updates the timer
	 * within the entity and the boundary.
	 * @param countdown
	 * @param levelView, boundary associated with the level
	 */
	public LightningTimerController (int countdown, LevelView levelView) {
		this.countdown = countdown;
		LightningTimer lt = new LightningTimer(countdown, levelView);
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(lt, 0, 1000);
	}

}
