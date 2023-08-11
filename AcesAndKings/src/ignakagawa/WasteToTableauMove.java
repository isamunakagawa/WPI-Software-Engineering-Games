package ignakagawa;

import ks.common.games.Solitaire;
import ks.common.model.Card;
import ks.common.model.Move;
import ks.common.model.Pile;

public class WasteToTableauMove extends Move{

	/** The wastePile. */
	protected Pile wastePile;
	
	protected Card cardBeingDragged;
	
	protected Pile tableauPile;
	
	public WasteToTableauMove(Pile source, Card cardBeingDragged, Pile destination) {
		super();
		// TODO Auto-generated constructor stub
		this.cardBeingDragged = cardBeingDragged;
		this.wastePile = source;
		this.tableauPile = destination;
	}

	@Override
	public boolean doMove(Solitaire game) {

		if (!valid(game)) {
			return false;
		}
		tableauPile.add(cardBeingDragged);

		return true;
	}

	@Override
	public boolean undo(Solitaire game) {

		wastePile.add(tableauPile.get());

		return true;
	}

	@Override
	public boolean valid(Solitaire game) {
		
		// if the pile has no cards
		if(tableauPile.empty()) {
			return true;
		}

		return false;
	}
	
	
}
