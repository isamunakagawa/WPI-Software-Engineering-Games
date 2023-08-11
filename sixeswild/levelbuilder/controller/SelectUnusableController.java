package levelbuilder.controller;

import levelbuilder.entities.Level;
import levelbuilder.view.Application;

/**
 * Controller that manages which squares are inert.
 * 
 *
 */
public class SelectUnusableController extends EditController{
	
	/** The given level.*/
	protected Level level;
	
	/** The given application to be modified.*/
	protected Application application;
	
	protected int i;
	protected int j;
	protected boolean active;
	
	/**
	 * Constructor that creates a controller object that 
	 * handles selecting unusable squares.
	 * @param level, Level
	 * @param application, Application Boundary class
	 */
	public SelectUnusableController(Level level, Application application){
		this.level = level;
		this.application = application;
	}
	
	/*public void actionPerformed(ActionEvent e){
		JToggleButton[][] activeSquare = new JToggleButton[9][9];
		boolean[][] active = new boolean[9][9];
		
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				active[i][j] = activeSquare[i][j].isSelected();

				level.getBoard().getSquare(i, j).setActive(!active[i][j]);
			}
		}
	}*/
	
	/**
	 * Allows the user to set designated 
	 * square to be active or not.
	 * @param i, row
	 * @param j, column
	 * @param active, boolean
	 */
	public void makeUnusable(int i, int j, boolean active){
		level.getBoard().getSquare(i, j).setActive(!active);
		System.out.println("Square " + i + " " + j + " now " + active);
		this.i = i;
		this.j = j;
		this.active = active;
		this.level.addEdit(this);
		this.level.getUndoneEdits().clear();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		level.getBoard().getSquare(i, j).setActive(active);
		EditController add = this.level.getMostRecentEdit();
		this.level.addUndo(add);
		this.level.getEdits().removeElementAt(0);
		application.getLevelBuilderView().getActiveSquare(i, j).setSelected(!active);
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		level.getBoard().getSquare(i, j).setActive(!active);
		EditController add = this.level.getMostRecentUndo();
		this.level.addEdit(add);
		this.level.getUndoneEdits().removeElementAt(0);
		application.getLevelBuilderView().getActiveSquare(i, j).setSelected(active);
	}
	
	public int getI() {
		return i;
	}
	
	public int getJ() {
		return j;
	}
}
