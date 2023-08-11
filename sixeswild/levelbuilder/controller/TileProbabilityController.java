package levelbuilder.controller;

import levelbuilder.entities.Level;
import levelbuilder.view.LevelBuilderView;

/**
 * Controller that handles tile probabilities.
 * 
 *
 */
public class TileProbabilityController extends EditController{
	
	/** The given Level*/
	Level level;
	
	/** The level builder view.*/
	LevelBuilderView builder;
	
	int index;
	int prob;
	int prevProb;
	
	/**
	 * Constructor that creates a controller 
	 * to modify or access the tile probabilities of a level.
	 * @param level, Level
	 * @param builder, builder view
	 */
	public TileProbabilityController(Level level, LevelBuilderView builder){
		this.level = level;
		this.builder = builder;
	}
	
	/*public void actionPerformed(ActionEvent e){
		JTextField tf1 = builder.getProb1();
		JTextField tf2 = builder.getProb2();
		JTextField tf3 = builder.getProb3();
		JTextField tf4 = builder.getProb4();
		JTextField tf5 = builder.getProb5();
		JTextField tf6 = builder.getProb6();
		
		int probability[] = new int[6];
		probability[0] = Integer.valueOf(tf1.getText());
		probability[1] = Integer.valueOf(tf2.getText());
		probability[2] = Integer.valueOf(tf3.getText());
		probability[3] = Integer.valueOf(tf4.getText());
		probability[4] = Integer.valueOf(tf5.getText());
		probability[5] = Integer.valueOf(tf6.getText());
		
		for (int i = 0; i < 6; i++){
			level.getBoard().getTileGen().setTileProb(i, probability[i]);
		}
	}*/
	
	/**
	 * Sets the probability of the tile generator
	 * as desired by user.
	 * @param i, integer
	 * @param probability, desired probability
	 */
	public void updateProbability(int i, int probability, int prevProb){
		level.getBoard().getTileGen().setTileProb(i-1, probability);
		System.out.println("Value: " + i + " prob: " + level.getBoard().getTileGen().getValProb(i-1));
		this.index = i;
		this.prob = probability;
		this.prevProb = prevProb;
		this.level.addEdit(this);
		this.level.getUndoneEdits().clear();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		level.getBoard().getTileGen().setTileProb(index-1, prevProb);
		EditController add = this.level.getMostRecentEdit();
		this.level.addUndo(add);
		this.level.getEdits().removeElementAt(0);
		String undo = (String) String.valueOf(prevProb);
		if (index == 1){
			this.builder.gettextField().setText(undo);
		}
		else if (index == 2){
			this.builder.gettextField_1().setText(undo);
		}
		else if (index == 3){
			this.builder.gettextField_2().setText(undo);
		}
		else if (index == 4){
			this.builder.gettextField_13().setText(undo);
		}
		else if (index == 5){
			this.builder.gettextField_15().setText(undo);
		}
		else {
			this.builder.gettextField_16().setText(undo);
		}
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		level.getBoard().getTileGen().setTileProb(index-1, prob);
		EditController add = this.level.getMostRecentUndo();
		this.level.addEdit(add);
		this.level.getUndoneEdits().removeElementAt(0);
		String redo = (String) String.valueOf(prob);
		if (index == 1){
			this.builder.gettextField().setText(redo);
		}
		else if (index == 2){
			this.builder.gettextField_1().setText(redo);
		}
		else if (index == 3){
			this.builder.gettextField_2().setText(redo);
		}
		else if (index == 4){
			this.builder.gettextField_13().setText(redo);
		}
		else if (index == 5){
			this.builder.gettextField_15().setText(redo);
		}
		else {
			this.builder.gettextField_16().setText(redo);
		}
	}
	
	public int getIndex() {
		return index;
	}
	public int getProb() {
		return prob;
	}
	public int getPreProb() {
		return prevProb;
	}

}
