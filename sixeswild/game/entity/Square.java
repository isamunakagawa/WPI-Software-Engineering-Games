package game.entity;
/**
 * Square class represents the individual cells that
 * know their location.
 * 
 * 
 * 
 */

public class Square {
	/** Row and Column of Square on the board.*/
	int col, row;
	
	/** Current given tile residing in a square.*/
	Tile currentTile;
	
	/** Booleans that determine is a square is active, eliminated, a bucket, or selected.*/
	boolean active, eliminated, isBucket, hasUserSelected, hasFilled;
	
	/** Game mode of level.*/
	Mode mode;
	
	/**
	 * Square constructor that creates a square object 
	 * and sets some booleans characteristic to a square.
	 * @param row
	 * @param col
	 */
	public Square(int row, int col) {
		this.row = row;
		this.col = col;
		//default values for booleans are false
		this.active = true;
		this.eliminated = false;
		this.isBucket = false;
		this.hasUserSelected = false;
		this.hasFilled = false;
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
	public boolean isActive(){
		return this.active;
	}
	
	/**Getter for a square's bucket-ness.*/
	public boolean isBucket(){
		return this.isBucket;
	}
	
	/**
	 * Sets the selected to be active or not.
	 * @param flag, boolean of square's activeness
	 */
	public void setActive(boolean flag){
		this.active = flag;
	}
	
	/**
	 * Sets the selected square to be a bucket.
	 * @param flag, boolean
	 */
	public void setBucket(boolean flag){
		this.isBucket = flag;
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

	/**
	 * Checks if the square is selected.
	 * @return true if user selected, false otherwise.
	 */
	public boolean hasSelected() {
		return this.hasUserSelected;
	}

	/**
	 * Setter for the hasSelected attribute.
	 * @param b, boolean
	 */
	public void setSelected(boolean b) {
		this.hasUserSelected = b;
	}
	
	/**
	 * Checks if the bucket was filled.
	 * @return true if the bucket was given a six, false otherwise.
	 */
	public boolean getBucketFilled() {
		return this.hasFilled;
	}
	
	/**
	 * 
	 * @param tile, Tile given.
	 * @return true if the bucket received a six, false otherwise.
	 */
	public boolean acceptSix(Tile tile){
		if (this.isBucket && tile.getValue() == 6) {
			this.currentTile = tile;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Sets the isFilled parameter to be either true of false.
	 * @param b, given flag
	 */
	public void setFilled(boolean b) {
		this.hasFilled = b;
	}

}
