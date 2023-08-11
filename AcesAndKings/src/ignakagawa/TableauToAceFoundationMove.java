package ignakagawa;

import ks.common.games.Solitaire;
import ks.common.model.Card;
import ks.common.model.Move;
import ks.common.model.Pile;

public class TableauToAceFoundationMove extends Move{

	/** The tableauPile. */
	protected Pile tableauPile;
	
	protected Card cardBeingDragged;
	
	protected Pile aceFoundationPile;
	
	public TableauToAceFoundationMove(Pile source, Card cardBeingDragged, Pile destination) {
		super();
		this.cardBeingDragged = cardBeingDragged;
		this.tableauPile = source;
		this.aceFoundationPile = destination;
	}

	@Override
	public boolean doMove(Solitaire game) {
		// TODO Auto-generated method stub
		if (!valid(game)) {
			return false;
		}
		aceFoundationPile.add(cardBeingDragged);
		game.updateScore(+1);
		return true;
	}

	@Override
	public boolean undo(Solitaire game) {		
		tableauPile.add(aceFoundationPile.get());
		game.updateScore(-1);
		return true;
	}

	@Override
	public boolean valid(Solitaire game) {

		// if the pile has no cards, and the new card is a ace
		if(aceFoundationPile.empty()) {
			if (cardBeingDragged.getRank() == 1) {
				return true;
			}
		}
		// if the card in the tableau pile is a rank lower than the card in the ace pile
		else if((aceFoundationPile.peek().getRank() + 1) == (cardBeingDragged.getRank())){
			return true;
		}
		return false;
	}
	
	
}
