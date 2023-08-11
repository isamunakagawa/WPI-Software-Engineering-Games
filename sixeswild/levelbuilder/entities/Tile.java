package levelbuilder.entities;
/**
 * Tile Class are part of Squares objects
 * and involved in player moves and gravity.
 * 
 * */
public class Tile {

	/** Value of the tile.*/
	private int value; 
	
	/** Multiplier of the tile.*/
	private int multiplier; 
	
	/**
	 * Constructor for a tile object to store values and multipliers.
	 * @param value, integer associated with tile.
	 * @param multiplier, score multiplier.
	 */
	public Tile(int value, int multiplier){
		this.value = value;
		this.multiplier = multiplier;
		if (this.value < 0) {
			throw new RuntimeException("invalid score");
		}
		if (this.multiplier > 3 || this.multiplier < 1) {
			throw new RuntimeException("invalid multiplier");
		}
	}
	
	/** Returns the value of the tile.*/
	public int getValue(){ 
		return this.value;
	}
	
	/** Returns the multiplier of the tile*/
	public int getMultiplier(){ 
		return this.multiplier;
	}
}
