package puzzler.app.puzzleGenerator;

import puzzler.app.imageEdit.EditImageUI;
import puzzler.app.imageRetreive.Image;
import puzzler.app.imageRetreive.RetrieveImage;
import puzzler.app.picpuzzle.R;
import puzzler.app.puzzleGenerator.PuzzlesViews.DrawPuzzleToViewJigSaw;
import puzzler.app.puzzleGenerator.PuzzlesViews.DrawPuzzleToViewRubik;
import puzzler.app.solver.gamer.Gamer;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class PuzzleGeneratorUI extends Activity {

	private static final String TAG = "PUZZLEGENERATE";

	private Bundle extras;
	
	private Image imageObj;

	private Bitmap image;
			
	private Button jigsaw;

	private Button rubikCube;

	private Button next;
	
	private Puzzle puzzlejig;
	
	private Puzzle puzzlerubik;

	private LinearLayout layout;

	private DrawPuzzleToViewJigSaw puzzleJigSawDraw;
	
	private DrawPuzzleToViewRubik puzzleRubikDraw;

	private PuzzleSetting settings;
	
	private int gameType = 1; //jig saw
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.puzzle_generate);		

		extras = getIntent().getExtras();
		
		if(extras.containsKey("image")){ imageObj = (Image)extras.get("image");	}				
				
		settings = new PuzzleSetting(this);
		
		layout = (LinearLayout) findViewById(R.id.picholder);		
		
		setImageGeneratePuzle();
		
		puzzlejig = new JigSawPuzzle(image, settings);
		
		puzzlerubik = new RubikCubePuzzle(image);
				
		jigsaw = (Button)findViewById(R.id.jigSawPuzzle);
		jigsaw.setOnClickListener(new View.OnClickListener() {public void onClick(View v) { drawJigSaw();  }  });
		
		//rubikCube = (Button)findViewById(R.id.rubikCubePuzzle);
		//rubikCube.setOnClickListener(new View.OnClickListener() { public void onClick(View v) {  drawRubikCube();  } });
	
		next = (Button)findViewById(R.id.rubikCubePuzzle);
		next.setOnClickListener(new View.OnClickListener() { 
			public void onClick(View v) { 
				Intent i = new Intent(PuzzleGeneratorUI.this, Gamer.class);
				 i.putExtra("gamePuzzle", puzzleJigSawDraw);
				 i.putExtra("gameType", gameType);
				 startActivity(i); //start activty
			} 
		});
	}

	public void setImageGeneratePuzle(){		
		image = new RetrieveImage(imageObj.getPath()).getImage();
	}
	
	public void drawJigSaw(){
		puzzleJigSawDraw = new DrawPuzzleToViewJigSaw(this,image, (JigSawPuzzle)puzzlejig, settings);
		
		layout.removeAllViews();
				
		LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.FILL_PARENT);

		layout.addView(puzzleJigSawDraw,lp);
		
	}
	
	public void drawRubikCube(){
		puzzleRubikDraw = new DrawPuzzleToViewRubik(this,image, (RubikCubePuzzle)puzzlerubik, settings);
      
		layout.removeAllViews();
		
		LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.FILL_PARENT);

		layout.addView(puzzleRubikDraw,lp);
	}
}
