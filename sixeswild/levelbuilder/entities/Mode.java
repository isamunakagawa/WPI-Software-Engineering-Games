package levelbuilder.entities;
/**
 * Mode class handles the game mode of a level.
 *  
 *
 */
public class Mode {
	
	/** Enum data type of game modes.*/
	public static enum gameMode {PUZZLE, LIGHTNING, RELEASE, ELIMINATION}
	
	/** Game mode of the level.*/
	gameMode mode;
	
	/** The countdown representing either a timer of moves left.*/
	int countDown;
	
	/**
	 * Constructor that creates a mode object to contain
	 * the mode of the level and the starting count.
	 * @param mode, game mode.
	 * @param initialCount, starting count
	 */
	public Mode(gameMode mode, int initialCount){
		this.mode = mode;
		this.countDown = initialCount;
	}
	
	/**
	 * Decrements the moves left.
	 * Timer is handled separately.
	 */
	public void decrement(){
		if (this.countDown > 0) {
			this.countDown -= 1;
		}
	}
	
	/**
	 * Checks if the game is puzzle.
	 * @return true if puzzle, false otherwise.
	 */
	public boolean isPuzzle() {
		return this.mode == gameMode.PUZZLE;
	}
	
	/**
	 * Checks if the game is ligtning.
	 * @return true if lightning, false otherwise.
	 */
	public boolean isLightning() {
		return this.mode == gameMode.LIGHTNING;
	}
	
	/**
	 * Checks if the game is release.
	 * @return true if release, false otherwise.
	 */
	public boolean isRelease() {
		return this.mode == gameMode.RELEASE;
	}
	
	/**
	 * Checks if the game is elimination.
	 * @return true if elimination, false otherwise.
	 */
	public boolean isElimination() {
		return this.mode == gameMode.ELIMINATION;
	}
	
	/**
	 * Getter for the countdown attribute.
	 * @return the countdown value
	 */
	public int getCountdown() {
		return this.countDown;
	}
	
	/**
	 * Allows the user to set the initial countdown.
	 * @param cd, countDown
	 */
	public void updateCountDown(int cd){
		countDown = cd;
		System.out.println("Count now set to " + cd);
	}
	
	/**
	 * Given a string, sets the level game mode
	 * to the designated mode.
	 * @param mode, game mode
	 */
	public void setType(String mode){
		switch(mode){
		case "PUZZLE": case "Puzzle": this.mode = gameMode.PUZZLE; break;
		case "RELEASE": case "Release": this.mode = gameMode.RELEASE; break;
		case "ELIMINATION": case "Elimination": this.mode = gameMode.ELIMINATION; break;
		case "LIGHTNING": case "Lightning": this.mode = gameMode.LIGHTNING; break;
		
		default: System.out.println(mode); throw new RuntimeException("Unknown Mode");
		}
	}
	
	/**
	 * Allows the user to set the initial countdown.
	 * @param countdown, countDown
	 */
	public void setCountdown(int countdown){
		this.countDown = countdown;
	}
	
	/**
	 * Getter of the game mode type.
	 * @return the game mode in string form.
	 */
	public String getType(){
		return String.valueOf(this.mode);
	}
}
