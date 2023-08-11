package levelbuilder.view;


/**
 * 
 * 
 */
import levelbuilder.entities.Board;
import levelbuilder.entities.Square;
import levelbuilder.entities.Tile;
import game.view.TileView;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.lang.ProcessBuilder.Redirect;
import java.util.Random;

import javax.swing.JPanel;



public class BoardView extends JPanel {
	/** The x and y position of the board relative to the application view.*/
	int xPos, yPos;
	
	/** The board that board takes information from and renders the data.*/
	Board board;
	private static final long serialVersionUID = 1L;

	/** Collection of squares.*/
	//Square[][] squares = new Square[9][9];
	
	/**Collection of square views.*/
	SquareView[][] gridRep = new SquareView[9][9];
	
	/** Collections of tile views.*/
	TileView[][] grid = new TileView[9][9];
	
	
	/**
	 * BoardView Constructor that initializes the bounds
	 * and creates square objects, and boundary objects.
	 * @param x
	 * @param y
	 */
	public BoardView(int x, int y, Board board)	{
		super();
		this.board = board;
		this.setBounds(200, 135, 545, 449);
		this.xPos = x;
		this.yPos = y;
		
		
		for (int r = 0; r<9; r++){
			for (int c = 0; c<9; c++){
				gridRep[r][c] = new SquareView(r, c, board.getSquare(r, c));
				grid[r][c] = new TileView(r, c);
			}
		} 
			
	}

	public void setHighlight(int r, int c) {
		gridRep[r][c].setBackground(Color.blue);
		revalidate();
		repaint();
	}

	/**
	 * Paints the rectangles and the characters associated with each 
	 * rectangle.
	 */
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		for (int r = 0; r < 9; r++){
			for (int c = 0; c < 9; c++){
				gridRep[r][c].paintComponent(g, xPos, yPos);
			}
		}
		        
	}
	
	public void updateColors(){
		for (int r = 0; r < 9; r++){
			for (int c = 0; c < 9; c++){
				gridRep[r][c].setupColors();
			}
		}
		revalidate();
		repaint();
	}

	

	private int getYCoordinate(SquareView squareView) {
		return squareView.col;
	}

	private int getXCoordinate(SquareView squareView) {
		// TODO Auto-generated method stub
		return squareView.row;
	}
	    
	/**
	 * Returns a square based on given coordinates.
	 * @param x
	 * @param y
	 * @return
	 */
	public Square getSquare(int row, int col) { // Square not inserted into gird, change to return square
		return board.getSquare(row, col);//squares[x][y];
	}

		
	
}