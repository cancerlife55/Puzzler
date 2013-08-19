package puzzler.app.puzzleGenerator;

import java.util.HashMap;

public class PuzzleSetting {

	private  int width;
	
	private  int height;
	
	private  int xpuzzles;
	
	private  int ypuzzles;
	
	private  int image_panel_height;
	
	private  int image_panel_width;

	private boolean allowJump;
	
	public PuzzleSetting(){
		_default();
	}
	
	public PuzzleSetting(HashMap<String,Object> settings){
		_default();		
	}

	private void _default(){
		width    = 40;
		height   = 40;
		xpuzzles = 40;
		ypuzzles = 40;
		image_panel_height = 0;
		image_panel_width  = 0;
		allowJump = false;
	}

	/*
	 * Setters
	 */
	
	public boolean isAllowJump() {
		return allowJump;
	}

	public void setAllowJump(boolean allowJump) {
		this.allowJump = allowJump;
	}

	public void setHeight(int height){
		this.height = height;
	}
	
	public void setWidth(int width){
		this.width = width;
	}

	public void setXPuzzles(int xpuzzles){
		this.xpuzzles = xpuzzles;
	}
	
	public void setYPuzzles(int ypuzzles){
		this.ypuzzles = ypuzzles;
	}

	public void setImage_panel_width(int image_panel_width) {
		this.image_panel_width = image_panel_width;
	}
	
	public void setImage_panel_height(int image_panel_height) {
		this.image_panel_height = image_panel_height;
	}

	/*
	 * Getters
	 */
	public int getImage_panel_width() {
		return image_panel_width;
	}
	
	public int getImage_panel_height() {
		return image_panel_height;
	}
	public  int getSliceWidth() {
		return width;
	}

	public  int getSliceHeight() {
		return height;
	}

	public  int getXpuzzles() {
		return xpuzzles;
	}

	public  int getYpuzzles() {
		return ypuzzles;
	}
	
	
}
