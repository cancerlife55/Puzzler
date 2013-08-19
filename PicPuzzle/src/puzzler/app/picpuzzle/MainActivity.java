package puzzler.app.picpuzzle;

import puzzler.app.imageRetreive.CaptureImageUI;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		startActivity( new Intent(this.getApplicationContext(), CaptureImageUI.class));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/*
	 * Order of execution should be;
	 * 1. a blunt UI showing game description and a short narrative with cool UI
	 * 2. On clicking start, display the CaptureImageUI
	 * 3. Then go to EditImageUI
	 * 4. Generate puzzle
	 * 5. Solver UI
	 */
}
