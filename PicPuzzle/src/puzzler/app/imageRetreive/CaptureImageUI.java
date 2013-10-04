package puzzler.app.imageRetreive;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import puzzler.app.imageEdit.EditImageUI;
import puzzler.app.picpuzzle.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class CaptureImageUI extends Activity {
	protected static final int PICK_FROM_GALLERY = 1;
	protected static final int PICK_FROM_CAMERA = 2;
	private Image imageObj;

	private final String path = "/picPuzzle/";
	private String file_name = "";;
	private String mCapturedImagePath;

	private boolean proceedEdit = false;

	private final String TAG = "STAN";

	private Uri uriSavedImage;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*
		 * Create User interface to display buttons to either take picture or
		 * scroll from gallery/SD card
		 */

		imageObj = new Image();

		setContentView(R.layout.capture_image);

		Button btn1 = (Button) findViewById(R.id.gallery);
		btn1.setOnClickListener(myhandler);

		Button btn2 = (Button) findViewById(R.id.capture);
		btn2.setOnClickListener(myhandler);
	}

	View.OnClickListener myhandler = new View.OnClickListener() {
		public void onClick(View v) {

			File file = createDirIfNotExists(), imagefile;

			switch (v.getId()) {
			case R.id.capture:
				file_name = new SimpleDateFormat("yyyyMMddHHmmss")
						.format(new Date()) + ".jpg";

				imagefile = new File( file.getPath() + File.separator + file_name );
				
				mCapturedImagePath = imagefile.getAbsolutePath();

				uriSavedImage = Uri.fromFile(imagefile);

				Log.d(TAG, mCapturedImagePath);
				
				Intent intent = new Intent(
						android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

				intent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);

				startActivityForResult(intent, PICK_FROM_CAMERA);

				break;

			case R.id.gallery:
				Intent intent_gallery = new Intent();
				intent_gallery.setType("image/*");
				intent_gallery.setAction(Intent.ACTION_GET_CONTENT);

				startActivityForResult(
						Intent.createChooser(intent_gallery, "Select Picture"),
						PICK_FROM_GALLERY);

				break;
			}
		}
	};

    private void addPhotoToGallery(Uri photoUri) {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);

        mediaScanIntent.setData(photoUri);

        this.sendBroadcast(mediaScanIntent);
   }
    
	public File createDirIfNotExists() {
		File file = new File(Environment.getExternalStorageDirectory(), path);

		if (!file.exists()) {
			if (!file.mkdirs()) {
				Log.e("TravellerLog :: ", "Problem creating Image folder");
			}
		}
		return file;
	} 
	
    public String getPath(Uri uri) {
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }
    
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		Log.d(TAG, "Loading file " + data + resultCode);

		if (requestCode == PICK_FROM_GALLERY && resultCode == RESULT_OK ) {			
			Uri selectedImageUri = data.getData();
			mCapturedImagePath = getPath(selectedImageUri);
            System.out.println("Image Path : " + mCapturedImagePath);

			imageObj.setPath(mCapturedImagePath);

			proceedEdit = true;
		} else if (requestCode == PICK_FROM_CAMERA && resultCode == RESULT_OK ) {
			imageObj.setPath(mCapturedImagePath);

			addPhotoToGallery(uriSavedImage);
			
			proceedEdit = true;
		}

		if (proceedEdit) {
			Intent i = new Intent(CaptureImageUI.this, EditImageUI.class);
			i.putExtra("image", imageObj);
			startActivity(i); 
		}
	}
}