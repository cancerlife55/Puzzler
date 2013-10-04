package puzzler.app.puzzleGenerator;

import java.util.ArrayList;

import android.graphics.Bitmap;

interface  Puzzle {
	
	public abstract void generatePuzzle();
	
	public abstract ArrayList<PuzzleSlice> getPuzzleList();

	public abstract int getSlicesCount();
	
	public abstract Bitmap getOriginalImage();
	
	public abstract Bitmap drawPuzzle();
}
