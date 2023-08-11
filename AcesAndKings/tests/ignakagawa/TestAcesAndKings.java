package ignakagawa;

import java.awt.event.MouseEvent;

import junit.framework.TestCase;
import ks.client.gamefactory.GameWindow;
import ks.common.model.Card;
import ks.common.model.Deck;
import ks.common.model.MultiDeck;
import ks.launcher.Main;
import ks.tests.KSTestCase;
import ks.tests.model.ModelFactory;

public class TestAcesAndKings extends KSTestCase {
	
	protected AcesAndKings ak;
	protected GameWindow gw;

	
	@Override
	protected void setUp() {
		ak = new AcesAndKings();
		gw = Main.generateWindow(ak, Deck.OrderBySuit);
	}
	
	@Override
	protected void tearDown() {
		gw.dispose();
	}
	
	public void testWasteToKingFoundationMove() {
		ModelFactory.init(ak.wastePile, "KC");
		Card drag = ak.wastePile.get();
		// Card has been moved to waste pile
		WasteToKingFoundationMove wtkf = new WasteToKingFoundationMove(ak.wastePile, drag, ak.foundationKingPile[1]);
		assertTrue(wtkf.valid(ak));
		wtkf.doMove(ak);
		
		wtkf.undo(ak);
		assertTrue(ak.wastePile.peek().equals(drag));
	}
	
	public void testWasteToAceFoundationMove() {
		ModelFactory.init(ak.wastePile, "AC");
		Card drag = ak.wastePile.get();
		// Card has been moved to waste pile
		WasteToAceFoundationMove wtkf = new WasteToAceFoundationMove(ak.wastePile, drag, ak.foundationAcePile[1]);
		assertTrue(wtkf.valid(ak));
		wtkf.doMove(ak);
		
		wtkf.undo(ak);
		assertTrue(ak.wastePile.peek().equals(drag));
	}
	
	public void testWasteToTableauMove() {
		
		int deckCount = ak.deck.count();
		int cardsLeft = ak.getNumLeft().getValue();
		
		Card c = ak.deck.peek();
		StockToWasteMove stw =new StockToWasteMove(ak.deck, ak.wastePile);
		stw.doMove(ak);
		// Card has been moved to waste pile
		Card tempStorage = ak.tableauPile[1].get(); // tableau should be empty
		WasteToTableauMove wtt = new WasteToTableauMove(ak.wastePile, c, ak.tableauPile[1]);
		assertTrue(wtt.valid(ak));
		
		wtt.doMove(ak);
		
		assertEquals(deckCount-1, ak.deck.count());
		assertEquals(c, ak.tableauPile[1].peek());
		
		assertEquals(cardsLeft-1, ak.getNumLeft().getValue());
		
		wtt.undo(ak);
		stw.undo(ak);
		
		ak.tableauPile[1].add(tempStorage); // put the card back
		assertEquals(deckCount, ak.deck.count());
		
	}
	
	public void testStockToWasteMove() {
		
		Card topCard = ak.deck.peek();
		
		int deckCount = ak.deck.count();
		int cardsLeft = ak.getNumLeft().getValue();
		
		StockToWasteMove stw = new StockToWasteMove(ak.deck, ak.wastePile);
		assertTrue(stw.valid(ak));
		
		stw.doMove(ak);
		
		assertEquals(deckCount-1, ak.deck.count());
		assertEquals(topCard, ak.wastePile.peek());
		
		assertEquals(cardsLeft-1, ak.getNumLeft().getValue());
		
		stw.undo(ak);
		
		assertEquals(deckCount, ak.deck.count());
		
		
	}
	
