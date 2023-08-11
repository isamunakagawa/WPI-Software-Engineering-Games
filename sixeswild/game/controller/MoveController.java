package game.controller;

import game.entity.Level;
import game.entity.Square;
import game.view.BoardView;
import game.view.GameViewApplication;
import game.view.LevelView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * 
 * 
 */

public class MoveController extends MouseAdapter {
	
	/** The given level of the application.*/
	protected Level level;
	
	/** The boundary class for a level.*/
	protected LevelView levelView;
	
	/** The boundary class for a board.*/
	protected BoardView bv;
	
	/** The normal move made by a player.*/
	protected PuzzleMove puzzleMove;
	
	/** The game application.*/
	protected GameViewApplication app;

	/** The remove tile power up move made by a player.*/
	protected RemoveTilePowerUp removePowerUp;
	
	/** The square's column.*/
	int squareCol;
	
	/** The square's row.*/
	int squareRow;
	
	/** The current square being selected by the player.*/
	protected Square currentSquare;
	
	/** Boolean that handles selection.*/
	private boolean willSelect = false;
	
	/** A SwapPowerUp instance.*/
	protected SwapPowerUp swapPowerUp;
	
	protected boolean timerStarted = false;

	/**
	 * MoveController constructor that creates a controller object
	 * that handles player interaction with the board.
	 * @param level
	 * @param levelView
	 * @param app 
	 */
	public MoveController(Level level, LevelView levelView, GameViewApplication app) {
		this.level = level;
		this.levelView = levelView;
		this.app = app;
		this.bv = this.levelView.getBoardView();
	}

	/**
	 * Set up press events for the board view.
	 */
	public void register() {
		this.bv.addMouseListener(this);
		this.bv.addMouseMotionListener(this);
	}

	
	@Override
	public void mousePressed(MouseEvent me) {
		/*
		 * 1. Create the puzzle move 
		 * 2. Give the square (tile) currently pressed
		 * over to the puzzle selection
		 */
		try {
		squareCol = (me.getX() / 49);
		squareRow = (me.getY() / 49);
		currentSquare = bv.getSquare(squareRow, squareCol);
		
		if (currentSquare.isActive() && !currentSquare.isBucket()) {
			
			if(this.level.getMode().isLightning() && timerStarted == false) {
				new LightningTimerController(level.getMode().getCountdown(), levelView);
				timerStarted = true;
			}
			
			
			puzzleMove = new PuzzleMove(currentSquare.getTile(), currentSquare);
			removePowerUp = new RemoveTilePowerUp(this.level, this.bv, currentSquare);
			willSelect = true;
			currentSquare.setSelected(true);
			bv.setHighlight(squareRow, squareCol);
		}
		
		System.out.println("Square " + squareRow + "," + squareCol + " Clicked");
		
		if (this.level.isRemoveActive() && !currentSquare.isBucket() ) {
			removePowerUp.RemovePowerUp();
		}
		else if(swapPowerUp != null && !currentSquare.isBucket()) {
			
			swapPowerUp.squareToSwap(currentSquare);
			swapPowerUp.swap();
			this.level.swapActiveToggle(false);
			swapPowerUp = null;
		}
		else if(this.level.swapState() && !currentSquare.isBucket() ) {
			level.useSwapMove();
			swapPowerUp = new SwapPowerUp(currentSquare);
		}
		else {
			puzzleMove = new PuzzleMove(currentSquare.getTile(), currentSquare);
		}
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			puzzleMove.selection.clearCollection();
			puzzleMove.selection.clearSqCollection();
			puzzleMove.selection.unSelect();
			willSelect = false;
			bv.updateColors();
		}
		/*
		
		*/
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		if (willSelect && !this.level.swapState()) {
			try {
				squareCol = (me.getX() / 49);
				squareRow = (me.getY() / 49);
				boolean willAdd = false;

				if (squareCol == currentSquare.getCol() + 1
						&& squareRow == currentSquare.getRow()
						&& currentSquare.isActive() && !currentSquare.isBucket()) {
					willAdd = true;
				} else if (squareCol == currentSquare.getCol() - 1
						&& squareRow == currentSquare.getRow()
						&& currentSquare.isActive() && !currentSquare.isBucket()) {
					willAdd = true;
				} else if (squareCol == currentSquare.getCol()
						&& squareRow == currentSquare.getRow() + 1
						&& currentSquare.isActive() && !currentSquare.isBucket()) {
					willAdd = true;
				} else if (squareCol == currentSquare.getCol()
						&& squareRow == currentSquare.getRow() - 1
						&& currentSquare.isActive() && !currentSquare.isBucket()) {
					willAdd = true;
				}
				 else if (puzzleMove.inSelection(bv.getSquare(squareRow, squareCol))) {
					 currentSquare = bv.getSquare(squareRow, squareCol);
					 willAdd = true;
				 }
				
				if (willAdd) {
					currentSquare = bv.getSquare(squareRow, squareCol);
					if (puzzleMove.addToSelection(currentSquare.getTile())) {
						puzzleMove.addToSqSelection(currentSquare);
						currentSquare.setSelected(true);
						bv.setHighlight(squareRow, squareCol);
						System.out.println("Tile " + squareRow + "," + squareCol + " added to selection!");
					} else {
						/*
						puzzleMove.selection.clearCollection();
						puzzleMove.selection.clearSqCollection();
						willSelect = false;
						bv.updateColors();
						*/
					}
				}
			} catch (java.lang.ArrayIndexOutOfBoundsException e) {
				puzzleMove.selection.clearCollection();
				puzzleMove.selection.clearSqCollection();
				puzzleMove.selection.unSelect();
				willSelect = false;
				bv.updateColors();
			}
		}
		

		
		
		/*
		 * 1. Check the validity of the square the mouse is currently dragged
		 * over 2. CONDITIONS: new square: x + 1, y + 0 x - 1, y + 0 x + 0, y +
		 * 1 x + 0, y - 0
		 * 
		 * square not added
		 * 
		 * 3. If conditions pass, add new square to stack
		 */

	}

