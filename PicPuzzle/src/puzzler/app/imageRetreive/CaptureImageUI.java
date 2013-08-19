package puzzler.app.imageRetreive;

import puzzler.app.imageEdit.EditImageUI;
import puzzler.app.picpuzzle.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CaptureImageUI extends Activity {
	private Image imageObj;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		/*
		 * Create User interface to display buttons to either take picture or scroll 
		 * from gallery/SD card 
		 */		

		setContentView(R.layout.capture_image);

		Button btn1 = (Button)findViewById(R.id.gallery);
		btn1.setOnClickListener(myhandler);
		
		Button btn2 = (Button)findViewById(R.id.capture);
		btn2.setOnClickListener(myhandler);
	}

	
	View.OnClickListener myhandler = new View.OnClickListener() {
	   public void onClick(View v) {
	      // it was the 1st button			
			
		   switch(v.getId()){			
		   case R.id.capture:
			  
			   
			   break;
		   case R.id.gallery:
			   
			   break;			
		   }
		   
		   imageObj = get_image_test();  //if selected Puzzle Generate
		   
		   Intent i = new Intent(CaptureImageUI.this, EditImageUI.class);
		   i.putExtra("image", imageObj);
		   startActivity(i); //start activty	
		   
		   //finish(); // kill this activity
	   }
	};
	
	private Image get_image_test(){
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		
		Image img =  new Image(bitmap);
		
		return img;
	}
}