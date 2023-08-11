package game.controller;

import game.entity.Level;
import game.entity.Square;
import game.view.LevelView;

/**
 * Controller for the Shuffle power up.
 * 
 *
 */
public class ShuffleBoardPowerUp {
	
	/** The given level.*/
	protected Level level;
	
	/** The boundary class associated with level.*/
	protected LevelView levelView;
	
	/**
	 * ShufflePowerUp constructor that creates a controller object
	 * that shuffles the board.
	 * @param level
	 * @param levelView
	 */
	public ShuffleBoardPowerUp(Level level, LevelView levelView){
		this.level = level;
		this.levelView = levelView;
	}
	
	/**
	 * Allows the player to shuffle the board by iterating 
	 * through squares.
	 */
	public void ShuffleBoard(){
		this.level.useResetMove();
		//first nested loop goes through board and destroys all tiles of active squares
		for (int i = 0; i <= 8; i++){
			for (int j = 0; j <= 8; j++){
				Square current = this.level.getBoard().getSquare(i, j);
				if ( current.isActive() && (current.getTile().getValue() != 6) && !current.isBucket() ){
					current.destroyTile();
				} // end if statement
			} // end j loop
		} // end i loop
		//all tiles have been destroyed at this point
		//time to refill
		this.level.getBoard().fillBoard();
		this.levelView.getCountdownLabel().setText(new Integer(this.level.getMode().getCountdown()).toString());
		this.levelView.getBoardView().updateColors();
		this.levelView.repaint();
	
	} // end method
}
