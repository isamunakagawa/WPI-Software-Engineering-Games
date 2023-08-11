package game.controller;

import game.entity.Board;
import game.entity.Level;
import game.entity.Square;
import game.view.GameViewApplication;

/**
 * Controller that allows a player to complete an elimination level.
 * 
 * 
 *
 */
public class CompleteEliminationController {
	
	/** The given level.*/
	protected Level level;
	
	/** The game application.*/
	protected GameViewApplication app;
	
	/**
	 * Constructor that creates an object for completing elimination levels.
	 * @param lv, LevelView
	 * @param level, Level
	 * @param app, GameViewApplication
	 */
	public CompleteEliminationController(Level level, GameViewApplication app) {
		this.level = level;
		this.app = app;
	}
	
	/**
	 * Checks if all the squares have been eliminated.
	 * @return true if all squares eliminated , false otherwise. 
	 */
	public boolean hasWon() {
		Board board = this.level.getBoard();
		int i,j; //counters
		Square testSq;
		for (i = 0; i < 9; i++) {
			for (j = 0; j<9; j++) {
				testSq = board.getSquare(i, j);
				if (!testSq.isEliminated() && testSq.isActive()) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Checks if the player has any moves left.
	 * @return true if player has used all moves, false otherwise.
	 */
	public boolean isDone() {
		return this.level.getMode().getCountdown() == 0;
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
