package ignakagawa;

import ks.common.games.Solitaire;
import ks.common.model.Card;
import ks.common.model.Deck;
import ks.common.model.Move;
import ks.common.model.MultiDeck;
import ks.common.model.Pile;

public class StockToTableauMove extends Move{

	/** The deck. */
	protected MultiDeck deck;
	/** The tableauPile. */
	protected Pile tableauPile;
/**
 * DealCardMove constructor.
 * @param Deck deck
 * @param Pile tableauPile
 */
public StockToTableauMove (Pile tableauPile, MultiDeck deck) {
	super();
	this.deck = deck;
	this.tableauPile = tableauPile;
}
	
	@Override
	public boolean doMove(Solitaire game) {
		// TODO Auto-generated method stub
		if (!valid(game)) {
			return false;
		}
		Card card = deck.get();
		game.updateNumberCardsLeft (-1);
		tableauPile.add(card);
		return true;
	}
	
	@Override
	public boolean undo(Solitaire game) {
	
		Card card = tableauPile.get();
		deck.add(card);
		game.updateNumberCardsLeft (+1);
		
		// undo the auto move
		game.undoMove();
		
		return true;
	}

	@Override
	public boolean valid(Solitaire game) {
		if (!deck.empty()) {
			if (tableauPile.empty()) {
				return true;
			}
		}
		return false;
	}

}
