package game.entity;


/**
 * Board class manages all the positions of the tiles and 
 * contains the collection of squares and their positions.
 * 
 * 
 * 
 * */
public class Board {
	/** Tile generator that creates tile objects.*/
	protected TileGenerator tileGen;	
	
	/** Collection of squares that hold tiles.*/
	protected Square[][] squares = new Square[9][9];
	
	/**
	 * Constructor for creating a test board.
	 * @param isTest, boolean.
	 */
	public Board(int isTest, TileGenerator t) {
		this.tileGen = t;
		testBoard(isTest);
	}
	
	/**
	 * Private method for testing purposes.
	 * @param isTest, boolean
	 */
	private void testBoard(int isTest) {
		if (isTest == 1){
			for(int i = 0; i < squares.length; i++ ){
				for(int j = 0; j < squares.length; j++ ){
					squares[i][j] = new Square(i, j);
					if(squares[i][j].isEmpty() && squares[i][j].active){
						if (i % 2 == 0) {
							squares[i][j].setTile(new Tile(1,2));
						} else {
							squares[i][j].setTile(new Tile(2,2));
						}
					}
				}
			}
		}
	}

	/** Constructor for the board that is given a tile generator.*/
	public Board(TileGenerator t){
		this.tileGen = t;
		initialize(); // Initialize upon creation
	}
	
	
	/**
	 * Fills the board by setting a tile
	 * to each square.
	 */
	public void fillBoard(){
		for(int i = 0; i < squares.length; i++ ){
			for(int j = 0; j < squares.length; j++ ){
				if(squares[i][j].isEmpty() && squares[i][j].active && !squares[i][j].isBucket()){
					squares[i][j].setTile(tileGen.makeNewTile());			
				}
			}
		}
	}	
	
	/**
	 * Initializes the board to its initial tiles.
	 */
	public void initialize(){
		for(int i = 0; i < squares.length; i++ ){
			for(int j = 0; j < squares.length; j++ ){
				squares[i][j] = new Square(i, j);	
				if(squares[i][j].isEmpty() && squares[i][j].active && !squares[i][j].isBucket()){
					squares[i][j].setTile(tileGen.makeNewTile());			
				}
				//squares[i][j].setTile(tileGen.makeNewTile());
			}
		}
	}
	
	/**
	 * Returns the collection of squares.
	 * @return collection of squares.
	 */
	public Square[][] getSquares() {
		return this.squares;
	}
	
	/**
	 * Getter for a specified square on the board.
	 * @param row, int
	 * @param col, int
	 * @return the square specified by the parameters.
	 */
	public Square getSquare(int row, int col) {
		return squares[row][col];
	}
	
	/**
	 * Getter for a square on the board by its index.
	 * @param index, int
	 * @return the specified square object.
	 */
	public Square getSquare(int index) {
		int row = (int) index / 9;
		int col = index % 9;
		return getSquare(row, col);
	}
	
}	
	