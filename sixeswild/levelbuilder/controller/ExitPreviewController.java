package levelbuilder.controller;

import levelbuilder.view.Application;

/**
 * Exit Controller that exits a preview of the level.
 * 
 *
 */
public class ExitPreviewController {
	/** The given application.*/
	Application app;
	
	/**
	 * Constructor that creates a controller for exiting
	 * a preview.
	 * @param appView, application.
	 */
	public ExitPreviewController ( Application appView ) {
		app = appView;
	}
	
	/**
	 * Allows the user to exit the preview.
	 */
	public void exitPreview() {
		app.getAppFrame().remove(app.getLevelView());
		app.getAppFrame().getContentPane().revalidate();
		app.getAppFrame().getContentPane().repaint();
		app.getLevelBuilderView().setVisible(true);
		app.getAppFrame().getContentPane().revalidate();
		app.getAppFrame().getContentPane().repaint();
	}
}
