package levelbuilder.controller;


import levelbuilder.view.LevelBuilderView;

/**
 * Controller that handles selecting the game mode
 * of a level.
 * 
 *
 */
public class SelectGameTypeController{
	
	/** The Level builder view to modify.*/
	LevelBuilderView app;
	
	/**
	 * Constructor that creates a controller 
	 * for setting game modes.
	 * @param game, Mode
	 */
	public SelectGameTypeController(LevelBuilderView game) {
		app = game;
	}

	/**
	 * Allows user to select a game mode, and modifies the'
	 * levelBuilder view accordingly with different options.
	 * @param type, Mode desired
	 */
	public void selectType(String type) {
		switch (type) {
			case "Puzzle": 
				//app.gettextField_12().setVisible(false);
				//app.getlblStar_2().setVisible(false);
				app.getlblVariable().setText("moves");
				
				app.getlblBucketColumns().setVisible(false);
				for (int i = 0; i < 9; i++){
					app.getBucketColumn(i).setVisible(false);;
				}
				
				app.gettextField_16().setEnabled(true);
				
				Integer prob = (Integer) Integer.valueOf(app.gettextField_16().getText());
				app.getLevel().getBoard().getTileGen().setTileProb(5, prob);
				/*app.getrdbtnNewRadioButton1().setVisible(false);
				app.getrdbtnNewRadioButton2().setVisible(false);
				app.getrdbtnNewRadioButton3().setVisible(false);
				app.getrdbtnNewRadioButton4().setVisible(false);
				app.getrdbtnNewRadioButton5().setVisible(false);
				app.getrdbtnNewRadioButton6().setVisible(false);
				app.getrdbtnNewRadioButton7().setVisible(false);
				app.getrdbtnNewRadioButton8().setVisible(false);
				app.getrdbtnNewRadioButton9().setVisible(false);*/
				break;
				
			case "Lightning":
				//app.gettextField_12().setVisible(false);
				//app.getlblStar_2().setVisible(false);
				app.getlblVariable().setText("seconds");
				app.getlblBucketColumns().setVisible(false);
				for (int i = 0; i < 9; i++){
					app.getBucketColumn(i).setVisible(false);;
				}
				
				
				app.gettextField_16().setEnabled(true);
				Integer prob2 = (Integer) Integer.valueOf(app.gettextField_16().getText());
				app.getLevel().getBoard().getTileGen().setTileProb(5, prob2);
				/*app.getlblBucketColumns().setVisible(false);
				app.getrdbtnNewRadioButton1().setVisible(false);
				app.getrdbtnNewRadioButton2().setVisible(false);
				app.getrdbtnNewRadioButton3().setVisible(false);
				app.getrdbtnNewRadioButton4().setVisible(false);
				app.getrdbtnNewRadioButton5().setVisible(false);
				app.getrdbtnNewRadioButton6().setVisible(false);
				app.getrdbtnNewRadioButton7().setVisible(false);
				app.getrdbtnNewRadioButton8().setVisible(false);
				app.getrdbtnNewRadioButton9().setVisible(false);*/
				break;
				
			case "Release":
				//app.gettextField_12().setVisible(true);
				//app.getlblStar_2().setVisible(true);
				app.getlblVariable().setText("moves");
				app.getlblBucketColumns().setVisible(true);
				for (int i = 0; i < 9; i++){
					app.getBucketColumn(i).setVisible(true);;
				}
				
				app.gettextField_16().setEnabled(false);
				app.getLevel().getBoard().getTileGen().setTileProb(5, 0);
				/*app.getlblBucketColumns().setVisible(true);
				app.getrdbtnNewRadioButton1().setVisible(true);
				app.getrdbtnNewRadioButton2().setVisible(true);
				app.getrdbtnNewRadioButton3().setVisible(true);
				app.getrdbtnNewRadioButton4().setVisible(true);
				app.getrdbtnNewRadioButton5().setVisible(true);
				app.getrdbtnNewRadioButton6().setVisible(true);
				app.getrdbtnNewRadioButton7().setVisible(true);
				app.getrdbtnNewRadioButton8().setVisible(true);
				app.getrdbtnNewRadioButton9().setVisible(true);*/
				break;
				
			case "Elimination":
				//app.gettextField_12().setVisible(false);
				//app.getlblStar_2().setVisible(false);
				app.getlblVariable().setText("moves");
				app.getlblBucketColumns().setVisible(false);
				for (int i = 0; i < 9; i++){
					app.getBucketColumn(i).setVisible(false);;
				}
				app.gettextField_16().setEnabled(true);
				Integer prob3 = (Integer) Integer.valueOf(app.gettextField_16().getText());
				app.getLevel().getBoard().getTileGen().setTileProb(5, prob3);
				/*app.getlblBucketColumns().setVisible(false);
				app.getrdbtnNewRadioButton1().setVisible(false);
				app.getrdbtnNewRadioButton2().setVisible(false);
				app.getrdbtnNewRadioButton3().setVisible(false);
				app.getrdbtnNewRadioButton4().setVisible(false);
				app.getrdbtnNewRadioButton5().setVisible(false);
				app.getrdbtnNewRadioButton6().setVisible(false);
				app.getrdbtnNewRadioButton7().setVisible(false);
				app.getrdbtnNewRadioButton8().setVisible(false);
				app.getrdbtnNewRadioButton9().setVisible(false);*/
				break;
		}
		
		app.revalidate();
		app.repaint();
	}
}
