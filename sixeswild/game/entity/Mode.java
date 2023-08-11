package game.entity;
/**
 * 
 * 
 *
 */
public class Mode {
	/** Enum type of different game modes.*/
	public enum gameMode {PUZZLE, LIGHTNING, RELEASE, ELIMINATION}
	
	/** Game mode for the level.*/
	gameMode mode;
	
	/**Countdown associated with the game mode.*/
	int countDown;
	
	/**
	 * Game mode constructor that creates a mode object, 
	 * given its parameters.
	 * @param mode, gameMode enum type
	 * @param initialCount
	 */
	public Mode(gameMode mode, int initialCount){
		this.mode = mode;
		this.countDown = initialCount;
	}
	
	/** Decrements the countdown amount.*/
	public void decrement(){
		if (this.countDown > 0) {
			this.countDown -= 1;
		}
		System.out.println(this.countDown);
	}
	
	/**Boolean function that checks if the game mode is Puzzle.*/
	public boolean isPuzzle() {
		Boolean bool = this.mode == gameMode.PUZZLE;
		System.out.println(bool);
		return bool;
	}
	
	/**Boolean function that checks if the game mode is Lightning.*/
	public boolean isLightning() {
		return this.mode == gameMode.LIGHTNING;
	}
	
	/**Boolean function that checks if the game mode is Release.*/
	public boolean isRelease() {
		return this.mode == gameMode.RELEASE;
	}
	
	/**Boolean function that checks if the game mode is Elimination.*/
	public boolean isElimination() {
		return this.mode == gameMode.ELIMINATION;
	}
	
	/**Returns the countdown value.*/
	public int getCountdown() {
		return this.countDown;
	}
}
