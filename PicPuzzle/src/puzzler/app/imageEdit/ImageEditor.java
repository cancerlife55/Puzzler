package puzzler.app.imageEdit;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.LayerDrawable;
import android.widget.ImageView;

public class ImageEditor {

	private Bitmap img;
	private ImageView imageView;

	ImageEditor(Bitmap image){
		img = image;
	}
	
	ImageEditor(ImageView imageView){
		this.imageView = imageView;
	}
	
	private Bitmap getImageFromImageView(){
		try{
			img = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
		}catch(Exception e){
			//img = ((BitmapDrawable)((LayerDrawable)imageView.getDrawable()).getDrawable(0)).getBitmap(‌​);
		}
		
		return img;
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

