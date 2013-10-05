package puzzler.app.puzzleGenerator;

import java.util.ArrayList;

import puzzler.app.imageRetreive.Image;
import puzzler.app.imageRetreive.RetrieveImage;
import puzzler.app.picpuzzle.R;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class PuzzleGeneratorUI extends Activity {

	private static final String TAG = "PUZZLEGENERATE";

	private Bundle extras;
	
	private Image imageObj;

	private Bitmap image;
	
	private JigSawPuzzle jsp;
	
	private RubikCubePuzzle rcp;
		
	private Display mDisplay;

	private Button jigsaw;

	private Button rubikCube;
	
	private Puzzle puzzlejig;
	
	private Puzzle puzzlerubik;

	private LinearLayout layout;

	private DrawPuzzleToView puzzle;

	private PuzzleGeneratorUI myPGUI;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*
		 * Create UI to create the puzzle
		 * Image display in the middle with activity buttons on the action bar
		 * On selecting puzzle type, image is parsed to generate puzzle
		 */
		setContentView(R.layout.puzzle_generate);		
		
		myPGUI = this;
		
		mDisplay= getWindowManager().getDefaultDisplay();
		
		layout = (LinearLayout) findViewById(R.id.picholder);
		
		extras = getIntent().getExtras();
		
		//get imageObj
		if(extras.containsKey("image")){
			imageObj = (Image)extras.get("image");	
		}
		
		setImageGeneratePuzle();
		
		puzzlejig = new JigSawPuzzle(image);
		puzzlerubik = new RubikCubePuzzle(image);
				
		jigsaw = (Button)findViewById(R.id.jigSawPuzzle);
		jigsaw.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
                // Perform action on click
				puzzle = new DrawPuzzleToView(myPGUI,image, (JigSawPuzzle)puzzlejig);
				
				layout.removeAllViews();
				//puzzlejig.generatePuzzle();				
				LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.FILL_PARENT);
				layout.addView(puzzle,lp);
				
        		//imageView.setImageBitmap(puzzlejig.drawPuzzle());
            }
        });
		
		rubikCube = (Button)findViewById(R.id.rubikCubePuzzle);
		rubikCube.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	/*
        		 * Other else ifs'
        		 */

        		
            }
        });
	}

	public void setImageGeneratePuzle(){		
		image = new RetrieveImage(imageObj.getPath()).getImage();
	}
}
