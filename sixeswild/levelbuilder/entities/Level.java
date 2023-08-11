package levelbuilder.entities;

import levelbuilder.controller.EditController;

/**
 * Level class holds all needed information in order to hold 
 * information of the level.
 * 
 * 
 * */
public class Level {
	
	/** The board of the level.*/
	protected Board board;
	
	/** The game mode of the level.*/
	protected Mode mode;
	
	/** Score obtained by player.*/
	protected int score;
	
	/** Player's selection of tiles.*/
	protected Selection selectionStack = new Selection();
	
	/** Goal thresholds.*/
	protected int[] goalScore = new int[3];
	
	/** Number of available swaps.*/
	protected int swapTileNum;
	
	/** Number of available remove tile power-ups.*/
	protected int removeTileNum;
	
	/** Stack to keep track of edits.*/
	protected java.util.Stack<EditController> edits = new java.util.Stack<EditController>();
	
	/** Stack to keep track of undone edits.*/
	protected java.util.Stack<EditController> undoneEdits = new java.util.Stack<EditController>();
	
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
	}
	
	/**
	 * Increases and updates the score.
	 * @param scoreToAdd, integer.
	 */
	public void increaseScore(int scoreToAdd) {
		if (scoreToAdd > 0) {
			score+= scoreToAdd;
		}
	}
	
	/**
	 * Checks if any of the goal scores were met.
	 * @param goals, score thresholds.
	 * @return the number of goals that were surpassed.
	 */
	public int goalsMet(int[] goals) {
		for (int i = 3; i >= 1; i--){
			if ( score >= goals[i-1] ){
				return i;
			}
		}
		return 0;
	}
	
	/** Decrements available moves*/
	public boolean useResetMove() {
		mode.decrement(); // add an extra turn to the counter
		return true;
	}
	/** Decrements the available swap moves left.*/
	public boolean useSwapMove() {
		// if a swap move is available, use it
		if( swapTileNum > 0) {
			swapTileNum--;
			return true;
		}
		else 
			return false;
	}
	
	/** Decrements the available swap moves left.*/
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
	
	/**Returns board of a level.*/
	public Board getBoard() {
		return this.board;
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
	
	/** Sets the goal score requirements according to given index and score.*/
	public void setGoalScore(int starNum, int score){
		goalScore[starNum-1] = score;
		System.out.println(starNum + " Star updated to: " + score + " points.");
	}
	
	/** Getter for goal scores by indicated index.*/
	public int getGoalScore(int index){
		return goalScore[index];
	}
	
	/** Sets the board of a level to a given board.*/
	public void setBoard(Board newBoard){
		this.board = newBoard;
	}
	
	/** Returns the most recent edit or top of stack.*/
	public EditController getMostRecentEdit(){
		return this.edits.get(0);
	}
	
	/** Adds an edit to the top of the stack.*/
	public void addEdit(EditController e){
		//this.edits.push(e);
		this.edits.insertElementAt(e, 0);
	}
	
	/** Returns the most recent undo edit from top of undo stack.*/
	public EditController getMostRecentUndo(){
		return this.undoneEdits.get(0);
	}
	
	/** Adds an undo to the top of undo stack.*/
	public void addUndo(EditController e){
		//this.undoneEdits.push(e);
		this.undoneEdits.insertElementAt(e, 0);
	}
	
	/** Clears the collection of edits.*/
	public boolean emptyEdit(){
		return this.edits.empty();
	}
	
	/** Clears the collections of undo edits.*/
	public boolean emptyUndo(){
		return this.undoneEdits.empty();
	}
	
	/** Returns the collection of edits.*/
	public java.util.Stack<EditController> getUndoneEdits(){
		return this.undoneEdits;
	}
	
	/** Returns the collection of undo edits.*/
	public java.util.Stack<EditController> getEdits(){
		return this.edits;
	}
}