	public void testStockToTableauMove() {
		
		Card topCard = ak.deck.peek();
		
		int deckCount = ak.deck.count();
		int cardsLeft = ak.getNumLeft().getValue();
		
		Card tempStorage = ak.tableauPile[1].get(); // tableau should be empty
		
		StockToTableauMove stw = new StockToTableauMove(ak.tableauPile[1], ak.deck);
		assertTrue(stw.valid(ak));
		
		stw.doMove(ak);
		
		assertEquals(deckCount-1, ak.deck.count());
		assertEquals(topCard, ak.tableauPile[1].peek());
		
		assertEquals(cardsLeft-1, ak.getNumLeft().getValue());
		
		stw.undo(ak);
		
		assertEquals(deckCount, ak.deck.count());
		
		ak.tableauPile[1].add(tempStorage); // put the card back
		
		// Other test
		
		ModelFactory.init(ak.tableauPile[1], "KC");
		ModelFactory.init(ak.deck, "");
		assertEquals(0, ak.deck.count());
		TableauToKingFoundationMove tkf = new TableauToKingFoundationMove(ak.tableauPile[1], ak.tableauPile[1].get(), ak.foundationKingPile[1]);
		assertTrue(tkf.valid(ak));
		tkf.doMove(ak);
		assertEquals(null, ak.tableauPile[1].peek());
		
	}
	
	public void testTableauToAceFoundationMove() {
		
		int deckCount = ak.deck.count();
		int cardsLeft = ak.getNumLeft().getValue();
		
		
		ModelFactory.init(ak.tableauPile[1], "AC");
		Card card = ak.tableauPile[1].peek();
		
		TableauToAceFoundationMove ttaf = new TableauToAceFoundationMove(ak.tableauPile[1], card, ak.foundationAcePile[1]);
		assertTrue(ttaf.valid(ak));
		
		ttaf.doMove(ak);
		
		assertEquals(deckCount, ak.deck.count());
		assertEquals(card, ak.foundationAcePile[1].peek());
		
		assertEquals(cardsLeft, ak.getNumLeft().getValue());
		
		ttaf.undo(ak);
		
		assertEquals(deckCount, ak.deck.count());
	
	}
	
	public void testTableauToKingFoundationMove() {
		
		int deckCount = ak.deck.count();
		int cardsLeft = ak.getNumLeft().getValue();
		
		ModelFactory.init(ak.tableauPile[1], "KC");
		Card card = ak.tableauPile[1].peek();
		
		TableauToKingFoundationMove ttkf = new TableauToKingFoundationMove(ak.tableauPile[1], card, ak.foundationKingPile[1]);
		assertTrue(ttkf.valid(ak));
		
		ttkf.doMove(ak);
		
		assertEquals(deckCount, ak.deck.count());
		assertEquals(card, ak.foundationKingPile[1].peek());
		
		assertEquals(cardsLeft, ak.getNumLeft().getValue());
		
		ttkf.undo(ak);
		
		assertEquals(deckCount, ak.deck.count());
	
	}
	
	public void testReserveToKingFoundationMove() {
		
		int deckCount = ak.deck.count();
		int cardsLeft = ak.getNumLeft().getValue();
		
		ModelFactory.init(ak.reserveColumn[1], "KC");
		Card card = ak.reserveColumn[1].peek();
		
		ReserveToKingFoundationMove rtkf = new ReserveToKingFoundationMove(ak.reserveColumn[1], card, ak.foundationKingPile[1]);
		assertTrue(rtkf.valid(ak));
		
		rtkf.doMove(ak);
		
		assertEquals(deckCount, ak.deck.count());
		assertEquals(card, ak.foundationKingPile[1].peek());
		
		assertEquals(cardsLeft, ak.getNumLeft().getValue());
		
		rtkf.undo(ak);
		
		assertEquals(deckCount, ak.deck.count());
	}
	
