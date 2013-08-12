package puzzler.app.imageRetreive;

import puzzler.app.imageEdit.EditImageUI;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

public class Camera extends Activity implements OnClickListener {

	private Image imgObj;
	
	private Bundle extras;
	
	public void onCreate(Bundle savedInstanceState){		
		extras = getIntent().getExtras();
		
		//get imageObj
		if(extras.containsKey("imgObj")){
			imgObj = (Image)extras.get("imgObj");
		}
	}

	@Override
	public void onClick(DialogInterface arg0, int arg1) {

		
	}


	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		/*
		 * retrieve image and set it to the bitmap object
		 */
		
		Bitmap image = null; //set to image captured in bitmap format
		
		setImage(image);
		
		Intent i = new Intent(this, EditImageUI.class);
		i.putExtra("image", imgObj);
		startActivity(i); //start Edit intent 
		
		finish();//kill current process
	}
	
	public void setImage(Bitmap image){
		imgObj.setImage(image);
	}
}

