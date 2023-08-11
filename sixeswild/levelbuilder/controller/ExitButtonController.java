package levelbuilder.controller;

import levelbuilder.view.Application;

/**
 * Controller that exits the levelbuilder application.
 *  
 *
 */
public class ExitButtonController {
	
	/** The given application.*/
	Application app;
	
	/**
	 * Constructor that creates an object that handles exiting
	 * the level builder.
	 * @param appView, application.
	 */
	public ExitButtonController ( Application appView ) {
		app = appView;
	}
	
	/**
	 * Allows user to exit the levelbuilder application.
	 */
	public void exitView() {
		app.getAppFrame().remove(app.getLevelBuilderView());
		app.getAppFrame().getContentPane().revalidate();
		app.getAppFrame().getContentPane().repaint();
		app.getSplashScreenView().setVisible(true);
		app.getAppFrame().getContentPane().revalidate();
		app.getAppFrame().getContentPane().repaint();
		
	}

}
