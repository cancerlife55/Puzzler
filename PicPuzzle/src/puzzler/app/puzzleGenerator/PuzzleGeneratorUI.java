package puzzler.app.puzzleGenerator;

import puzzler.app.imageRetreive.Image;
import puzzler.app.solver.SolverUI;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.os.Bundle;

public class PuzzleGeneratorUI extends Activity implements OnClickListener{

	private Bundle extras;
	private Image imageObj;

	private Bitmap image;
	
	private JigSawPuzzle jsp;
	
	private RubikCubePuzzle rcp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		/*
		 * Create UI to create the puzzle
		 * Image display in the middle with activity buttons on the action bar
		 * On selecting puzzle type, image is parsed to generate puzzle
		 */

		extras = getIntent().getExtras();
		
		//get imageObj
		if(extras.containsKey("image")){
			imageObj = (Image)extras.get("image");
		}
		
		setImage();
	}

	@Override
	public void onClick(DialogInterface arg0, int arg1) {
		// TODO Auto-generated method stub
		/*
		 * With the select of puzzle type, change the UI with the image solved
		 * puzzle
		 */
		
		/*
		 * if selected jig saw
		 */
		jsp = new JigSawPuzzle(image);
		
		/*
		 * Other else ifs'
		 */
		rcp = new RubikCubePuzzle(image);
		
		/*
		 * else if on select solverUI
		 *if selected Puzzle Generate
		 */
		
		Intent i = new Intent(this, SolverUI.class);
			/*
			 * nested if to choose set put Extra if jigsaw or rubik cube
			 */
		
		//i.putExtra("image", imageObj);
		
		startActivity(i); //start activty		
		finish(); // kill this activity 
		
	}
	
	private void setImage() {
		// TODO Auto-generated method stub
		image = imageObj.getImage();
	}
}
