package game.controller;

import game.entity.Level;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
/**
 * Controller that handles saving and loading
 * of high scores from the file system.
 * 
 * 
 *
 */
public class RecordsController {
	private Properties props = new Properties();
	private int records[] = new int[20];
	private final String fname = "records.ini";
	
	public RecordsController(){
		if(!readFromFile(fname))
			throw new RuntimeException("Could not open file");
		if(!getProps())
			throw new RuntimeException("Properties not properly set");
	}
	
	public int findCurrentLevel(){
		int current_level = 1;
		for (int i = 0; i < 20; i++){
			if(records[i] == 0){
				current_level = i+1;
				break;
			}
		}
		return current_level;
	}
	
	public void stashLevelScore(Level level, int level_number){
		int newStars = level.goalsMet();
		if( newStars > 0) try{
			int oldStars = records[level_number-1];
			if(newStars > oldStars){
				props.setProperty("Level" + level_number, String.valueOf(newStars));
				writeToFile();
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
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
	
	private boolean writeToFile(){
		File file = new File(fname);
		try {
			FileOutputStream fstream = new FileOutputStream(file);
			props.store(fstream, "SixesWild Record Data");
			fstream.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean getProps(){
		try{
			for(int i = 0; i < 20; i++)
				records[i] = Integer.parseInt(props.getProperty("Level"+(i+1)));
			return true;
		} catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public int[] getRecords(){
		return records;
	}
}
