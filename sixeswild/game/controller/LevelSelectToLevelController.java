package game.controller;

import game.view.GameViewApplication;

/**
 * 
 * 
 * 
 *
 */

import game.view.LevelView;

/**
 * 
 * 
 * 
 *
 */

public class LevelSelectToLevelController {
	/** The application.*/
	private GameViewApplication app;
	
	/**
	 * Constructor that creates a levelSelect to level controller
	 * that allows player to switch from the level select window 
	 * to the level view.
	 * @param app, game application
	 */
	public LevelSelectToLevelController( GameViewApplication app){
		this.app = app;
	}
	
	/**
	 * Allows player to switch from the levelSelectView to
	 * the levelView.
	 */
	public void switchView(int level_number){
		app.getLevelSelectView().setVisible(false);
		LevelView levelView2 = new LevelView(this.app, level_number);
		app.setLevelView(levelView2);
		app.getAppFrame().getContentPane().add(this.app.getLevelView());
		app.getAppFrame().getContentPane().repaint();
		
	}
}
