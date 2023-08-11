package levelbuilder.controller;

import java.io.FileInputStream;
import java.util.Properties;

import levelbuilder.entities.Level;

/**
 * Controller that handles loading a level from the 
 * file system.
 * 
 *
 */
public class LoadController {
	
	/** The Level to load.*/
	Level level;
	
	Properties props = new Properties();
	
	/** The values being taken from the stored file.*/
	private String mode = "", buckets = "", inactives = "";
	
	/** The persistent information needed to be loaded for a level, taken
	 * from the file stored.*/
	private int countdown = 0, goalscore[] = new int[3], multProb[] = new int [3], valProb[] = new int [6];
	
	/**
	 * Constructor that creates a controller for loading a level.
	 * @param level, Level to be loaded
	 * @param builder, builder View
	 */
	public LoadController(Level level){
		this.level = level;
	}
	
	/**
	 * Checks if the level can be found on file.
	 * @param fname, file name (String)
	 * @return true if the file can be loaded and loads it, false otherwise.
	 */
	public boolean loadLevel(String fname){
		if(!readFromFile(fname))
			return false;
		if(!getProps())
			return false;
		setValues();
		return true;
	}
	
	/**
	 * Loads in the information stored on file.
	 * @param fname, file name
	 * @return true if the read from file was successful, false otherwise.
	 */
	private boolean readFromFile(String fname){
		try{
			props.load(new FileInputStream(fname));
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Retrieves the information stored on file by searching for 
	 * atributes and parsing the values.
	 * @return true if the information was retrieved, false otherwise.
	 */
	private boolean getProps(){
		try{
			mode = props.getProperty("Mode");
			buckets = props.getProperty("Buckets");
			inactives = props.getProperty("Inactives");
			countdown = Integer.parseInt(props.getProperty("Countdown"));
			for(int i = 0; i < 3; i++)
				goalscore[i] = Integer.parseInt(props.getProperty("GoalScore"+(i+1)));
			for(int i = 0; i < 3; i++)
				multProb[i] = Integer.parseInt(props.getProperty("MultiplierProbability"+(i+1)));
			for(int i = 0; i < 6; i++)
				valProb[i] = Integer.parseInt(props.getProperty("ValueProbability"+(i+1)));
			return true;
		} catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Sets the corresponding attributes of a level 
	 * to appropriate values as obtained from the file.
	 */
	private void setValues(){
		level.getMode().setType(this.mode);
		level.getMode().setCountdown(countdown);
		
		String bucketIndices[] = buckets.split(",");
		if(!bucketIndices[0].isEmpty()) for(int i = 0; i < bucketIndices.length; i++)
			level.getBoard().getSquare(Integer.parseInt(bucketIndices[i])).setBucket(true);
		
		String inactiveIndices[] = inactives.split(",");
		if(!inactiveIndices[0].isEmpty()) for(int i = 0; i < inactiveIndices.length; i++)
			level.getBoard().getSquare(Integer.parseInt(inactiveIndices[i])).setActive(false);
		
		for(int i = 0; i < 3; i++)
			level.setGoalScore(i+1, this.goalscore[i]);
		for(int i = 0; i < 3; i++)
			level.getBoard().getTileGen().setMultProb(i+1, this.multProb[i]);
		for(int i = 0; i < 3; i++)
			level.getBoard().getTileGen().setTileProb(i+1, this.valProb[i]);
	}
}
