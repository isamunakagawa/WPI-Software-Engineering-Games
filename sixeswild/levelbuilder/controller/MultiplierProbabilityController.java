package levelbuilder.controller;

import levelbuilder.entities.Level;
import levelbuilder.view.LevelBuilderView;

/**
 * Controller that handles setting the multiplier 
 * probabilities.
 * 
 *
 */
public class MultiplierProbabilityController extends EditController{
	
	/** The given level for modification.*/
	Level level;
	
	/** The builder view.*/
	LevelBuilderView builder;
	
	int index;
	
	int prob;
	
	int prevProb;
	
	/***
	 * Constructor that creates a controller for 
	 * the multiplier probability.
	 * @param level, Level
	 * @param builder, Boundary
	 */
	public MultiplierProbabilityController(Level level, LevelBuilderView builder){
		this.level = level;
		this.builder = builder;
	}
	
	/**
	 * Sets the multiplier probability for the tile generator
	 * within board.
	 * @param index, int
	 * @param prob, desired probability as integer
	 */
	public void setMultProb(int index, int prob, int prevProb){
		level.getBoard().getTileGen().setMultProb(index, prob);
		this.index = index;
		this.prob = prob;
		this.prevProb = prevProb;
		this.level.addEdit(this);
		this.level.getUndoneEdits().clear();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		level.getBoard().getTileGen().setMultProb(index, prevProb);
		EditController add = this.level.getMostRecentEdit();
		this.level.addUndo(add);
		this.level.getEdits().removeElementAt(0);
		String undo = (String) String.valueOf(prevProb);
		if (index == 1){
			this.builder.gettextField_6().setText(undo);
		}
		else if (index == 2){
			this.builder.gettextField_7().setText(undo);
		}
		else {
			this.builder.gettextField_8().setText(undo);
		}
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		level.getBoard().getTileGen().setMultProb(index, prob);
		EditController add = this.level.getMostRecentUndo();
		this.level.addEdit(add);
		this.level.getUndoneEdits().removeElementAt(0);
		String redo = (String) String.valueOf(prob);
		if (index == 1){
			this.builder.gettextField_6().setText(redo);
		}
		else if (index == 2){
			this.builder.gettextField_7().setText(redo);
		}
		else {
			this.builder.gettextField_8().setText(redo);
		}
	}
	
	/*public void actionPerformed(ActionEvent e){
		JTextField tf1 = builder.getMult1();
		JTextField tf2 = builder.getMult2();
		JTextField tf3 = builder.getMult3();
		
		int oneMult = Integer.valueOf(tf1.getText());
		int twoMult = Integer.valueOf(tf2.getText());
		int threeMult = Integer.valueOf(tf3.getText());
		
		level.getBoard().getTileGen().setMultProb(0, oneMult);
		level.getBoard().getTileGen().setMultProb(1, twoMult);
		level.getBoard().getTileGen().setMultProb(2, threeMult);
	}*/
}
