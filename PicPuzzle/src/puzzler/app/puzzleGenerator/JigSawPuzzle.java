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

public class JigSawPuzzle implements Puzzle {

	private static final String TAG = "JIGSAWPUZZLE";

	private ArrayList<PuzzleSlice> puzzle;

	private PuzzleSetting PuzzleSettings = new PuzzleSetting();

	private Bitmap image;

	private Canvas canvas;

	public JigSawPuzzle(Bitmap image) {
		this.image = image;

		generatePuzzle();
	}

	public JigSawPuzzle(Bitmap image, PuzzleSetting settings) {
		this.image = image;
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

				sliceImage = Bitmap.createBitmap(image, x_loc, y_loc,
						PuzzleSettings.getSliceWidth(),
						PuzzleSettings.getSliceHeight());

				puzzle.add(new PuzzleSlice(x_loc, y_loc, PuzzleSettings
						.getSliceWidth(), PuzzleSettings.getSliceHeight(), y,
						x, sliceImage, counter));

				counter++;
			}
		}

		Collections.shuffle(puzzle);
	}

	@SuppressWarnings("unused")
	private ArrayList<List<Integer>> randomizePositions() {
		ArrayList<List<Integer>> randoms = new ArrayList<List<Integer>>();

		List<Integer> positions = new ArrayList<Integer>();

		for (int r = 1; r < PuzzleSettings.getYpuzzles(); r++) {
			for (int c = 1; c < PuzzleSettings.getXpuzzles(); c++) {
				positions.add(c);
			}

			Collections.shuffle(positions);

			randoms.add(positions);
		}

		Collections.shuffle(randoms);

		return randoms;
	}

	/*
	 * public Bitmap drawPuzzle(){ Bitmap mBitmap =
	 * Bitmap.createBitmap(PuzzleSettings.getXpuzzles() *
	 * PuzzleSettings.getSliceWidth(), PuzzleSettings.getYpuzzles() *
	 * PuzzleSettings.getSliceHeight(), Bitmap.Config.ARGB_8888);
	 * 
	 * canvas = new Canvas(mBitmap);
	 * 
	 * //Collections.shuffle(puzzle);
	 * 
	 * int x = 0, y = 0;
	 * 
	 * for(PuzzleSlice slice :puzzle){ if(x >= PuzzleSettings.getXpuzzles()){ x
	 * = 0; y++; }
	 * 
	 * canvas.drawBitmap(slice.getSlice_image(), x *
	 * PuzzleSettings.getSliceWidth(), y * PuzzleSettings.getSliceHeight(),
	 * null);
	 * 
	 * x++; } return mBitmap; }
	 */
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
}
