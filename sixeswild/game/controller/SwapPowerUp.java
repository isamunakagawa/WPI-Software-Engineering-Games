package game.controller;

import game.entity.Square;


/**
 * 
 * 
 *
 */

import game.entity.Tile;

public class SwapPowerUp {

	/** The first selected square.*/
	protected Square square1;
	
	/** The second selected square.*/
	protected Square square2;
	
	/**
	 * SwapPowerUp constructor that 
	 * creates an object that handles swapping squares.
	 * @param square1
	 */
	public SwapPowerUp(Square square1){
		this.square1 = square1;
		
	}
	
	/**
	 * Selects the second square to swap.
	 * @param square2
	 */
	public void squareToSwap(Square square2) {
		this.square2 = square2;
	}
	
	/**
	 * Swaps the given two squares.
	 */
	public void swap(){
		
		if (square1 != null && square2 != null) {
		Tile temp = square1.getTile();
		square1.setTile(square2.getTile());
		square2.setTile(temp);
		}
	}
}
