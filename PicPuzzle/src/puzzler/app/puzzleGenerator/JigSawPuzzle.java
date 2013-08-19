package puzzler.app.puzzleGenerator;

import java.util.ArrayList;
import java.util.HashMap;

import android.graphics.Bitmap;

public class JigSawPuzzle extends Puzzle{

	private ArrayList<PuzzleSlice> puzzle;
	
	private PuzzleSetting PuzzleSettings;

	private Bitmap imgCopy;
	
	public JigSawPuzzle(Bitmap image){
		puzzle = new ArrayList<PuzzleSlice>();
		
		PuzzleSettings = new PuzzleSetting();
		
		createPuzzle(image, PuzzleSettings);
	}
	
	@Override
	public void createPuzzle(Bitmap img, PuzzleSetting settings) {
		//loop through image slicing it and storing
		this.imgCopy = img;
		
		int x_puzzles = settings.getXpuzzles();
		
		int y_puzzles = settings.getYpuzzles();

		int width   = settings.getSliceWidth();		

		int height   = settings.getSliceHeight();
		
		int x_loc = 0;
		
		int y_loc = 0;
				
		Bitmap sliceImage = null;
		
		for (int y = 0; y < y_puzzles; y++){
			y_loc = y * height;
			
			for (int x = 0; x < x_puzzles; x++ ){					
				x_loc = x * width;
				
				sliceImage =Bitmap.createBitmap(imgCopy, x_loc, y_loc , width, height);
				
				puzzle.add(new PuzzleSlice(x_loc, y_loc, width, height, sliceImage));
				
			}
			
		}
	}


	public void overRideSettings(HashMap<String, Object> settings){

	}

	@Override
	public ArrayList<PuzzleSlice> getPuzzleList() {
		return puzzle;
	}

	@Override
	public int getSlicesCount() {
		return puzzle.size();
	}
	
	public Bitmap getOriginalImage(){
		return imgCopy;
	}
}
