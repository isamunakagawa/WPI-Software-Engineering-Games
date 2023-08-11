package ignakagawa;

import ks.common.controller.SolitaireReleasedAdapter;
import ks.common.model.Move;
import ks.common.model.MultiDeck;
import ks.common.model.Pile;

public class AcesAndKingsDeckController extends SolitaireReleasedAdapter {
	/** The game. */
	protected AcesAndKings theGame;

	/** The WastePile of interest. */
	protected Pile wastePile;

	/** The Deck of interest. */
	protected MultiDeck deck;

	/**
	 * KlondikeDeckController constructor comment.
	 */
	public AcesAndKingsDeckController(AcesAndKings theGame, MultiDeck d, Pile wastePile) {
		super(theGame);
		
		this.theGame = theGame;
		this.wastePile = wastePile;
		this.deck = d;
	}

	/**
	 * Coordinate reaction to the beginning of a Drag Event. In this case,
	 * no drag is ever achieved, and we simply deal upon the pres.
	 */
	public void mousePressed (java.awt.event.MouseEvent me) {
		// Attempting a Deal
		Move m = new StockToWasteMove (deck, wastePile);
		//System.out.println(theGame.availableMovesCount());
		if (m != null && m.doMove(theGame)) {
			theGame.pushMove (m);     // Successful DealFour Move
			theGame.refreshWidgets(); // refresh updated widgets.
		}
	}
}
