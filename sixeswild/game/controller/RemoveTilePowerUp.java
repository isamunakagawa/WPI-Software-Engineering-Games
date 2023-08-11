package game.controller;

import game.entity.Level;
import game.entity.Selection;
import game.entity.Square;
import game.view.BoardView;

/**
 * RemoveTilePowerUp removes a tile given a square.
 *  
 *
 */

public class RemoveTilePowerUp {
	
	/** The given square.*/
	protected Square square;
	
	/** The given level.*/
	protected Level level;
	
	/** The given board view.*/
	protected BoardView bv;
	
	/**
	 * Constructor for the removeTileMove that handles the move.
	 * @param level
	 * @param square
	 */
	public RemoveTilePowerUp(Level level, BoardView bv, Square square){
		this.square = square;
		this.level = level;
		this.bv = bv;
	}

	/**
	 * Removes the tile from the given square and 
	 * signals to the system that a remove request is fulfilled.
	 */
	public void RemovePowerUp(){
		this.square.destroyTile();
		this.level.setRemoveActive(false);
		Selection temp = new Selection();
		temp.addSquare(this.square);
		GravityUpdateMove gum = new GravityUpdateMove(
				this.level.getBoard(), temp);
		gum.gravity();
		this.bv.revalidate();
	}
}
