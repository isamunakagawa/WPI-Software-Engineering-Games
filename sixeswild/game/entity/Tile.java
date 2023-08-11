package game.entity;
/**
 * Tile Class are part of Squares objects
 * and involved in player moves and gravity.
 * 
 * 
 * 
 * 
 */
public class Tile {
	/**Value of the tile.*/
	private int value; 
	
	/**Multiplier of the tile.*/
	private int multiplier; 
	
	/**
	 * Tile constructor that creates a tile object,
	 * given a value and a multiplier.
	 * @param value
	 * @param multiplier
	 */
	public Tile(int value, int multiplier){
		this.value = value;
		this.multiplier = multiplier;
		//checks if the given value is invalid.
		if (this.value < 0) {
			throw new RuntimeException("invalid score");
		}
		//checks if the multiplier is invalid.
		if (this.multiplier > 3 || this.multiplier < 1) {
			throw new RuntimeException("invalid multiplier");
		}
	}
	
	/**Returns the value of the tile.*/
	public int getValue(){ 
		return this.value;
	}
	
	/**Returns the multiplier of the tile.*/
	public int getMultiplier(){ 
		return this.multiplier;
	}
}
