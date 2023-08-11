/**
 * 
 */
package ignakagawa;

import java.awt.event.MouseAdapter;
import java.awt.font.TextLayout.CaretPolicy;

import ks.common.controller.SolitaireReleasedAdapter;
import ks.common.controller.SolitaireMouseMotionAdapter;
import ks.common.games.Solitaire;
import ks.common.games.SolitaireUndoAdapter;
import ks.common.model.BuildablePile;
import ks.common.model.Card;
import ks.common.model.Column;
import ks.common.model.Deck;
import ks.common.model.Move;
import ks.common.model.MultiDeck;
import ks.common.model.Pile;
import ks.common.view.BuildablePileView;
import ks.common.view.CardImages;
import ks.common.view.ColumnView;
import ks.common.view.DeckView;
import ks.common.view.IntegerView;
import ks.common.view.PileView;
import ks.common.view.RowView;
import ks.launcher.Main;
import ignakagawa.AcesAndKingsDeckController;

/**
 * @author Isamu Nakagawa
 *
 */
public class AcesAndKings extends Solitaire{
	
	/** The multi-deck stores two decks  */
	protected MultiDeck deck;
	/** The two columns  */
	protected Column[] reserveColumn = new Column [3];
	/** The four piles for tableaus  */
	protected Pile[] tableauPile = new Pile [5];
	/** The four piles for aces  */
	protected Pile[] foundationAcePile = new Pile [5];
	/** The four piles for kings  */
	protected Pile[] foundationKingPile = new Pile [5];
	/** The pile fore waste  */
	protected Pile wastePile;
	
	/** And four Piles as foundation. Extra size is to enable easier algorithms. */
	//protected Pile foundation[] = new Pile [5];

	/** Latest version. */
	protected String version = "1.1";

	/** The view of the deck (1) */
	protected DeckView deckView;

	/** The view of the reserve columns (2) */
	protected RowView reserveViews[] = new RowView [3];

	/** The view of the tableau piles (4)*/
	protected PileView tableauViews[] = new PileView [5];

	/** The view of the foundationAce piles (4)*/
	protected PileView foundationAceViews[] = new PileView [5];
	
	/** The view of the foundationKing piles (4)*/
	protected PileView foundationKingViews[] = new PileView [5];
	
	/** The view for the wastePile. (1)*/
	protected PileView wasteView;
	
	/** The view for the score. (1)*/
	protected IntegerView scoreView;

