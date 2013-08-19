package puzzler.app.puzzleGenerator;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import android.graphics.Bitmap;
import android.graphics.Point;

public class PuzzleSlice {

	private int WIDTH;
	
	private int HEIGHT;
	
	private int x_loc;
	
	private int y_loc;
	
	private Bitmap slice_image;
	
	private ArrayList<Point> moves = new ArrayList<Point>();
	
	private AtomicInteger threadSafeNum = new AtomicInteger();
			
	private int slice_num = 1;
	
	public PuzzleSlice(int x_loc, int y_loc, int width, int height, Bitmap image ){
		this.WIDTH  = width;
		this.HEIGHT = height;
		this.x_loc  = x_loc;
		this.y_loc  = y_loc;
		
		this.slice_num = threadSafeNum.incrementAndGet();
		
		this.setSlice_image(image);
	}

	public void move(int x, int y){
		x_loc = x;
		y_loc = y;
				
		addMove(x,y);
	}
		
	public void addMove(int x, int y){
		moves.add(new Point(x,y));
	}
	
	public int getWIDTH() {
		return WIDTH;
	}

	public void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}

	public int getX_loc() {
		return x_loc;
	}

	public void setX_loc(int x_loc) {
		this.x_loc = x_loc;
	}

	public int getY_loc() {
		return y_loc;
	}

	public void setY_loc(int y_loc) {
		this.y_loc = y_loc;
	}

	public Bitmap getSlice_image() {
		return slice_image;
	}

	public void setSlice_image(Bitmap slice_image) {
		this.slice_image = slice_image;
	}

	public int getSlice_num() {
		return slice_num;
	}
}
