package game.controller;

import game.entity.Level;
import game.view.GameViewApplication;
import game.view.LevelView;

/**
 * Controller that allows a player to complete a level.
 * 
 * 
 *
 */
public class CompletePuzzleController {
	
	/** The view associated with the level.*/
	protected LevelView lv;
	
	/** The given level.*/
	protected Level level;
	
	/** The game application.*/
	protected GameViewApplication app;
	
	/**
	 * Constructor that creates an object for completing levels.
	 * @param lv, LevelView
	 * @param level, Level
	 * @param app, GameViewApplication
	 */
	public CompletePuzzleController(LevelView lv, Level level, GameViewApplication app) {
		this.lv = lv;
		this.level = level;
		this.app = app;
	}
	
	/**
	 * Checks if the goalsScores have been met by the player.
	 * @return true if the score thresholds are met, false otherwise. 
	 */
	public boolean hasWon() {
		return this.level.goalsMet() > 0;
	}
	
	/**
	 * Checks if the player has any moves left.
	 * @return true if player has used all moves, false otherwise.
	 */
	public boolean isDone() {
		boolean bool = this.level.getMode().getCountdown() == 0;
		System.out.println(bool);
		return bool;
	}

	/**
	 * Exits the levelView exactly as the Exit Controller handles it.
	 */
	public void exitLevel(){
		//removes the level view and revalidates it
		app.getAppFrame().remove(app.getLevelView());
		app.getAppFrame().getContentPane().revalidate();
		
		//set visibility of the splash screen to be true
		//and revalidates and repaints
		app.getSplashScreenView().setVisible(true);
		app.getAppFrame().getContentPane().repaint();
	}
}
