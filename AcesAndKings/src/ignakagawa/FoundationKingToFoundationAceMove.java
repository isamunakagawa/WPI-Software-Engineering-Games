package ignakagawa;

import ks.common.games.Solitaire;
import ks.common.model.Card;
import ks.common.model.Move;
import ks.common.model.Pile;

public class FoundationKingToFoundationAceMove extends Move{

	/** The kingFoundation pile. */
	protected Pile kingFoundationPile;
	
	protected Card cardBeingDragged;
	
	protected Pile aceFoundationPile;
	
	public FoundationKingToFoundationAceMove(Pile source, Card cardBeingDragged, Pile destination) {
		super();
		this.cardBeingDragged = cardBeingDragged;
		this.kingFoundationPile = source;
		this.aceFoundationPile = destination;
	}

	@Override
	public boolean doMove(Solitaire game) {
		// TODO Auto-generated method stub
		if (!valid(game)) {
			return false;
		}
		aceFoundationPile.add(cardBeingDragged);
		// score is not awarded
		return true;
	}

	@Override
	public boolean undo(Solitaire game) {
		// TODO Auto-generated method stub
		kingFoundationPile.add(aceFoundationPile.get());
		// score is not awarded
		return true;
	}

	@Override
	public boolean valid(Solitaire game) {
		// TODO Auto-generated method stub

		// if the pile has no cards, and the new card is a ace
		if(aceFoundationPile.empty()) {
			if (cardBeingDragged.getRank() == 1) {
				return true;
			}
		}
		// if the card in the kingFoundation pile is a rank lower than the card in the ace pile
		else if((aceFoundationPile.peek().getRank() + 1) == (cardBeingDragged.getRank())){
			return true;
		}
		return false;
	}
	
	
}