	/** View for the number of cards left in the deck. (1)*/
	protected IntegerView numLeftView;
	
	
	public AcesAndKings() {
		// TODO Auto-generated constructor stub
		super();
	}
	

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "ignakagawa-Aces and Kings";
	}

	@Override
	public boolean hasWon() {
		// TODO Auto-generated method stub
		// all card are in the foundation piles
		if (score.getValue() == 104) {
			return true;
		}
		return false;
	}
	
	/** Call the initialize methods to setup the game
	 * 
	 */
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		// initialize model
		
		initializeModel(getSeed());
		initializeView();
		initializeControllers();

		
		/* prepare game by dealing cards */
		
		//deal 13 cards to 2 reserve columns
		for (int cardNum=1; cardNum <= 13; cardNum++) {
			for(int columnNum=1; columnNum <= 2; columnNum++) {
				Card c = deck.get();
				reserveColumn[columnNum].add(c);
				updateNumberCardsLeft (-1);
			}
		}
		
		//deal 1 card to 4 tableau columns
		for (int cardNum=1; cardNum <= 1; cardNum++) {
			for(int tableauNum=1; tableauNum <= 4; tableauNum++) {
				Card c = deck.get();
				tableauPile[tableauNum].add(c);
				updateNumberCardsLeft (-1);
			}
		}
		
		//deal 1 card to waste pile
		
		Card c = deck.get();
		wastePile.add(c);
		updateNumberCardsLeft (-1);
		 
		updateScore(0);
		
	}

	private void initializeControllers() {

		
		// Deck (1)
		deckView.setMouseAdapter(new AcesAndKingsDeckController (this, deck, wastePile));
		deckView.setMouseMotionAdapter (new SolitaireMouseMotionAdapter(this));
		deckView.setUndoAdapter (new SolitaireUndoAdapter(this));
		
		// WastePile (1)
		wasteView.setMouseAdapter (new AcesAndKingsWastePileController (this, wasteView));
		wasteView.setMouseMotionAdapter (new SolitaireMouseMotionAdapter (this));
		wasteView.setUndoAdapter (new SolitaireUndoAdapter(this));
		
		// Tableau Piles (4)
		for (int i = 1; i <= 4; i++) {
			tableauViews[i].setMouseAdapter (new AcesAndKingsTableauPileController (this, tableauViews[i]));
			tableauViews[i].setMouseMotionAdapter (new SolitaireMouseMotionAdapter (this));
			tableauViews[i].setUndoAdapter (new SolitaireUndoAdapter(this));
		}
		
		// King Foundations (4)
		for (int i = 1; i <= 4; i++) {
			foundationKingViews[i].setMouseAdapter (new AcesAndKingsFoundationKingController (this, foundationKingViews[i], deck));
			foundationKingViews[i].setMouseMotionAdapter (new SolitaireMouseMotionAdapter (this));
			foundationKingViews[i].setUndoAdapter (new SolitaireUndoAdapter(this));
		}
		
		// Ace Foundations (4)
		for (int i = 1; i <= 4; i++) {
			foundationAceViews[i].setMouseAdapter (new AcesAndKingsFoundationAceController (this, foundationAceViews[i], deck));
			foundationAceViews[i].setMouseMotionAdapter (new SolitaireMouseMotionAdapter (this));
			foundationAceViews[i].setUndoAdapter (new SolitaireUndoAdapter(this));
		}
		
		// Reserve Columns (2)
		for (int i = 1; i <= 2; i++) {
			reserveViews[i].setMouseAdapter (new AcesAndKingsReserveController(this, reserveViews[i]));
			reserveViews[i].setMouseMotionAdapter (new SolitaireMouseMotionAdapter (this));
			reserveViews[i].setUndoAdapter (new SolitaireUndoAdapter(this));
		}
		
		
		// Set motion adapters to views
		scoreView.setMouseMotionAdapter (new SolitaireMouseMotionAdapter (this));
		numLeftView.setMouseMotionAdapter (new SolitaireMouseMotionAdapter (this));
		
	}

	/** Initialize the views
	 * 
	 */
	private void initializeView() {

		CardImages ci = getCardImages();
		
		final int padding = 25;
		
		deckView = new DeckView (deck);
		deckView.setBounds (padding, padding+ci.getHeight()*3, ci.getWidth(), ci.getHeight());
		container.addWidget (deckView);
		
		// ColumnView reserveViews (2)
		for (int reserveNum = 1; reserveNum <=2; reserveNum++) {
			reserveViews[reserveNum] = new RowView(reserveColumn[reserveNum]);
			reserveViews[reserveNum].setBounds (((ci.getWidth()*(((reserveNum-1)*5)))+padding), padding, ci.getWidth()*4, ci.getHeight());
			container.addWidget (reserveViews[reserveNum]);
		}
		
		// PileView tableauView (4)
		for (int tableauNum = 1; tableauNum <=4; tableauNum++) {
			tableauViews[tableauNum] = new PileView (tableauPile[tableauNum]);
			tableauViews[tableauNum].setBounds (padding+(ci.getWidth()*(4+tableauNum)), padding+ci.getHeight()*3, ci.getWidth(), ci.getHeight());
			container.addWidget (tableauViews[tableauNum]);
		}
		
		// PileView foundationAceView (4)
		for (int foundationAceNum = 1; foundationAceNum <=4; foundationAceNum++) {
			foundationAceViews[foundationAceNum] = new PileView (foundationAcePile[foundationAceNum]);
			foundationAceViews[foundationAceNum].setBounds (padding+(ci.getWidth()*(foundationAceNum-1)), ci.getHeight()*2, ci.getWidth(), ci.getHeight());
			container.addWidget (foundationAceViews[foundationAceNum]);
		}
		
		// PileView foundationKingView (4)
		for (int foundationKingNum = 1; foundationKingNum <=4; foundationKingNum++) {
			foundationKingViews[foundationKingNum] = new PileView (foundationKingPile[foundationKingNum]);
			foundationKingViews[foundationKingNum].setBounds (padding+(ci.getWidth()*(4+foundationKingNum)), ci.getHeight()*2, ci.getWidth(), ci.getHeight());
			container.addWidget (foundationKingViews[foundationKingNum]);
		}
		
		// PileView wasteView (1)
		wasteView = new PileView (wastePile);
		wasteView.setBounds (padding+(ci.getWidth()*2), padding+ci.getHeight()*3, ci.getWidth(), ci.getHeight());
		container.addWidget (wasteView);
		
		// PileView scoreView (1)
		scoreView = new IntegerView (getScore());
		scoreView.setBounds (padding+(ci.getWidth()*2), padding+ci.getHeight()*4, 70, 70);
		container.addWidget (scoreView);
		
		// PileView numLeftView (1)
		numLeftView = new IntegerView (getNumLeft());
		//numLeftView.setFontSize (14);
		numLeftView.setBounds (padding+(ci.getWidth()*5), padding+ci.getHeight()*4, 70, 70);
		container.addWidget (numLeftView);
		
		// initial score is set to ZERO (every Solitaire game by default has a score) and there are 52 cards left.
		// NOTE: These will be added to the model by solitaire Base Class.
		this.updateNumberCardsLeft(104);
	}
	
	/** 
	 * Initialize the models, by creating the appropriate entities.
	 * @param seed
	 */
	private void initializeModel(int seed) {
		
		
		// deck MultiDeck (2)
		deck = new MultiDeck("deck", 2); // name, two decks
		deck.create(seed); // seed the random
		model.addElement (deck);   // add to our model (as defined within our superclass).
		
		// tableau Pile (4)
		for (int i = 1; i<=4; i++) {
			tableauPile[i] = new Pile ("tableau" + i);
			model.addElement (tableauPile[i]);
		} 
		
		// foundationAce Pile (4)
		for (int i = 1; i<=4; i++) {
			foundationAcePile[i] = new Pile ("foundationAce" + i);
			model.addElement (foundationAcePile[i]);
		}
		
		// foundationKing Pile (4)
		for (int i = 1; i<=4; i++) {
			foundationKingPile[i] = new Pile ("foundationKing" + i);
			model.addElement (foundationKingPile[i]);
		}
		
		// waste Pile (1)
		wastePile = new Pile("wastePile");
		model.addElement(wastePile);
		
		// reserve objects (2)
		for (int i = 1; i<=2; i++) {
			reserveColumn[i] = new Column ("reserve" + i);
			model.addElement (reserveColumn[i]);
		}
		
	}
	
	/**
	 * check if a pile is tableau
	 * @param sourcePile
	 * @return
	 */
	public boolean isTableauPile(Pile sourcePile) {
		for (int i = 0; i < tableauPile.length; i++) {
		   if (tableauPile[i] == sourcePile) { 
			   return true; 
		   }
		}
		return false;
	}
	
	/**
	 *  check if a pile is waste
	 * @param sourcePile
	 * @return
	 */
	public boolean isWastePile(Pile sourcePile) {
		   if (wastePile == sourcePile) { 
			   return true; 
		}
		return false;
	}
	
	/**
	 *  check if a pile is foundation king
	 * @param sourcePile
	 * @return
	 */
	public boolean isFoundationKingPile(Pile sourcePile) {
		for (int i = 0; i < foundationKingPile.length; i++) {
			   if (foundationKingPile[i] == sourcePile) { 
				   return true; 
			   }
			}
		return false;
	}
	
	/**
	 *  check if a pile is foundation ace
	 * @param sourcePile
	 * @return
	 */
	public boolean isFoundationAcePile(Pile sourcePile) {
		for (int i = 0; i < foundationAcePile.length; i++) {
			   if (foundationAcePile[i] == sourcePile) { 
				   return true; 
			   }
			}
		return false;
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main.generateWindow(new AcesAndKings(), Deck.OrderBySuit);
	}
	
}
