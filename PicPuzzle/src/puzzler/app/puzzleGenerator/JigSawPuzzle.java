package puzzler.app.puzzleGenerator;

import java.util.ArrayList;
import java.util.Collections;

import puzzler.app.imageEdit.ImageEditorHelpers;

import android.graphics.Bitmap;

public class JigSawPuzzle implements Puzzle {

	private static final String TAG = "JIGSAWPUZZLE";

	private ArrayList<PuzzleSlice> puzzle, puzzle_solution;

	private PuzzleSetting PuzzleSettings;

	private Bitmap image;

	
	public JigSawPuzzle(Bitmap image, PuzzleSetting settings) {
		this.image = ImageEditorHelpers.scaleImage(image, settings.getImageWidth(),settings.getImageHeight());
		this.PuzzleSettings = settings;

		generatePuzzle();
	}

	@Override
	public void generatePuzzle() {
		puzzle = new ArrayList<PuzzleSlice>();

		int x_loc, y_loc;

		Bitmap sliceImage = null;

		int counter = 1;

		for (int y = 0; y < PuzzleSettings.getYpuzzles(); y++) {
			y_loc = y * PuzzleSettings.getSliceHeight();

			for (int x = 0; x < PuzzleSettings.getXpuzzles(); x++) {
				x_loc = x * PuzzleSettings.getSliceWidth();

				sliceImage = Bitmap.createBitmap(image, x_loc, y_loc,PuzzleSettings.getSliceWidth(), PuzzleSettings.getSliceHeight());

				puzzle.add(new PuzzleSlice(x_loc, y_loc, PuzzleSettings.getSliceWidth(), PuzzleSettings.getSliceHeight(), y, x, sliceImage, counter));

				counter++;
			}
		}

		puzzle_solution = puzzle;
		
		Collections.shuffle(puzzle);
	}

	@Override
	public ArrayList<PuzzleSlice> getPuzzleList() {
		return puzzle;
	}

	@Override
	public int getSlicesCount() {
		return puzzle.size();
	}

	public Bitmap getOriginalImage() {
		return image;
	}
	
	public ArrayList<PuzzleSlice> getPuzzleSolution(){
		return puzzle_solution;
	}
}
