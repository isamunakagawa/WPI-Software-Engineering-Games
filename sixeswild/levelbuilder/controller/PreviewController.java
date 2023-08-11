package levelbuilder.controller;

import levelbuilder.entities.*;
import levelbuilder.view.*;

/**
 * Preview Controller that displays a preview of 
 * the level built.
 * 
 *
 */
public class PreviewController {
	
	/** The level to display.*/
	protected Level level;
	
	/** The application where view is being displayed.*/
	protected Application application;

	/**
	 * Constructor for creating a controller for diplaying
	 * level previews.
	 * @param level, given Level
	 * @param application, top-level boundary class
	 */
	public PreviewController(Level level, Application application) {
		this.level = level;
		this.application = application;
	}
	
	/**
	 * Entry method that allows the user to view what 
	 * a level built would look like.
	 */
	public void previewLevel(){
		application.getLevelBuilderView().setVisible(false);
		application.getAppFrame().getContentPane().add(application.getNewLevelView(this.level));
		application.getAppFrame().getContentPane().revalidate();
		application.getAppFrame().getContentPane().repaint();
	}
}
