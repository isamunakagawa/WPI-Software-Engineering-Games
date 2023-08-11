package levelbuilder.entities;

/**
 * Board class manages all the positions of the tiles and 
 * contains the collection of squares and their positions.
 * 
 * 
 * 
 */
public class Board {
	/** Tile generator that creates tile objects.*/
	TileGenerator tileGen;	
	
	/** Collection of squares that hold tiles.*/
	protected Square[][] squares = new Square[9][9];
	
	/**Default constructor for a board.*/
	public Board(){
		this.tileGen = new TileGenerator();
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				this.squares[i][j] = new Square(i, j);
	}

	/**
	 * Constructor for a board object that has its own
	 * tile generator.
	 * @param t, the given tile generator.
	 */
	public Board(TileGenerator t){
		this.tileGen = t;
	}
	
	/**
	 * Fills the board by setting a tile
	 * to each square.
	 */
	public void fillBoard(){
		for(int i = 0; i < squares.length; i++ ){
			for(int j = 0; j < squares.length; j++ ){
				if(squares[i][j].isEmpty() && squares[i][j].active){
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
				//squares[i][j] = new Square(i, j);		
				if(squares[i][j].getActive() && !squares[i][j].getBucket()){
					squares[i][j].setTile(tileGen.makeNewTile());
				}
				else{
					squares[i][j].setTile(null);
				}
			}
		}
		for(int w = 0; w < squares.length; w++){
			for (int x = 0; x < squares.length; x++){
				if (squares[w][x].getBucket()){
					squares[w][x].setTile(null);
					for (int z = 0; z <= 8; z++){
						if (squares[z][x].getActive()){
							squares[z][x].setTile(new Tile(6, 1));
							break;
						}
					}
				}
				
			}
		}	
	}
	
	/** Getter for the board's tile generator.*/
	public TileGenerator getTileGen(){
		return this.tileGen;
	}
	
	/** Getter for a specific square by row and column.*/
	public Square getSquare(int row, int col){
		return squares[row][col];
	}
	
	/** Getter for a designated square by index.*/
	public Square getSquare(int index){
		int row = (int) index / 9;
		int col = index % 9;
		return getSquare(row, col);
	}
}	