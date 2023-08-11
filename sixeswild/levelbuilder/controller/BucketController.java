package levelbuilder.controller;

//import levelbuilder.entities.Edit;
//import levelbuilder.entities.EditBucket;
import levelbuilder.entities.Level;
import levelbuilder.entities.Tile;
import levelbuilder.view.LevelBuilderView;

/**
 * Bucket Controller handles creating a bucket and having sixes spawn
 * accordingly.
 * 
 *
 */
public class BucketController extends EditController {
	Level level;
	LevelBuilderView builder;
	int bucketNum;
	boolean isABucket;
	
	/**
	 * Constructor that creates an object for handling
	 * buckets.
	 * @param level, Level.
	 * @param builder, builder application.
	 */
	public BucketController(Level level, LevelBuilderView builder){
		this.level = level;
		this.builder = builder;
	}
	
	/*public void actionPerformed(ActionEvent e){
		JRadioButton radioButton[] = new JRadioButton[9];
		
		boolean bucket[] = new boolean[9];
		
		for (int i = 0; i < 9; i++){
			radioButton[i] = builder.getBucketColumn(i);
		}
		
		for (int j = 0; j < 9; j++){
			bucket[j] = radioButton[j].isSelected();
		}
		
		for (int k = 0; k < 9; k++){
			this.level.getBoard().getSquare(9,k).setBucket(bucket[k]);
		}
		
	}*/
	
	/**
	 * Indicates which column should have a bucket and
	 * notifies the game app.
	 * @param bucket, the specified column.
	 * @param isBucket, boolean
	 */
	public void updateBucket(int bucket, boolean isBucket){
		boolean activeFlag = false;
		for (int y = 8; y >= 0; y--){
			if(this.level.getBoard().getSquare(y, bucket).getActive() && !activeFlag){
				this.level.getBoard().getSquare(y, bucket).setBucket(isBucket);
				//EditBucket change = new EditBucket(bucket, isBucket);
				this.level.addEdit(this);
				bucketNum = bucket;
				isABucket = isBucket;
				activeFlag = true;
			}
			else if (!this.level.getBoard().getSquare(y, bucket).getActive()){
				this.level.getBoard().getSquare(y, bucket).setBucket(false);
			}
			else if (activeFlag){
				this.level.getBoard().getSquare(y, bucket).setBucket(false);
			}
		}
		//if (!this.level.emptyUndo()){
			this.level.getUndoneEdits().clear();
		//}
	}
	
	public void undo(){
		boolean activeFlag = false;
		for (int y = 8; y >= 0; y--){
			if(this.level.getBoard().getSquare(y, bucketNum).getActive() && !activeFlag){
				this.level.getBoard().getSquare(y, bucketNum).setBucket(!isABucket);
				activeFlag = true;
			}
			else if (!this.level.getBoard().getSquare(y, bucketNum).getActive()){
				this.level.getBoard().getSquare(y, bucketNum).setBucket(false);
			}
			else if (activeFlag){
				this.level.getBoard().getSquare(y, bucketNum).setBucket(false);
			}
		}
		EditController add = this.level.getMostRecentEdit();
		this.level.addUndo(add);
		this.level.getEdits().removeElementAt(0);
		this.builder.getBucketColumn(bucketNum).setSelected(!isABucket);
	}
	
	public void redo(){
		boolean activeFlag = false;
		for (int y = 8; y >= 0; y--){
			if(this.level.getBoard().getSquare(y, bucketNum).getActive() && !activeFlag){
				this.level.getBoard().getSquare(y, bucketNum).setBucket(isABucket);
				activeFlag = true;
			}
			else if (!this.level.getBoard().getSquare(y, bucketNum).getActive()){
				this.level.getBoard().getSquare(y, bucketNum).setBucket(false);
			}
			else if (activeFlag){
				this.level.getBoard().getSquare(y, bucketNum).setBucket(false);
			}
		}
		EditController add = this.level.getMostRecentUndo();
		this.level.addEdit(add);
		this.level.getUndoneEdits().removeElementAt(0);
		this.builder.getBucketColumn(bucketNum).setSelected(isABucket);
	}
}
