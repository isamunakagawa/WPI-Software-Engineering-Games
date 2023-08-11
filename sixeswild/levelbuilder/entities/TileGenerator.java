package levelbuilder.entities;

import java.util.Random;
/**
 * TileGenerator was used for creating tile objects based
 * on given probabilities.
 * 
 * 
 *
 */
public class TileGenerator {
	/** Array of value probabilities.*/
	protected int[] valProbabilities = new int[6];
	
	/** Array of multiplier probabilities.*/
	protected int[] multProbabilities = new int[3];
	
	/** Sums to check for percentages.*/
	private int valSum, multSum;
	
	/**
	 * Tile generator constructor that creates 
	 * tile generator object given information about a level.
	 * @param multProb, multiplier probabilities.
	 * @param valProb, value probabilities.
	 */
	public TileGenerator() {
		initialize();
		// initialize(); read from file
	}

	/**
	 * Creates a new tile object based on value probability
	 * and multiplier probability.
	 * @return a tile based on the probability of values and multipliers.
	 */
	public Tile makeNewTile(){ //generates a new tile for the board
		this.initialize();
		Random r = new Random();
		
		int val = 0; //value of the Tile
		int mult = 0; //multiplier of the Tile
		
		int probTracker = 0; //value for tracking the probability
		
		int valMaker = (r.nextInt(valSum)) + 1; //nextInt(valSum) produces an int between 0 and the sum of all the value probs
		int multMaker = (r.nextInt(multSum)) + 1; //nextInt(multSum) produces an int between 0 and sum of all the mult probs
		
		for (int i = 0; i <= 5; i++){
			probTracker += valProbabilities[i]; //adds the previous probabilities to the current probability
			if (valMaker <= probTracker){ //if the current probability is greater than the number generated, then it sets the value equal to the associated number
				val = i + 1;
				break; //breaks out of the for loop
			}
		}
		
		probTracker = 0;
		
		for (int j = 0; j <= 2; j++){
			probTracker += multProbabilities[j]; //adds the previous probabilities to the current probability
			if (multMaker <= probTracker){ //if the current probability is greater than the number generated, then it sets the value equal to the associated number
				mult = j + 1;
				break; //breaks out of the for loop
			}
		}
		
		Tile tile = new Tile(val, mult); //generates a new tile based on the generated values
		return tile; //returns the new tile
	}
	
	/**
	 * Initializes the sums based on the arrays of value
	 * and multiplier.
	 */
	public void initialize(){
		valSum = 0;
		multSum = 0;
		for (int i=0; i < 6; i++ ){
			valSum += valProbabilities[i];
		}
		
		for (int j = 0; j < 3; j++){
			multSum += multProbabilities[j];
		}
	}
	
	/** Allows user to set the multiplier probabilities.*/
	public void setMultProb(int index, int prob){
		this.multProbabilities[index-1] = prob;
		System.out.println("Multiplier: " + index + " prob: " + prob);
	}
	
	/** Sets the probabilities of tile values.*/
	public void setTileProb(int index, int prob){
		this.valProbabilities[index] = prob;
	}
	
	/** Returns the multiplier probability by index.*/
	public int getMultProb(int index){
		return multProbabilities[index];
	}
	
	/**Returns the value probabilities by index.*/
	public int getValProb(int index){
		return valProbabilities[index];
	}
}