	public void testReserveToAceFoundationMove() {
		
		int deckCount = ak.deck.count();
		int cardsLeft = ak.getNumLeft().getValue();
		
		ModelFactory.init(ak.reserveColumn[1], "AC");
		Card card = ak.reserveColumn[1].peek();
		
		ReserveToAceFoundationMove rtaf = new ReserveToAceFoundationMove(ak.reserveColumn[1], card, ak.foundationKingPile[1]);
		assertTrue(rtaf.valid(ak));
		
		rtaf.doMove(ak);
		
		assertEquals(deckCount, ak.deck.count());
		assertEquals(card, ak.foundationKingPile[1].peek());
		
		assertEquals(cardsLeft, ak.getNumLeft().getValue());
		
		rtaf.undo(ak);
		
		assertEquals(deckCount, ak.deck.count());
		
	}
	
	public void testKingFoundationToAceFoundationMove() {
		
		int deckCount = ak.deck.count();
		int cardsLeft = ak.getNumLeft().getValue();
		
		Card card = new Card(1, 4);
		FoundationKingToFoundationAceMove fkfa = new FoundationKingToFoundationAceMove(ak.foundationKingPile[1], card, ak.foundationAcePile[1]);
		assertTrue(fkfa.valid(ak));
		
		fkfa.doMove(ak);
		
		assertEquals(deckCount, ak.deck.count());
		assertEquals(card, ak.foundationAcePile[1].peek());
		
		assertEquals(cardsLeft, ak.getNumLeft().getValue());
		
		fkfa.undo(ak);
		
		assertEquals(deckCount, ak.deck.count());
		
	}
	
	public void testAceFoundationToKingFoundationMove() {
		
		int deckCount = ak.deck.count();
		int cardsLeft = ak.getNumLeft().getValue();
		
		Card card = new Card(13, 4);
		FoundationAceToFoundationKingMove fafk = new FoundationAceToFoundationKingMove(ak.foundationAcePile[1], card, ak.foundationKingPile[1]);
		assertTrue(fafk.valid(ak));
		
		fafk.doMove(ak);
		
		assertEquals(deckCount, ak.deck.count());
		assertEquals(card, ak.foundationKingPile[1].peek());
		
		assertEquals(cardsLeft, ak.getNumLeft().getValue());
		
		fafk.undo(ak);
		
		assertEquals(deckCount, ak.deck.count());
		
	}
	
	
	/* CONTROLLER TESTS */
	
	public void testDeckController() {
		// create mouse press at (0,0) within the deckview; should deal card
		MouseEvent press = this.createPressed(ak, ak.deckView, 0, 0);
		Card top = ak.deck.peek();
		ak.deckView.getMouseManager().handleMouseEvent(press);
		
		// what do we know about the game after press on deck? Card dealt!
		assertEquals (top, ak.wastePile.peek()); 
	}
	
	public void testWasteController() {
		ModelFactory.init(ak.wastePile, "AD KH");
		
		MouseEvent press = this.createPressed(ak, ak.wasteView, 0, 0);
		Card top = ak.wastePile.peek();
		ak.wasteView.getMouseManager().handleMouseEvent(press);
		
		MouseEvent release = this.createReleased(ak, ak.foundationKingViews[1], 0, 0);
		ak.foundationKingViews[1].getMouseManager().handleMouseEvent(release);
		
		assertEquals (top, ak.foundationKingPile[1].peek());
		
		top = ak.wastePile.peek();
		ak.wasteView.getMouseManager().handleMouseEvent(press);
		
		release = this.createReleased(ak, ak.foundationAceViews[1], 0, 0);
		ak.foundationAceViews[1].getMouseManager().handleMouseEvent(release);
		
		assertEquals (top, ak.foundationAcePile[1].peek());
		
	}
	
