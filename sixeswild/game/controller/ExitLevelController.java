package game.controller;

import game.view.GameViewApplication;

/**
 * 
 * 
 * 
 *
 */

public class ExitLevelController {
	
	/** The application.*/
	private GameViewApplication app;
	
	/**
	 * Constructor that creates an exit level controller.
	 * @param app, game application
	 */
	public ExitLevelController(GameViewApplication app){
		this.app = app;
	}
	
	/**
	 * Allows the player to exit the level, and 
	 * return to the splash screen.
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
