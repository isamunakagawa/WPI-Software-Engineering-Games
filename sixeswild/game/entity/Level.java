package game.entity;

/**
 * Level class holds all needed information in order to play
 * a game.
 * 
 * 
 * 
 *
 */

public class Level {
	/** The board that holds the collection of squares.*/
	protected Board board;
	
	/** The game mode of the level, either Puzzle, Lightning, Release, or Elimination.*/
	protected Mode mode;
	
	/** The score acquired by the player.*/
	protected int score;
	
	/** Player's selection of tiles.*/
	protected Selection selectionStack = new Selection();
	
	/** The score thresholds*/
	protected int[] goalScore = new int[3];
	
	/** For both the swap and remove numbers, these are the amounts
	 * of power-ups given to the player initially.*/
	protected int swapTileNum;
	protected int removeTileNum;
	
	protected boolean removePowerUpActive;
	
	/** prevent a selection, and perform a swap power up move */
	private boolean swapActive = false;
	
	/**
	 * Level constructor that creates a level.
	 * Its removeTileNum and swapTileNum are set automatically to 1.
	 * @param board
	 * @param mode
	 * @param score
	 * @param goalScore
	 */
	public Level( Board board, Mode mode, int[] goalScore) {
		this.board = board;
		this.mode = mode;
		this.goalScore = goalScore;
		removeTileNum = 1;
		swapTileNum = 1;
		removePowerUpActive = false;
	}
	
	/**
	 * Function that increases the player's score.
	 * @param scoreToAdd, integer.
	 */
	public void increaseScore(int scoreToAdd) {
		if (scoreToAdd > 0) {
			score+= scoreToAdd;
		}
	}
	
	/**
	 * Boolean function that checks if a player has met a goalScore.
	 * @return, the goalScore met.
	 */
	public int goalsMet() {
		if (this.mode.isPuzzle() || this.mode.isLightning()) {
			for (int i = 3; i >= 1; i--){
				if ( score >= this.goalScore[i-1] ){
					return i;
				}
			}
		} else if (this.mode.isElimination() || this.mode.isRelease()) {
			for (int i = 3; i >= 1; i--){
				if ( this.mode.getCountdown() <= this.goalScore[i-1] ){
					return i;
				}
			}
		}
		return 0;
	}
	
	/**
	 * Function that decrements the number of remove power-ups.
	 * @return true if the decrement occurred, false otehrwise.
	 */
	public boolean useResetMove() {
		mode.decrement(); // add an extra turn to the counter
		return true;
	}
	
	/**
	 * Function that decrements the number of available swap power-ups.
	 * Returns false if no swaps left.
	 * @return true if there are swapMoves left, false otherwise.
	 */
	public boolean useSwapMove() {
		// if a swap move is available, use it
		if( swapTileNum > 0) {
			swapTileNum--;
			return true;
		}
		else 
			return false;
	}
	
	/**
	 * Function that decrements the number of remove power-ups.
	 * Returns false if not remove power-ups left.
	 * @return true if there are remove moves left, false otherwise.
	 */
	public boolean useRemoveMove() {
		// if a remove move is available, use it
		if ( removeTileNum > 0 ){
			removeTileNum--;
			return true;
		}
		else
			return false;
	}
	
	/**Getter for selection.*/
	public Selection getSelection () {
		return this.selectionStack;
	}
	
	/**Returns the score of a level.*/
	public int getScore () {
		return this.score;
	}
	
	
	/**Returns the current state of the Remove power up.*/
	public boolean isRemoveActive(){
		return this.removePowerUpActive;
	}
	
	/**Sets the state of the Remove power up.*/
	public void setRemoveActive(boolean state){
		this.removePowerUpActive = state;
	}
	
	/**Returns the score of a level.*/
	public int getRemoveNum () {
		return this.removeTileNum;
	}
	
	/**Returns the score of a level.*/
	public int getSwapNum () {
		return this.swapTileNum;
	}
	
	/**Returns the score of a level.*/
	public Mode getMode() {
		return this.mode;
	}
	/**Returns the board of a level/ */
	public Board getBoard() {
		return this.board;
	}
	
	/**Returns the goal scores of a level.*/ 
	public int[] getGoalScores(){
		return this.goalScore;
	}
	
	/**Reset the score to zero.*/
	public void resetScore() {
		this.score = 0;
	}
	
	/**Increment the remove number.*/
	public void incrementRemove() {
		this.removeTileNum++;
	}
	
	/**Increment the swap move.*/
	public void incrementSwap() {
		this.swapTileNum++;
	}
	
	/**
	 * Sets the swapActive to either true of false.
	 * @param b, given boolean either true of false.
	 */
	public void swapActiveToggle(boolean b) {
		swapActive = b;
	}
	
	/**
	 * Checks if the player wants to swap tiles.
	 * @return true if the swapState is active, false otherwise.
	 */
	public boolean swapState() {
		if (getSwapNum() > 0) {
		return swapActive;
		}
		else {
			return false;
		}
	}


	/**
	 * Getter for the game mode of the level.
	 * @return the game mode as a string.
	 */
	public String getModeString() {
		if (this.getMode().isElimination()) {
			return "Elimination";
		}
		else if (this.getMode().isLightning()) {
			return "Lightning";
		}
		else if (this.getMode().isPuzzle()) {
			return "Puzzle";
		}
		else if (this.getMode().isRelease()) {
			return "Release";
		}
		else {
			return null;
		}
	}
}
