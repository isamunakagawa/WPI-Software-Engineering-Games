package levelbuilder.controller;

import levelbuilder.view.Application;

/**
 * Controller that handles switching between
 * panels.
 * 
 *
 */
public class PanelSwitchingController {
	/** The given application boundary class.*/
	Application app;

	/**
	 * Constructor for creating a panelSwitching controller
	 * to switch screens.
	 * @param appView, application view
	 */
	public PanelSwitchingController( Application appView ) {
		app = appView;
	}
	
	/**
	 * Allows user to switch between screens.
	 */
	public void switchViews(){
		app.getSplashScreenView().setVisible(false);
		app.getAppFrame().getContentPane().add(app.getNewLevelBuilderView());
		app.getAppFrame().getContentPane().revalidate();
		app.getAppFrame().getContentPane().repaint();
	}
	
	/**
	 * Allows user to switch between screens.
	 */
	public void switchViews(String levelNum){
		app.getSplashScreenView().setVisible(false);
		app.getAppFrame().getContentPane().add(app.getNewLevelBuilderView(levelNum));
		app.getAppFrame().getContentPane().revalidate();
		app.getAppFrame().getContentPane().repaint();
	}
}
