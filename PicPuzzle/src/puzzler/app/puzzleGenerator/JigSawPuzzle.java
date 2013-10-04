package puzzler.app.puzzleGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.Log;

public class JigSawPuzzle implements Puzzle{

	private static final String TAG = "JIGSAWPUZZLE";

	private ArrayList<PuzzleSlice> puzzle;
	
	private PuzzleSetting PuzzleSettings = new PuzzleSetting();

	private Bitmap imgCopy;

	private int width;

	private int x_puzzles;

	private int y_puzzles;

	private int height;

	private Canvas canvas;
		
	public JigSawPuzzle(Bitmap image){	
		this.imgCopy = image;
		
		x_puzzles = PuzzleSettings.getXpuzzles();
		
		y_puzzles = PuzzleSettings.getYpuzzles();

		width   = PuzzleSettings.getSliceWidth();		

		height   = PuzzleSettings.getSliceHeight();	
	}
	
	public JigSawPuzzle(Bitmap image, PuzzleSetting settings){
		generatePuzzle();
	}	
	
	@Override
	public void generatePuzzle() {
		puzzle = new ArrayList<PuzzleSlice>();
		
		int x_loc, y_loc;
				
		Bitmap sliceImage;
		
		PuzzleSlice p ;
		
		int counter = 1;
		
		for (int y = 0; y < y_puzzles; y++){
			y_loc = y * height;
			
			for (int x = 0; x < x_puzzles; x++ ){					
				x_loc = x * width;
				
				sliceImage = Bitmap.createBitmap(imgCopy, x_loc, y_loc , width, height);
				p = new PuzzleSlice(x_loc, y_loc, width, height, y, x, sliceImage, counter);
				//Log.d(TAG, "Creation time :-> X : " + (p.getX_loc()) + ", Y : " + (p.getY_loc()));
				//Log.d(TAG,p.getSlice_num() +"");
				puzzle.add(p);
				
				counter++;
			}
			
		}
	}


	public void generate(){
		generatePuzzle();
	}
	
	public void overRideSettings(HashMap<String, Object> settings){

	}

	@SuppressWarnings("unused")
	private ArrayList<List<Integer>>  randomizePositions(){
		ArrayList<List<Integer>> randoms = new ArrayList<List<Integer>>();
		
		List<Integer> positions = new ArrayList<Integer>();
		
		for(int r = 1; r < y_puzzles; r++){
			for (int c = 1; c < x_puzzles; c++){
				positions.add( c ); 
			}
			
			Collections.shuffle(positions);
			
			randoms.add(positions);
		}
		
		Collections.shuffle(randoms);
		
	return randoms;
	}
	
	public Bitmap drawPuzzle(){
		Bitmap mBitmap = Bitmap.createBitmap(x_puzzles * width, y_puzzles * height, Bitmap.Config.ARGB_8888);
		
		canvas = new Canvas(mBitmap);
		    	
		//Collections.shuffle(puzzle);
		
		int x = 0, y = 0;

		Iterator<PuzzleSlice> iterator = puzzle.iterator();
		PuzzleSlice slice;
		Log.d(TAG,puzzle.size()+" size");
		while(iterator.hasNext())
		{
			if(x >= x_puzzles){
				x = 0;
				y++;
			}
			
			slice = iterator.next();
			
			canvas.drawBitmap(slice.getSlice_image(), x * width, y * height, null);
			//canvas.drawBitmap(slice.getSlice_image(), x * width, y * height, null);
			//canvas.drawBitmap(myPuzzle.getSlice_image(), myPuzzle.getX_loc(), myPuzzle.getY_loc(), null);
			
			Log.d(TAG, slice.getSlice_num()+"");
			//Log.d(TAG, slice.getX_loc()+"");
			//Log.d(TAG, "X : " + (slice.getX_loc()) + ", Y : " + (slice.getY_loc()));
		//	Log.d(TAG, "X : " + (x * width) + ", Y : " + (y * height));
			x++;
		}
		return mBitmap;
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
