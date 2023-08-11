package game.controller;

import game.entity.Level;
import game.entity.Square;
import game.view.LevelView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * SwapBoardAction listens for an action
 * and alerts the system that a swap was requested.
 * 
 *
 */

public class SwapBoardAction implements ActionListener {

	/** The given level.*/
	protected final Level level;
	
	/** The view associated with the level.*/
	protected final LevelView levelView;
	
	/** The controller that handles all moves.*/
	protected MoveController moveController;
	
	/** The first selected square.*/
	protected Square square1;
	
	/** The second selected square.*/
	protected Square square2;
	
	/**
	 * Constructor that creates an object for handling swapPowerUp 
	 * requests.
	 * @param level
	 * @param levelView
	 * @param mc
	 */
	public SwapBoardAction(Level level, LevelView levelView, MoveController mc){
		super();
		this.level = level;
		this.levelView = levelView;
		this.moveController = mc;
	}
	
	/**
	 * Allows player to select a square.
	 * @param square1
	 */
	public void selectSquare1 (Square square1) {
		this.square1 = square1;
	}
	
	
	/**
	 * Allows the player to select the second square.
	 * @param square2
	 */
	public void selectSquare2 (Square square2) {
		this.square2 = square2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		level.swapActiveToggle(true);
		System.out.println("swapActiveToggle");
	}
}
