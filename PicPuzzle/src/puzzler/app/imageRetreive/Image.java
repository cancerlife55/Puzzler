package puzzler.app.imageRetreive;

import java.io.Serializable;

import android.graphics.Bitmap;

public class Image implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 102938475611L;
	
	private Bitmap img;
	
	public Image(){
		
	}
	
	public Image(Bitmap image){
		setImage(image);
	}
	
	public void setImage(Bitmap image){
		img = image;
	}
	
	public Bitmap getImage(){
		return img;
	}
}
