package levelbuilder.entities;

import levelbuilder.entities.Mode;
import levelbuilder.entities.Tile;
/**
 * Square class represents the individual cells that
 * know their location.
 * 
 *
 */
public class Square {
	
	/** Row and Column of Square on the board.*/
	int col, row;
	
	/** Current given tile residing in a square.*/
	Tile currentTile;
	
	/** Booleans that determine is a square is active, eliminated, a bucket, or selected.*/
	boolean active, eliminated, isBucket, hasUserSelected;
	
	/** Game mode of level.*/
	Mode mode;
	
	/**
	 * Square constructor that creates a square object 
	 * and sets some booleans characteristic to a square.
	 * @param row
	 * @param col
	 */
	public Square(int row, int col) {
		this.col = col;
		this.row = row;
		//default values for booleans are false
		this.active = true;
		this.eliminated = false;
		this.isBucket = false;
		this.hasUserSelected = false;
	}
	
	/**Checks if a square is currently empty.*/
	public boolean isEmpty() {
		return this.currentTile == null;
	}
	
	/** Sets the current tile to null.*/
	public void destroyTile() {
		this.currentTile = null;
	}
	
	/**Getter for a square's tile.*/
	public Tile getTile() {
		return this.currentTile;
	}
	
	/**Sets the square's tile to another tile.*/
	public void setTile(Tile tile) {
		this.currentTile = tile;
	}
	
	/** Getter for a square's column.*/
	public int getCol() { return this.col; }
	
	/**Getter for a square's row.*/
	public int getRow() { return this.row; }
	
	/**Getter for a square's active.*/
	public boolean getActive(){
		return this.active;
	}
	
	/**
	 * Sets the selected to be active or not.
	 * @param flag, boolean of square's activeness
	 */
	public void setActive(boolean active){
		this.active = active;
	}
	
	/**Getter for a square's bucket-ness.*/
	public boolean getBucket(){
		return this.isBucket;
	}
	
	/**
	 * Sets the selected square to be a bucket.
	 * @param flag, boolean
	 */
	public void setBucket(boolean bucket){
		this.isBucket = bucket;
		System.out.println((this.row+1) + " " + (this.col+1) + " bucket: " + bucket);
	}
	
	/**
	 * Checks the square during elimination.
	 * @return true if the square has been eliminated, false otherwise.
	 */
	public boolean isEliminated() {
		return this.eliminated;
	}
	
	/**
	 * Sets the square to be eliminated.
	 */
	public void setEliminated() {
		this.eliminated = true;
	}
}
