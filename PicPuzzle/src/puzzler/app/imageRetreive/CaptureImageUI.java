package puzzler.app.imageRetreive;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;

public class CaptureImageUI extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		/*
		 * Create User interface to display buttons to either take picture or scroll 
		 * from gallery/SD card 
		 */
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
		/*
		 * If clicked capture image
		 */		
		ShootImage shootImage = new ShootImage();
		shootImage.cameraCapturePhoto(this);
		
		/*
		 * Else selected choose from gallery
		 *  
		 */
		RetrieveStoredImage rsi = new RetrieveStoredImage();
		//Create view to show gallery content
	}
}

