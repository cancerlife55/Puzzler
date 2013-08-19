package puzzler.app.solver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.graphics.Point;

import puzzler.app.puzzleGenerator.PuzzleSetting;
import puzzler.app.puzzleGenerator.PuzzleSlice;

public class Game {
	private List<PuzzleSlice> puzzleSlices;
	
	private PuzzleSetting settings;
	
	private PuzzleSlice sliceMoveTo;
	
	private PuzzleSlice sliceToMove;
	
	private int slice_width;
	
	private int slice_height;
	
	private int panel_height;
	
	private int panel_width;
	
	private boolean allowed_jump;
	
	public Game(ArrayList<PuzzleSlice> slices, PuzzleSetting settings){
		this.puzzleSlices = slices;
		this.settings = settings;
		
		initSettings();
	}
	
	public void initSettings(){
		slice_width  = settings.getSliceWidth();
		slice_height = settings.getSliceHeight();
		panel_height = settings.getImage_panel_height();
		panel_width  = settings.getImage_panel_width();
		allowed_jump = settings.isAllowJump();
		
	}
	/*
	 * Returns the slice on the selected coordinates
	 */	
	public PuzzleSlice getSliceOnCoordinates(Point point){
		return getSliceOnLocation(point.x, point.y);
	}
	
	/*
	 * Returns the slice on the selected location
	 */
	public PuzzleSlice getSliceOnLocation(int x, int y){
		PuzzleSlice slice_rtn = null;
		
		for (PuzzleSlice slice : puzzleSlices ){
			if (inCoordinates(slice, x, y)){
				slice_rtn = slice;
				break;
			}
		}
		
		return slice_rtn;
	}
	
	/*
	 * Checks whether the slice is in passed coordinates
	 */
	private boolean inCoordinates(PuzzleSlice slice, int x, int y){
		return ((slice.getX_loc() <= x && (slice.getX_loc() + slice.getWIDTH()) >= x) && (slice.getY_loc() <= y && (slice.getY_loc() + slice.getHEIGHT()) >= y));
	}
	
	/*
	 * Get the x and y location of the new move
	 */
	public Point getMoveXYCoordinates(int x, int y){
		Point p = new Point();
		
		PuzzleSlice slice = getSliceOnLocation(x,y);
		
		p.set(slice.getX_loc(), slice.getY_loc());
		
		return p;
	}

	/*
	 * Check whether the requested move is allowed
	 */
	public boolean isAllowedMove(PuzzleSlice slice, int x, int y){
		Point move = getMoveXYCoordinates(x,y);
		
		int moveXCoord = move.x;
		int moveYCoord = move.y;
		
		boolean isAllowed = false;

		sliceMoveTo = getSliceOnLocation(x,y);
		sliceToMove = slice;
		
		if (isWithinAllowedZone(x,y)){
			if (allowed_jump){			
				if (sliceMoveTo != null)
					isAllowed = true;			
			}else{
				/*
				 * Confirm the logic
				 */
				if (sliceMoveTo != null){
					//check left (affects x)
					if( ( x < sliceToMove.getX_loc() && x > sliceToMove.getX_loc() - this.slice_width ) && (y > sliceToMove.getY_loc() && y < sliceToMove.getY_loc() + this.slice_height))
						isAllowed = true;
					
					//check top (affects y)
					else if ( ( x > sliceToMove.getX_loc() && x < sliceToMove.getX_loc() + this.slice_width ) && (y < sliceToMove.getY_loc() && y > sliceToMove.getY_loc() - this.slice_height))
						isAllowed = true;
					
					//check right (affects x)
					else if ( ( x < sliceToMove.getX_loc() && x > sliceToMove.getX_loc() - this.slice_width ) && (y > sliceToMove.getY_loc() && y < sliceToMove.getY_loc() + this.slice_height))
						isAllowed = true;
					
					//check bottom (affects y)
					else if ( ( x < sliceToMove.getX_loc() && x > sliceToMove.getX_loc() - this.slice_width ) && (y > sliceToMove.getY_loc() && y > sliceToMove.getY_loc() - this.slice_height))
						isAllowed = true;
				}
			}
		}
		return isAllowed;		
	}
	
	/*
	 * Check if the move is within the restricted frame location
	 */
	public boolean isWithinAllowedZone(int x, int y){
		return (( x > 0 && x < panel_width) && (y > 0 && y < panel_height));
	}
	
	/*
	 * Return an arraylist of ordered PuzzleSlices 
	 */
	public ArrayList<PuzzleSlice> getSolution(){
		ArrayList<PuzzleSlice> solution = new ArrayList<PuzzleSlice>();
		solution.addAll(puzzleSlices);
		
		// Sort anagram groups according to size
		Collections.sort(puzzleSlices, new Comparator<PuzzleSlice>() {

			@Override
			public int compare(PuzzleSlice slice1, PuzzleSlice slice2) {
				// TODO Auto-generated method stub
				return slice1.getSlice_num() - slice2.getSlice_num();
			}});
		
		return solution;
	}
}
