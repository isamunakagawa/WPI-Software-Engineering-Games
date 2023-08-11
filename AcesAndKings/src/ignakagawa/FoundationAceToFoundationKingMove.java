package ignakagawa;

import ks.common.games.Solitaire;
import ks.common.model.Card;
import ks.common.model.Move;
import ks.common.model.Pile;

public class FoundationAceToFoundationKingMove extends Move{

	/** The Ace Foundation pile */
	protected Pile aceFoundationPile;
	
	protected Card cardBeingDragged;
	
	protected Pile kingFoundationPile;
	
	public FoundationAceToFoundationKingMove(Pile source, Card cardBeingDragged, Pile destination) {
		super();
		this.cardBeingDragged = cardBeingDragged;
		this.aceFoundationPile = source;
		this.kingFoundationPile = destination;
	}

	@Override
	public boolean doMove(Solitaire game) {
		// TODO Auto-generated method stub
		if (!valid(game)) {
			return false;
		}
		kingFoundationPile.add(cardBeingDragged);
		// score is not awarded
		return true;
	}

	@Override
	public boolean undo(Solitaire game) {
		// TODO Auto-generated method stub
		aceFoundationPile.add(kingFoundationPile.get());
		// score is not awarded
		return true;
	}

	@Override
	public boolean valid(Solitaire game) {

		// if the pile has no cards, and the new card is a ace
		if(aceFoundationPile.empty()) {
			if (cardBeingDragged.getRank() == 13) {
				return true;
			}
		}
		// if the card in the aceFoundation pile is a rank lower than the card in the ace pile
		else if((aceFoundationPile.peek().getRank() + 1) == (cardBeingDragged.getRank())){
			return true;
		}
		return false;
	}
	
	
}
