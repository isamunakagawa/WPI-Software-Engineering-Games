package game.controller;

import game.entity.Selection;
import game.entity.Square;
import game.view.BoardView;

/**
 * Controller that handles when player makes a move 
 * in an elimination level.
 * 
 *
 */
public class EliminationController {
	/** The boundary class associated with the board.*/
	protected BoardView bv;
	
	/** The player selection.*/
	protected Selection selection;

	/**
	 * Constructor for a controller that marks the eliminated
	 * squares.
	 * @param bv, board view
	 * @param selection, player selection
	 */
	public EliminationController(BoardView bv, Selection selection) {
		this.bv = bv;
		this.selection = selection;
	}
	
	/**
	 * Marks the square views by coloring eliminated squares
	 * gray.
	 */
	public void markSquares () {
		for (Square sq: this.selection.getSquares()) {
			if (!sq.isEliminated()) {
				sq.setEliminated();
			} 
			this.bv.eliminate(sq.getRow(), sq.getCol());
		}
	}

}
