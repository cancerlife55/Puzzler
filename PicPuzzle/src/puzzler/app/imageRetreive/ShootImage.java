package puzzler.app.imageRetreive;

import android.app.Activity;
import android.content.Intent;
public class ShootImage extends Image{

	/*
	 * 
	 */
	private static final long serialVersionUID = 1102938475610L;

	public ShootImage(){
	
		
	}
	
	public void cameraCapturePhoto(Activity activity){
		/*
		 * Capture image from camera and retrieve Bitmap image
		 * Use Camera class to create Camera Surface View and capturing pic and return
		 * Image 
		 */
		Intent intent = new Intent(activity, Camera.class);
		intent.putExtra("imgObj", this);
		
		activity.startActivity(intent);
		
		/*
		 * Convert image captured to bitmap
		 */
		
	}

}
