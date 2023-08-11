package levelbuilder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import levelbuilder.entities.Level;
import levelbuilder.view.Application;
import levelbuilder.view.LevelBuilderView;

/**
 * Controller that updates the mode.
 * 
 *
 */
public class ModeController extends EditController{
	
	/** The level given.*/
	protected Level level;
	
	/** The given application.*/
	protected Application application;
	
	String mode;
	
	String prevMode;

	/**
	 * Constructor that creates a controller to 
	 * change or access the game mode.
	 * @param level, Level
	 * @param application, Top-level Boundary
	 */
	public ModeController(Level level, Application application) {
		this.level = level;
		this.application = application;
	}

	/**
	 * Allows the user to update/change the game mode.
	 * @param mode, mode of the level.
	 */
	public void updateMode(String mode, String prevMode) {
		this.level.getMode().setType(mode);
		System.out.println("Mode updated: " + mode);
		this.mode = mode;
		this.prevMode = prevMode;
		this.level.addEdit(this);
		this.level.getUndoneEdits().clear();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		this.level.getMode().setType(prevMode);
		EditController add = this.level.getMostRecentEdit();
		this.level.addUndo(add);
		this.level.getEdits().removeElementAt(0);
		this.application.getLevelBuilderView().setModeBoolean(false);
		//final JComboBox comboBox = this.application.getLevelBuilderView().getComboBox();
		//this.application.getLevelBuilderView().getComboBox().removeActionListener(null);
		this.application.getLevelBuilderView().getComboBox().setSelectedItem(prevMode);
		new SelectGameTypeController(this.application.getLevelBuilderView()).selectType(prevMode);
		//this.level.getEdits().removeElementAt(0); //setSelectedItem creates an action event that needs to be removed
		this.application.getLevelBuilderView().setModeBoolean(true);
		/*this.application.getLevelBuilderView().getComboBox().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String selection = (String) comboBox.getSelectedItem();
				new SelectGameTypeController(application.getLevelBuilderView()).selectType(selection);
				ModeController mode = new ModeController (level, application);
				mode.updateMode(selection, application.getLevelBuilderView().getModeRecovery());
				String modeRecover = application.getLevelBuilderView().getModeRecovery();
				modeRecover = (String) selection;
			} 
				
				
		});*/
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		this.level.getMode().setType(mode);
		EditController add = this.level.getMostRecentUndo();
		this.level.addEdit(add);
		this.level.getUndoneEdits().removeElementAt(0);
		this.application.getLevelBuilderView().setModeBoolean(false);
		//final JComboBox comboBox = this.application.getLevelBuilderView().getComboBox();
		//this.application.getLevelBuilderView().getComboBox().removeActionListener(null);
		this.application.getLevelBuilderView().getComboBox().setSelectedItem(mode);
		new SelectGameTypeController(this.application.getLevelBuilderView()).selectType(mode);
		//this.level.getEdits().removeElementAt(0); //setSelectedItem creates an action event that needs to be removed
		this.application.getLevelBuilderView().setModeBoolean(true);
	}

	/*@Override
	public void actionPerformed(ActionEvent e) {
		TextField tf = (TextField) e.getSource();
		update(tf);
	}

	void update(TextField tf) {
		try {
			String modeName = tf.getText();
			this.level.getMode().setType(modeName);
		} catch (Exception e) {
			// just put old value back in
			// tf.setText("" + value);
		}
	}*/
}