package game.controller;

import game.entity.Board;
import game.entity.Level;
import game.entity.Mode;
import game.entity.Tile;
import game.entity.Square;
import game.entity.TileGenerator;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * Controller that handles loading
 * of level data from the file system.
 * 
 * 
 *
 */
public class LoadController {
	private Level level;
	
	Properties props = new Properties();
	private String mode = "", buckets = "", inactives = "";
	private int countdown = 0, goalscore[] = new int[3], multProb[] = new int [3], valProb[] = new int [6];
	
	public LoadController(){
		
	}
	
	public Level loadLevel(String fname){
		if(!readFromFile(fname))
			throw new RuntimeException("Could not open file");
		if(!getProps())
			throw new RuntimeException("Properties not properly set");
		instantiateLevel();
		return this.level;
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
	
	private boolean getProps(){
		try{
			mode = props.getProperty("Mode");
			buckets = props.getProperty("Buckets");
			inactives = props.getProperty("Inactives");
			countdown = Integer.parseInt(props.getProperty("Countdown"));
			for(int i = 0; i <= 2; i++)
				goalscore[i] = Integer.parseInt(props.getProperty("GoalScore"+(i+1)));
			for(int i = 0; i <= 2; i++)
				multProb[i] = Integer.parseInt(props.getProperty("MultiplierProbability"+(i+1)));
			for(int i = 0; i <= 5; i++)
				valProb[i] = Integer.parseInt(props.getProperty("ValueProbability"+(i+1)));
			return true;
		} catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	private void instantiateLevel(){
		this.level = new Level(new Board(new TileGenerator(this.multProb, this.valProb)), new Mode(Mode.gameMode.valueOf(this.mode), this.countdown), this.goalscore);
		String inactiveIndices[] = inactives.split(",");
		if ( !inactiveIndices[0].isEmpty() ){
			for(int i = 0; i < inactiveIndices.length; i++){
				this.level.getBoard().getSquare(Integer.parseInt(inactiveIndices[i])).setActive(false);
			}
		}
		if( this.level.getMode().isRelease() ){
			String bucketIndices[] = buckets.split(",");
			for(int i = 0; i < bucketIndices.length; i++)
				this.level.getBoard().getSquare(Integer.parseInt(bucketIndices[i])).setBucket(true);
		}
		Square[][] squares = this.level.getBoard().getSquares();
		for(int w = 0; w < squares.length; w++){
			for (int x = 0; x < squares.length; x++){
				if (squares[w][x].isBucket()){
					for (int z=0; z < w; z++){
						if (squares[z][x].isActive() ){
							squares[z][x].setTile(new Tile(6, 1));
							break;
						}
					}
				}
			}
		}
	}
}
