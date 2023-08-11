package game.controller;

import game.entity.Selection;
import game.entity.Square;
import game.entity.Tile;
/**
 * 
 * 
 * 
 */
public class PuzzleMove {
	
	/** The player's selection.*/
	protected Selection selection = new Selection();
	
	/** Puzzle move constructor that records the player's selection
	 * and creates a move.*/
	public PuzzleMove(Tile tile, Square square){
		this.selection.addTile(tile);
		this.selection.addSquare(square);
	}

	/**
	 * Checks to see if a tile can be added to the selection,
	 * returning true if successful.
	 * @param tile
	 * @return
	 */
	public boolean addToSelection(Tile tile){
		return selection.addTile(tile);
	}
	
	/**
	 * Checks to see if a square is in the selection.
	 * @param square
	 * @return
	 */
	public boolean inSelection(Square square) {
		return selection.inSelection(square);
	}

	/**
	 * Adds a square to the selection object.
	 * @param currentSquare
	 */
	public void addToSqSelection(Square currentSquare) {
		this.selection.addSquare(currentSquare);
	}
}
