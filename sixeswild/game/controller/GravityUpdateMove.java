package game.controller;

import game.entity.Board;
import game.entity.Selection;
import game.entity.Square;
import game.entity.Tile;

import java.util.Collections;
import java.util.Comparator;

/**
 * Gravity that handles tiles dropping within their columns.
 * 
 *
 */
public class GravityUpdateMove {
	
	/** The board for the game.*/
	protected Board board;
	
	/** The player selection.*/
	protected Selection squares;
	
	/**
	 * GravityUpdateMove constructor that creates a gravity object
	 * that takes care of moving tile down.
	 * @param board
	 * @param squares
	 */
	GravityUpdateMove(Board board, Selection squares) {
		this.board = board;
		this.squares = squares;
	}
	
	/**
	 * The system's way of clearing the player's selection
	 * of tiles and making tiles fall into place.
	 */
	public void gravity() {
		int i;
		int row,col;
		Tile temp, holder;
		
		//sorts the selection based on if the squares are in the same column or not
		Collections.sort(this.squares.getSquares(),new Comparator<Square>() {
	        @Override
	        public int compare(Square sq1, Square sq2)
	        {
	        	if (sq1.getCol() == sq2.getCol()) {
	    			if (sq1.getRow() > sq2.getRow()) {
	    				return 1;
	    			} else {
	    				return -1;
	    			}
	    		} else {
	    			return 0;
	    		}
	        }
	    });
		//iterates through each square in the selection
		for (Square sq : this.squares.getSquares()) {
			row = sq.getRow();
			col = sq.getCol();
			this.board.getSquare(row, col).destroyTile();
			temp = null;
			holder = null;
			
			//iterates through each row, while keeping the column constant
			for (i = 0; i <= row; i++) {
				if (!this.board.getSquare(i,col).isActive()) {
					continue;
				} else {
					temp = this.board.getSquare(i, col).getTile();
					this.board.getSquare(i, col).setTile(holder);
				    holder = temp;
				}
			}
		}
		//repopulates the board afterwards
		this.board.fillBoard();

	}
	
	/**
	 * Allows sixes to fall into buckets and carries
	 * out normal gravity accordingly.
	 */
	public void releaseGravity() {
		int i, j, k;//counter
		Tile temp;
		Tile holder, holder2;
		Tile tileAbove;
		for (i = 0; i < 9; i++) {
			for (j=0; j < 9; j++) {
				if (this.board.getSquare(i,j).isBucket()) {
					temp = null;
					tileAbove = this.board.getSquare(i - 1, j).getTile();
					if (this.board.getSquare(i, j).acceptSix(tileAbove)) {
						this.board.getSquare(i, j).setFilled(true);
						holder = null;
						holder2 = null;
						//iterates through each row, while keeping the column constant
						int o = i-1;
						for (k = 0; k <= o; k++) {
							if (!this.board.getSquare(k,j).isActive()) {
								continue;
							} else {
								holder = this.board.getSquare(k, j).getTile();
								this.board.getSquare(k, j).setTile(holder2);
							    holder2 = holder;
							}
						}
						this.board.fillBoard();
					}
				}
			}
		}
	}
}
