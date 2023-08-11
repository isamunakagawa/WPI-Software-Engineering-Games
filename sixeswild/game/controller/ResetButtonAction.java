package game.controller;

import game.entity.Level;
import game.view.LevelView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * An customized action listener for the reset board/
 * shufflePowerUp.
 * 
 *
 */
public class ResetButtonAction implements ActionListener {

	/** The given level.*/
	protected final Level level;
	
	/** The boundary associated with the level.*/
	protected final LevelView levelView;
	
	/**
	 * Constructor that creates a button action for the 
	 * shufflePowerUp.
	 * @param level
	 * @param levelView
	 */
	public ResetButtonAction(Level level, LevelView levelView){
		super();
		this.level = level;
		this.levelView = levelView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new ShuffleBoardPowerUp(this.level, this.levelView).ShuffleBoard();
	}
}
