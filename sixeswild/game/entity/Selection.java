package game.entity;

import java.util.ArrayList;
/**
 * Selection class that holds persistent information about the 
 * player's move selection.
 * 
 * 
 *
 */
public class Selection {
	/** ArrayList of tiles.*/
	protected ArrayList<Tile> tiles = new ArrayList<Tile>();
	
	/** ArrayList of squares in selection.*/
	protected ArrayList<Square> squares = new ArrayList<Square>();
	
	/**
	 * Function that adds a tile to the player selection.
	 * @param tile
	 * @return
	 */
	public boolean addTile(Tile tile) {
		if (!inSelection(tile)) { 
			tiles.add(tile); return true; 
		}
		
		else { return false; }
	}
	
	/**
	 * Function that adds a square to the player selection.
	 * @param tile
	 * @return true if the addition was made, false otherwise.
	 */
	public boolean addSquare(Square square) {
		if (!inSelection(square)) { 
			squares.add(square); 
			return true; 
		}
		
		else { return false; }
	}
	
	/**
	 * Clears the selection, clears the arraylist of tiles.
	 */
	public void clearCollection() {
		tiles.clear();
	}
	
	/**
	 * Clears the selection, clears the arraylist of squares.
	 */
	public void clearSqCollection() {
		squares.clear();
	}
	
	/**
	 * Function that checks if a tile is in the selection.
	 * @param tile, Tile.
	 * @return true if the tile is in the selection, false otherwise.
	 */
	public boolean inSelection(Tile tile) {
		return tiles.contains(tile);
	}
	
	/**
	 * Function that checks if a square is in the selection.
	 * @param tile, Tile.
	 * @return true if the square was in the selection.
	 */
	public boolean inSelection(Square square) {
		return squares.contains(square);
	}
	
	/**
	 * Sums the values of the tiles and returns sum.
	 * @return the sum of tile values.
	 */
	public int sumTiles() {
		int sum = 0;
		for (Tile tile:tiles){
			sum += tile.getValue();
		}
		return sum;
	}
	
	/**
	 * Checks the selection arrayList for a tile of value 6.
	 * @return true if the selection is valid, false otherwise.
	 */
	public boolean checkForSix() {
		if(tiles.size() >= 2 && sumTiles() == 6)
			return true;
		else
			return false;
	}
	
	/**
	 * Calculates the sum of the player selection, taking into
	 * account of multipliers.
	 * @return total score.
	 */
	public int calculateScore(){
		int score = 0;
		int multiplier = 1;
		for(Tile tile: tiles){
			multiplier = multiplier * tile.getMultiplier();
		}
		score = 10 * tiles.size() * multiplier;
		return score;
	}
	
	/**
	 * Getter for the collection tiles.
	 * @return collection of tiles.
	 */
	public  ArrayList<Tile> getTiles () {
		return this.tiles;
	}
	
	/**
	 * Getter for the collection of squares.
	 * @return collection of squares.
	 */
	public ArrayList<Square> getSquares() {
		return this.squares;
	}

	/**
	 * Unselects the squares.
	 */
	public void unSelect() {
		for (Square sq: this.squares) {
			sq.setSelected(false);
		}
	}
	
}
