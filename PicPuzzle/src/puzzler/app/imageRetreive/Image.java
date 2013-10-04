package puzzler.app.imageRetreive;

import java.io.Serializable;
import java.net.URL;

import puzzler.app.picpuzzle.MainActivity;
import puzzler.app.picpuzzle.R;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

public class Image implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 102938475611L;
	
	private String absoluteImagePath;
	
	public Image(){
		
	}
	
	public Image(Uri uri){
		//get image from gallery or camera via link and process it here
		
	}
	
	public Image(String image){
		setPath(image);
	}
	
	public void setPath(String image){
		absoluteImagePath = image;
	}
	
	public String getPath(){
		return absoluteImagePath;
	}
}
