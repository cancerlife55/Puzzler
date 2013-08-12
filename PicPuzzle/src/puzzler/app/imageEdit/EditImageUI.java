package puzzler.app.imageEdit;

import puzzler.app.imageRetreive.Camera;
import puzzler.app.imageRetreive.Image;
import puzzler.app.puzzleGenerator.PuzzleGeneratorUI;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.os.Bundle;

public class EditImageUI extends Activity implements OnClickListener{

	private Image imageObj;
	
	private Bundle extras;	
	
	private ImageEditor imageEditor;
	
	private Bitmap image;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		/*
		 * Create UI with edit control on the title bar or footer bar
		 */
		
		extras = getIntent().getExtras();
		
		//get imageObj
		if(extras.containsKey("image")){
			imageObj = (Image)extras.get("image");
		}
		
		setImage();
		
		imageEditor = new ImageEditor(image);
	}
	
	public void setImage(){
		image = imageObj.getImage();
	}

	
	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
		
		//if selected Puzzle Generate
		Intent i = new Intent(this, PuzzleGeneratorUI.class);
		i.putExtra("image", imageObj);
		startActivity(i); //start activty		
		finish(); // kill this activity 
		
		/*
		 * else ifs
		 */
		
	}
	
}
