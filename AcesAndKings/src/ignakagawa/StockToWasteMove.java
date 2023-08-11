package ignakagawa;

import ks.common.games.Solitaire;
import ks.common.model.Card;
import ks.common.model.Deck;
import ks.common.model.Move;
import ks.common.model.MultiDeck;
import ks.common.model.Pile;

public class StockToWasteMove extends Move{

	/** The deck. */
	protected MultiDeck deck;
	/** The wastePile. */
	protected Pile wastePile;
/**
 * DealCardMove constructor.
 * @param Deck deck
 * @param Pile wastePile
 */
public StockToWasteMove (MultiDeck deck, Pile wastePile) {
	super();
	this.deck = deck;
	this.wastePile = wastePile;
}
	
	@Override
	public boolean doMove(Solitaire game) {
		// TODO Auto-generated method stub
		if (!valid(game)) {
			return false;
		}
		Card card = deck.get();
		game.updateNumberCardsLeft (-1);
		wastePile.add(card);
		return true;
	}

	@Override
	public boolean undo(Solitaire game) {
		
		Card card = wastePile.get();
		deck.add(card);
		game.updateNumberCardsLeft (+1);
		return true;
	}

	@Override
	public boolean valid(Solitaire game) {
		// IF (a) there are no other moves available and (b) the deck contains cards
		if (deck.empty()) {
			return false;
		}
		
		return true;
	}

}
