package game.controller;

import game.view.GameViewApplication;
import game.view.LevelSelectView;

/**
 * 
 */

public class SplashScreenToLevelSelectController {
	/** The application.*/
	private GameViewApplication app;
	
	/**
	 * Constructor that creates a controller that handles
	 * switching from the splash screen to the level select screen.
	 * @param app, game application.
	 */
	public SplashScreenToLevelSelectController(GameViewApplication app){
		this.app = app;
	}
	
	/**
	 * Allows the player to switch from the SplashScreen to the 
	 * LevelSelectView.
	 */
	public void switchPanels(){
		RecordsController recordsController = new RecordsController();
		int level_number = recordsController.findCurrentLevel();
		int[] records = recordsController.getRecords();
		
		LevelSelectView levelSelectView2 = new LevelSelectView(this.app, level_number, records);
		app.getSplashScreenView().setVisible(false);
		if ( !app.getLevelSelectView().isVisible() ) {
			app.setLevelSelectView(levelSelectView2);
		}
		else
			app.getAppFrame().getContentPane().add(app.getLevelSelectView());
		app.getAppFrame().getContentPane().add(app.getLevelSelectView());
		app.getAppFrame().getContentPane().repaint();
	}

}
