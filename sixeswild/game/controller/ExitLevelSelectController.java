package game.controller;

import game.view.GameViewApplication;


/**
 * 
 * 
 * 
 *
 */

public class ExitLevelSelectController {
	/** The application.*/
	private GameViewApplication app;
	
	/**
	 * Constructor that creates a exit levelSelect controller
	 * that allows player to exit level select.
	 * @param app, game application.
	 */
	public ExitLevelSelectController(GameViewApplication app){
		this.app = app;
	}
	
	/**
	 * Allows player to exit the level select screen.
	 */
	public void exitLevelSelect(){
		
		app.getLevelSelectView().setVisible(false);
		app.getSplashScreenView().setVisible(true);
		app.getAppFrame().getContentPane().revalidate();
		app.getAppFrame().getContentPane().repaint();
	}

}