	public void testTableauController() {
		ModelFactory.init(ak.tableauPile[1], "KH");
		ModelFactory.init(ak.tableauPile[2], "AH");
		
		MouseEvent press = this.createPressed(ak, ak.tableauViews[1], 0, 0);
		Card top = ak.tableauPile[1].peek();
		ak.tableauViews[1].getMouseManager().handleMouseEvent(press);
		
		MouseEvent release = this.createReleased(ak, ak.foundationKingViews[1], 0, 0);
		ak.foundationKingViews[1].getMouseManager().handleMouseEvent(release);
		
		assertEquals (top, ak.foundationKingPile[1].peek());
		
		top = ak.tableauPile[2].peek();
		ak.tableauViews[2].getMouseManager().handleMouseEvent(press);
		
		release = this.createReleased(ak, ak.foundationAceViews[1], 0, 0);
		ak.foundationAceViews[1].getMouseManager().handleMouseEvent(release);
		
		assertEquals (top, ak.foundationAcePile[1].peek());
		
		// Test mouse release
		ModelFactory.init(ak.tableauPile[1], "");
		press = this.createPressed(ak, ak.wasteView, 0, 0);
		top = ak.wastePile.peek();
		ak.wasteView.getMouseManager().handleMouseEvent(press);
		
		release = this.createReleased(ak, ak.tableauViews[1], 0, 0);
		ak.tableauViews[1].getMouseManager().handleMouseEvent(release);
		assertEquals (top, ak.tableauPile[1].peek());
		
	}
	
	public void testFoundationController() {
		ModelFactory.init(ak.foundationAcePile[1], "AC 2C 3C 4C 5C 6C 7C 8C 9C 10C JC QC");
		ModelFactory.init(ak.foundationKingPile[1], "KD");
		
		MouseEvent press = this.createPressed(ak, ak.foundationAceViews[1], 0, 0);
		Card top = ak.foundationAcePile[1].peek();
		ak.foundationAceViews[1].getMouseManager().handleMouseEvent(press);
		
		MouseEvent release = this.createReleased(ak, ak.foundationKingViews[1], 0, 0);
		ak.foundationKingViews[1].getMouseManager().handleMouseEvent(release);
		
		assertEquals (top, ak.foundationKingPile[1].peek());
		
		top = ak.foundationKingPile[1].peek();
		ak.foundationKingViews[1].getMouseManager().handleMouseEvent(press);
		
		release = this.createReleased(ak, ak.foundationAceViews[1], 0, 0);
		ak.foundationAceViews[1].getMouseManager().handleMouseEvent(release);
		
		assertEquals (top, ak.foundationAcePile[1].peek());
		
	}
	
	public void testReserveController() {
		ModelFactory.init(ak.reserveColumn[1], "AC");
		ModelFactory.init(ak.reserveColumn[2], "KC");
		
		MouseEvent press = this.createPressed(ak, ak.reserveViews[1], 10, 10);
		Card top = ak.reserveColumn[1].peek();
		ak.reserveViews[1].getMouseManager().handleMouseEvent(press);
		
		MouseEvent release = this.createReleased(ak, ak.foundationAceViews[1], 0, 0);
		ak.foundationAceViews[1].getMouseManager().handleMouseEvent(release);
		
		assertEquals (top, ak.foundationAcePile[1].peek());
		
		press = this.createPressed(ak, ak.reserveViews[2], 0, 0);
		top = ak.reserveColumn[2].peek();
		ak.reserveViews[2].getMouseManager().handleMouseEvent(press);
		
		release = this.createReleased(ak, ak.foundationKingViews[1], 0, 0);
		ak.foundationKingViews[1].getMouseManager().handleMouseEvent(release);
		
		assertEquals (top, ak.foundationKingPile[1].peek());
		
	}
	
	
	/* Test main file */
	public void testAcesAndKings() {
		
		assertTrue(ak.getName().equals("ignakagawa-Aces and Kings"));
		assertTrue(ak.isTableauPile(ak.tableauPile[1]));
		assertTrue(ak.isFoundationAcePile(ak.foundationAcePile[1]));
		assertTrue(ak.isFoundationKingPile(ak.foundationKingPile[1]));
		assertTrue(ak.isWastePile(ak.wastePile));
		
	}

}
