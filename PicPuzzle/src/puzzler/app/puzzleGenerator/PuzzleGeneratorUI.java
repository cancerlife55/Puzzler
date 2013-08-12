package puzzler.app.puzzleGenerator;

import puzzler.app.imageRetreive.Image;
import puzzler.app.solver.SolverUI;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

public class PuzzleGeneratorUI extends Activity implements OnClickListener{

	private Bundle extras;
	private Image imageObj;

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
	}

	@Override
	public void onClick(DialogInterface arg0, int arg1) {
		// TODO Auto-generated method stub
		
		/*
		 * if selected solve puzzle call Intent generating puzzle solzer (solverUI)
		 */
		
		//if selected Puzzle Generate
		Intent i = new Intent(this, SolverUI.class);
		i.putExtra("image", imageObj);
		startActivity(i); //start activty		
		finish(); // kill this activity 
		
		/*
		 * Other else ifs'
		 */
		
	}
	
}
