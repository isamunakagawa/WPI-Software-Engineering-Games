package levelbuilder.entities;

import java.util.ArrayList;
/**
 * Selection class that holds persistent information about the 
 * player's move selection.
 *  
 * */
public class Selection {
	
	/** The collection of tiles.*/
	protected ArrayList<Tile> tiles = new ArrayList<Tile>();
	
	/** Adds a tile to the collection of tiles.*/
	public void addTile(Tile tile) {
		tiles.add(tile);
	}
	
	/** Clears the collection of tiles.*/
	public void clearCollection() {
		tiles.clear();
	}
	
	/** Returns the sum of all the values of the tiles.*/
	public int sumTiles() {
		int sum = 0;
		for (Tile tile:tiles){
			sum += tile.getValue();
		}
		return sum;
	}
	
	/** Returns true if the sum of tiles is 6
	 * false otherwise.*/
	public boolean checkForSix() {
		if(tiles.size() >= 2 && sumTiles() == 6)
			return true;
		else
			return false;
	}
	
	/**Returns the score, calculated by using mupltipliers.*/
	public int calculateScore(){
		int score = 0;
		int multiplier = 1;
		for(Tile tile: tiles){
			multiplier = multiplier * tile.getMultiplier();
		}
		score = 10 * tiles.size() * multiplier;
		return score;
	}
	
	/**Returns the collection of tiles.*/
	public  ArrayList<Tile> getTiles () {
		return this.tiles;
	}
}
