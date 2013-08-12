package puzzler.app.puzzleGenerator;

import java.util.ArrayList;

import android.graphics.Bitmap;

abstract class  Puzzle {
	private int PUZZLE_TYPE_JIG_SAW    = 1;
	
	private int PUZZLE_TYPE_RUBIC_CUBE = 1;
	
	public abstract void createPuzzle(Bitmap img, PuzzleSetting settings);
	
	public abstract ArrayList<PuzzleSlice> getPuzzleList();

	public abstract int getSlicesCount();
	
	public abstract Bitmap getOriginalImage();
	
	public void savePuzzle(Bitmap bitmap, int puzzle_type){
		if(puzzle_type == PUZZLE_TYPE_JIG_SAW){
			
		}else if (puzzle_type == PUZZLE_TYPE_RUBIC_CUBE){
			
		}
	}
	
	public void errorCheck(){
		System.out.print("");
	}
}
