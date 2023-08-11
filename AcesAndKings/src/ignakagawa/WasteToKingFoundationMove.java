package ignakagawa;

import ks.common.games.Solitaire;
import ks.common.model.Card;
import ks.common.model.Move;
import ks.common.model.Pile;

public class WasteToKingFoundationMove extends Move{

	/** The wastePile. */
	protected Pile wastePile;
	
	protected Card cardBeingDragged;
	
	protected Pile KingFoundationPile;
	
	public WasteToKingFoundationMove(Pile source, Card cardBeingDragged, Pile destination) {
		super();
		// TODO Auto-generated constructor stub
		this.cardBeingDragged = cardBeingDragged;
		this.wastePile = source;
		this.KingFoundationPile = destination;
	}

	@Override
	public boolean doMove(Solitaire game) {
		// TODO Auto-generated method stub
		if (!valid(game)) {
			return false;
		}
		KingFoundationPile.add(cardBeingDragged);
		game.updateScore(+1);
		return true;
	}

	@Override
	public boolean undo(Solitaire game) {
		// TODO Auto-generated method stub
		wastePile.add(KingFoundationPile.get());
		game.updateScore(-1);
		return true;
	}

	@Override
	public boolean valid(Solitaire game) {
		
		// if the pile has no cards, and the new card is a king
		if(KingFoundationPile.empty()) {
			if (cardBeingDragged.getRank() == 13) {
				return true;
			}
		}
		// if the card in the waste pile is a rank lower than the card in the king pile
		else if((KingFoundationPile.peek().getRank() - 1) == (cardBeingDragged.getRank())){
			return true;
		}
		return false;
	}
	
	
}
