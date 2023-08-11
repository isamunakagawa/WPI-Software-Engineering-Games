package levelbuilder.controller;

import levelbuilder.entities.*;
import levelbuilder.view.*;

public abstract class EditController {
	/*protected Level level;
	protected Application application;
	
	public EditController(Level level, Application application){
		this.level = level;
		this.application = application;
	}*/
	public EditController(){
		
	}
	
	public abstract void undo(); //undo an edit
		//do we want to store edits in an array (stack) so that we can easily add and remove them?
		//with undo, we probably want a second array to store undos until another edit is made.
		//that way, redo could easily be implemented
	
	public abstract void redo(); //redo an edit
		//do we want to store edits in an array (stack) so that we can easily add and remove them?
}
