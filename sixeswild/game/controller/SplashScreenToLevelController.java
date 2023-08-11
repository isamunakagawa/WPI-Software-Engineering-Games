package game.controller;

import game.view.GameViewApplication;
import game.view.LevelView;

/**
 * 
 * 
 * 
 *
 */

public class SplashScreenToLevelController {
	/** The application.*/
	private GameViewApplication app;
	
	/**
	 * Constructor that creates a controller that handles
	 * switching views of the splash screen to the level view.
	 * @param app, game application.
	 */
	public SplashScreenToLevelController(GameViewApplication app){
		this.app = app;
	}
	
	/**
	 * Allows the player to switch from the SplashScreenView to the 
	 * levelView.
	 */
	public void switchView(int level_number){
		app.getSplashScreenView().setVisible(false);
		LevelView levelView2 = new LevelView(this.app, level_number);
		app.setLevelView(levelView2);
		app.getAppFrame().getContentPane().add(app.getLevelView());
		app.getAppFrame().getContentPane().repaint();
	}

}
