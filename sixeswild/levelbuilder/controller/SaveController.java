package levelbuilder.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

import levelbuilder.entities.Level;
import levelbuilder.entities.Square;

/**
 * Controller that handles saving information of a level 
 * to the file system.
 * 
 *
 */
public class SaveController {
	
	/** The level to be saved.*/
	Level level;
	
	Properties props = new Properties();
	
	/** Properties to be saved like the mode, buckets, and inactive squares.*/
	private String mode = "", buckets = "", inactives = "";
	
	/** The properties that can be saved as integer values like countdown, goalScores, and probabilities.*/
	private int countdown = 0, goalscore[] = new int[3], multProb[] = new int [3], valProb[] = new int [6];
	
	/**
	 * Constructor that creates a controller for saving levels.
	 * @param level, Level
	 * @param builder, builder view
	 */
	public SaveController(Level level){
		this.level = level;
	}
	
	/**
	 * Allows the user to save a level.
	 * @param fname, file name
	 * @return true if the file name is found, false otherwise.
	 */
	public boolean saveLevel(String fname){
		if(fname == null)
			return false;
		gatherValues();
		setProps();
		return writeToFile(fname);
	}
	
	/**
	 * Gathers the necessary information to store on file
	 * for the level.
	 */
	public void gatherValues(){
		mode = level.getMode().getType();
		countdown = level.getMode().getCountdown();
		buckets = "";
		inactives = "";
		for(int i = 0; i < 81; i++){
			//record the squares.
			Square sq = level.getBoard().getSquare(i);
			if(!sq.getActive())
				inactives += String.valueOf(i) + ",";
			if(sq.getBucket())
				buckets += String.valueOf(i) + ",";
		}
		//stores the goal scores
		for(int i = 0; i< 3; i++){
			goalscore[i] = level.getGoalScore(i);
		}
		//store the multiplier probabilities
		for(int i = 0; i< 3; i++){
			multProb[i] = level.getBoard().getTileGen().getMultProb(i);
		}
		//store the value probability
		for(int i = 0; i< 6; i++){
			valProb[i] = level.getBoard().getTileGen().getValProb(i);
		}
	}
	
	/**
	 * Converts all information to strings
	 * in order to save to file.
	 */
	public void setProps(){
		props.setProperty("Mode", mode);
		props.setProperty("Buckets", buckets);
		props.setProperty("Inactives", inactives);
		props.setProperty("Countdown", Integer.toString(countdown));
		for(int i = 0; i < 3; i++)
			props.setProperty("GoalScore"+(i+1), Integer.toString(goalscore[i]));
		for(int i = 0; i < 3; i++)
			props.setProperty("MultiplierProbability"+(i+1), Integer.toString(multProb[i]));
		for(int i = 0; i < 6; i++)
			props.setProperty("ValueProbability"+(i+1), Integer.toString(valProb[i]));
	}
	
	/**
	 * Stores the information of a level onto the file system.
	 * @param fname, file name
	 * @return true if the saving was successful, false otherwise.
	 */
	private boolean writeToFile(String fname){
		File file = new File(fname);
		try {
			FileOutputStream fstream = new FileOutputStream(file);
			props.store(fstream, "SixesWild Level Data");
			fstream.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
