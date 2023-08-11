package game.entity;
import java.util.Random;

/**
 * TileGenerator was used for creating tile objects based
 * on given probabilities.
 * 
 * 
 * 
 *
 */
public class TileGenerator {
	/** Array of value probabilities.*/
	int[] valProbabilities = new int[6];
	
	/** Array of multiplier probabilities.*/
	int[] multProbabilities = new int[3];
	
	/** Sums to check for percentages.*/
	private int valSum;
	private int multSum;
	
	/**
	 * Tile generator constructor that creates 
	 * tile generator object given information about a level.
	 * @param multProb, multiplier probabilities.
	 * @param valProb, value probabilities.
	 */
	public TileGenerator(int[] multProb, int[] valProb) {
		this.multProbabilities = multProb;
		this.valProbabilities = valProb;
		initialize();
		// initialize(); read from file
	}

	/**
	 * Creates a new tile object based on value probability
	 * and multiplier probability.
	 * @return a tile based on the probability of values and multipliers.
	 */
	public Tile makeNewTile(){ 
		Random r = new Random();
		
		int val = 0; //value of the Tile
		int mult = 0; //multiplier of the Tile
		
		int probTracker = 0; //value for tracking the probability
		
		int valMaker = (r.nextInt((valSum - 1) + 1)+1); //nextInt(valSum) produces an int between 0 and the sum of all the value probs
		int multMaker = (r.nextInt((multSum - 1) + 1)+1); //nextInt(multSum) produces an int between 0 and sum of all the mult probs
	
		
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
		for (int i=0; i <= 5; i++ ){
			valSum += valProbabilities[i];
		}
		
		for (int j = 0; j <= 2; j++){
			multSum += multProbabilities[j];
		}
	}
}