	@Override
	public void mouseReleased(MouseEvent me) {
		if(!this.level.swapState() && puzzleMove != null) {
		try {
			squareCol = (me.getX() / 49);
			squareRow = (me.getY() / 49);
			System.out.println("Square " + squareRow + "," + squareCol + " Released");
			currentSquare = bv.getSquare(squareRow, squareCol);
			currentSquare.setSelected(true);
			
			if (currentSquare.isActive() && !currentSquare.isBucket()) {
				puzzleMove.addToSelection(currentSquare.getTile());
				puzzleMove.addToSqSelection(currentSquare);
			} else {
				puzzleMove.selection.clearCollection();
				puzzleMove.selection.clearSqCollection();
				bv.updateColors();
			}
			int score;
			if (puzzleMove.selection.checkForSix()) {
				score = puzzleMove.selection.calculateScore();
				this.level.increaseScore(score);
				this.levelView.getScoreLabel().setText( Integer.toString(this.level.getScore()));
				System.out.println("You Got Six!");
				this.levelView.decrementCountdown();
				//carries out elimination 
				if (this.level.getMode().isElimination()) {
					EliminationController ec = new EliminationController(this.bv, puzzleMove.selection);
					ec.markSquares();
					this.bv.repaint();
				}
				
				GravityUpdateMove gum = new GravityUpdateMove(this.level.getBoard(), puzzleMove.selection);
				gum.gravity();
				gum.releaseGravity();
				
				ProgressBarController pgbar = new ProgressBarController(this.level, this.levelView);
				pgbar.updateBar();
				
				this.bv.repaint();
				CompletePuzzleController cpc = new CompletePuzzleController(this.levelView, this.level, this.app);
				CompleteReleaseController crc = new CompleteReleaseController(this.level, this.app);
				CompleteEliminationController cec = new CompleteEliminationController(this.level, this.app);
				RecordsController rc = new RecordsController();
				
				
				if (level.getMode().isPuzzle() || level.getMode().isLightning()) {
					if (cpc.hasWon() && cpc.isDone()) {
						//also stores the high score and unlocks new level.
						rc.stashLevelScore(level, levelView.getLevelNumber());
						cpc.exitLevel();
					} else if (!cpc.hasWon() && cpc.isDone()) {
						cpc.exitLevel();
					} else if (cpc.isDone()){
						cpc.exitLevel();
					}
				} else if (this.level.getMode().isElimination()) {
					if (cec.hasWon() && cec.isDone()) {
						//also stores the high score and unlocks new level.
						rc.stashLevelScore(level, levelView.getLevelNumber());
						cec.exitLevel();
					} else if (!cec.hasWon() && cec.isDone()) {
						cec.exitLevel();
					}
				} else if (this.level.getMode().isRelease()) {
					if (crc.hasWon() && crc.isDone()) {
						//also stores the high score and unlocks new level.
						rc.stashLevelScore(level, levelView.getLevelNumber());
						crc.exitLevel();
					} else if (!crc.hasWon() && crc.isDone()) {
						crc.exitLevel();
					}
				}
				
				
			}
			
			//clear the collection of selection
			puzzleMove.selection.clearCollection();
			puzzleMove.selection.clearSqCollection();
			puzzleMove.selection.unSelect();
			bv.updateColors();
			
			CompletePuzzleController cpc = new CompletePuzzleController(this.levelView, this.level, this.app);
			CompleteReleaseController crc = new CompleteReleaseController(this.level, this.app);
			CompleteEliminationController cec = new CompleteEliminationController(this.level, this.app);
			RecordsController rc = new RecordsController();
			if (this.level.getMode().isPuzzle() || this.level.getMode().isLightning()) {
				if (cpc.hasWon() && cpc.isDone()) {
					//also stores the high score and unlocks new level.
					rc.stashLevelScore(level, levelView.getLevelNumber());
					cpc.exitLevel();
				} else if (!cpc.hasWon() && cpc.isDone()) {
					cpc.exitLevel();
				} else if (cpc.isDone()){
					cpc.exitLevel();
				}
			} else if (this.level.getMode().isElimination()) {
				if (cec.hasWon() && cec.isDone()) {
					//also stores the high score and unlocks new level.
					rc.stashLevelScore(level, levelView.getLevelNumber());
					cec.exitLevel();
				} else if (!cec.hasWon() && cec.isDone()) {
					cec.exitLevel();
				}
			} else if (this.level.getMode().isRelease()) {
				if (crc.hasWon() && crc.isDone()) {
					//also stores the high score and unlocks new level.
					rc.stashLevelScore(level, levelView.getLevelNumber());
					crc.exitLevel();
				} else if (!crc.hasWon() && crc.isDone()) {
					crc.exitLevel();
				}
			}

			
			} catch (java.lang.ArrayIndexOutOfBoundsException e) {
				puzzleMove.selection.clearCollection();
				puzzleMove.selection.clearSqCollection();
				puzzleMove.selection.unSelect();
				bv.updateColors();
			}
			
		
		}
			/*
			 * 1. Call selection method: check for six 2. If check for six
			 * passes (selection method) 3. Calculate score 4. Add score to
			 * global level score 5. Update the progress bar 6. Remove the tiles
			 * from the board that are in the selection 7. Clear the selection
			 * 8. Initialize gravity controller to update board 9. Tile
			 * generator action
			 */

		
	}

}
