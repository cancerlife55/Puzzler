package puzzler.app.imageRetreive;

import android.graphics.Bitmap;

public class RetrieveStoredImage extends Image{

	/**
	 * Class handles retrieval of images from gallery or SD storage
	 * 
	 */
	private static final long serialVersionUID = 102938475611L;

	/*
	 * Return image retrieved image from the list
	 */
	public Bitmap RetrieveImage(){
		return getImage();
	}
	
	/*
	 * Retrieve a list of all the images
	 */
	public void listImagesGallery(){
		
	}

}
