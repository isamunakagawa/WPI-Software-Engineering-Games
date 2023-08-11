package levelbuilder.entity;

import junit.framework.TestCase;
import levelbuilder.entities.Board;
import levelbuilder.entities.Level;
import levelbuilder.entities.Mode;
import levelbuilder.entities.Mode.gameMode;
import levelbuilder.entities.Selection;
import levelbuilder.entities.Square;
import levelbuilder.entities.Tile;
import levelbuilder.entities.TileGenerator;
import levelbuilder.view.Application;

/**
 * 
 * @author Isamu Nakagawa
 *
 */

public class TestSixesWildEntity extends TestCase {
	
	protected Application gameWindow;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		gameWindow = new Application();
		gameWindow.getAppFrame().setVisible(true);
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testBoard() {
		
		TileGenerator tileGenerator = new TileGenerator();
		Board board = new Board(tileGenerator);
		//board.initialize();
		//board.fillBoard();
		
	}
	
	public void testLevel() {
		
		int countdown = 0;
		int goalscore[] = {2,2,2,2,2,2};
		int multProb[] = {2,2,2};
		int valProb[] = {2,2,2,2,2,2};
		Level lv = new Level(new Board(), new Mode(gameMode.PUZZLE, countdown), goalscore);
		
	}
	
	public void testMode() {
		
		Mode mode = new Mode(gameMode.LIGHTNING, 10);
		mode.decrement();
		assertFalse(mode.isElimination());
		assertFalse(mode.isPuzzle());
		assertFalse(mode.isRelease());
		assertTrue(mode.isLightning());
		
	}
	
	public void testSelection() {
		
		Tile tile = new Tile(1, 2);
		Selection selection = new Selection();
		selection.addTile(tile);
		assertEquals(selection.getTiles().get(0), tile);
		
		assertEquals(selection.checkForSix(), false);
		
		assertEquals(selection.sumTiles(), 1);
		
		selection.clearCollection();
		
		assertEquals(selection.sumTiles(), 0);
		
	}
	
	public void testSquare() {
		
		Square square = new Square(0, 0);
		Tile tile = new Tile(1, 2);
		
		square.setTile(tile);
		assertEquals(square.getTile(), tile);
		assertEquals(square.getActive(), true);
		assertEquals(square.getCol(), 0);
		assertEquals(square.getRow(), 0);
		
		square.setBucket(true);
		assertEquals(square.getBucket(), true);
		
	}
	
	public void testTile() {
		
		Tile tile = new Tile(0, 2);
		tile.getMultiplier();
		tile.getValue();
		
		
	}
	
	public void testTileGenerator() {
		
		TileGenerator tileGenerator = new TileGenerator();
		tileGenerator.getMultProb(0);
		tileGenerator.getValProb(0);
		//tileGenerator.makeNewTile();
		tileGenerator.initialize();
	}
	

}
