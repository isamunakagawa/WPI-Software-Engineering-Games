package game.controller;

import game.entity.Level;
import game.view.LevelView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * RemoveButtonAction serves as an actionListener for 
 * the removePowerUp.
 * 
 *
 */
public class RemoveButtonAction implements ActionListener {
	
	/** The given level.*/
	protected final Level level;
	
	/** The levelView associated with the level.*/
	protected final LevelView levelView;
	
	/**
	 * Constructor that handles the actions for a removePowerUp.
	 * @param level
	 * @param levelView
	 */
	public RemoveButtonAction(Level level, LevelView levelView){
		super();
		this.level = level;
		this.levelView = levelView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//customized actionPerformed to remove a square.
		if ( this.level.useRemoveMove() ){
			this.level.setRemoveActive(true);
		}
	}

}
