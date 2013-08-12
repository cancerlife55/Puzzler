package puzzler.app.imageEdit;

import android.graphics.Bitmap;

public class ImageEditor {

	private Bitmap img;
	
	ImageEditor(Bitmap image){
		img = image;
	}
	
	/*
	 * Add other image editing methods
	 * 
	 * Method signature should be reserved (return -> Bitmap and return type -> public)
	 */	
	
	
	public Bitmap GrayScale(){
		/*
		 * Add code here to create grey scale
		 */
		
		return img;
	}
	
	public Bitmap style1(){
		/*
		 * Add code here for styling
		 * 
		 */
		return img;
	}	
	
	public Bitmap style2(){
		/*
		 * Add code here for styling
		 * 
		 */
		return img;
	}	
}

