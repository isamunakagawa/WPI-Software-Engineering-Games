package levelbuilder.controller;

import levelbuilder.entities.Level;
import levelbuilder.view.Application;

/**
 * Controller that handles the count down for either
 * moves left or timer.
 *  
 *
 */
public class CountdownController extends EditController{
	
	/** Level*/
	protected Level level;
	
	/** The given application*/
	protected Application application;
	
	int counter;
	int undoNum;

	/**
	 * Constructor for an object that handles the countdown
	 * @param level, Level
	 * @param application, levelbuilder app
	 */
	public CountdownController(Level level, Application application) {
		this.level = level;
		this.application = application;
	}

	/**
	 * Updates the countdown by using reference to level.
	 * @param recover 
	 * @param count, int
	 */
	public void updateCountdown(int count, int recover) {
		this.level.getMode().updateCountDown(count);
		counter = count;
		undoNum = recover;
		this.level.addEdit(this);
		this.level.getUndoneEdits().clear();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		this.level.getMode().updateCountDown(undoNum);
		String undo = (String) String.valueOf(undoNum);
		EditController add = this.level.getMostRecentEdit();
		this.level.addUndo(add);
		this.level.getEdits().removeElementAt(0);
		this.application.getLevelBuilderView().gettextField_9().setText(undo);
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		this.level.getMode().updateCountDown(counter);
		String redo = (String) String.valueOf(counter);
		EditController add = this.level.getMostRecentUndo();
		this.level.addEdit(add);
		this.level.getUndoneEdits().removeElementAt(0);
		this.application.getLevelBuilderView().gettextField_9().setText(redo);
	}

	/*@Override
	public void actionPerformed(ActionEvent arg0) {
		TextField tf = (TextField) arg0.getSource();
		update(tf);
	}

	void update(TextField tf){
		try {
		int num = Integer.valueOf(tf.getText());
		
		if (num > 100){
			num = 100;
		}
		if (num < 0){
			num = 0;
		}
		
		this.level.getMode().updateCountDown(num);
	}
	catch (Exception e) {
		// just put old value back in
		//tf.setText("" + value);
	}
	}*/
}
