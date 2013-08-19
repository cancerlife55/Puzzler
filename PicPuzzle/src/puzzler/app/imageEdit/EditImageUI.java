package puzzler.app.imageEdit;

import puzzler.app.imageRetreive.Camera;
import puzzler.app.imageRetreive.Image;
import puzzler.app.picpuzzle.R;
import puzzler.app.puzzleGenerator.PuzzleGeneratorUI;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class EditImageUI extends Activity{

	private Image imageObj;
	
	private Bundle extras;	
	
	private ImageEditor imageEditor;
	
	private Bitmap image;
		
	private ImageView imageView;
	
	private Display mDisplay;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.edit_image);
		
		mDisplay= getWindowManager().getDefaultDisplay();
		
		imageView = (ImageView) findViewById(R.id.imageViewEdit);
				
		extras = getIntent().getExtras();
		
		//get imageObj
		if(extras.containsKey("image")){
			imageObj = (Image)extras.get("image");
		}
		
		setImage();
		
		displayImage();
		
		imageEditor = new ImageEditor(imageView);
	}
	
	public void setImage(){
		image = imageObj.getImage();
	}

		
	private void displayImage(){
		imageView.getLayoutParams().height = mDisplay.getHeight() - 40;
		imageView.getLayoutParams().width  = mDisplay.getWidth() - 40;
		
		imageView.setImageBitmap(image);
	}
	
	View.OnClickListener myhandler = new View.OnClickListener() {
	   public void onClick(View v) {
	     // it was the 1st button			
			
		 //if selected Puzzle Generate
		 Intent i = new Intent(EditImageUI.this, PuzzleGeneratorUI.class);
		 i.putExtra("image", imageObj);
		 startActivity(i); //start activty		
		 finish(); // kill this activity		   
	   }
	};
}
