package puzzler.app.imageEdit;

import puzzler.app.imageRetreive.Image;
import puzzler.app.imageRetreive.RetrieveImage;
import puzzler.app.picpuzzle.R;
import puzzler.app.puzzleGenerator.PuzzleGeneratorUI;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
 
public class EditImageUI extends Activity{

	private static final String TAG = "EDITIMAGE";

	private Image imageObj;
	
	private Bundle extras;	
	
	private ImageEditorHelpers imageEditor;
	
	private Bitmap image;
		
	private ImageView imageView;
	
	private Display mDisplay;

	private Button next;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.edit_image);
		
		mDisplay= getWindowManager().getDefaultDisplay();
		
		imageView = (ImageView) findViewById(R.id.imageViewEdit);
			
		next = (Button)findViewById(R.id.puzzleType); //to change mimik next to go to puzzle generator
		next.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 Intent i = new Intent(EditImageUI.this, PuzzleGeneratorUI.class);
				 i.putExtra("image", imageObj);
				 startActivity(i); //start activty
			}
			
		});
		
		extras = getIntent().getExtras();
		
		//get imageObj
		if(extras.containsKey("image")){
			imageObj = (Image)extras.get("image");
			
			displayImage();
		}
		
	}
	
	public void setImage(){		
		image = new RetrieveImage(imageObj.getPath()).getImage();
	}
		
	private void displayImage(){
		setImage();
		
		imageView.getLayoutParams().height = mDisplay.getHeight() - 40;
		imageView.getLayoutParams().width  = mDisplay.getWidth() - 40;
		
		if(image != null)
			imageView.setImageBitmap(image);
		else
			Log.d(TAG,"Error image");
	}
}
