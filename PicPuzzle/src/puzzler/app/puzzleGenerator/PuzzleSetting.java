package puzzler.app.puzzleGenerator;

import java.util.HashMap;

import android.app.Activity;
import android.view.Display;

public class PuzzleSetting {

	private  int slice_width;
	
	private  int slice_height;
	
	private  int xpuzzles;
	
	private  int ypuzzles;

	private  int main_image_height;
	
	private  int main_image_width;
	
	private  int view_height;
	
	private  int view_width;

	private boolean allowJump;
	
	private Activity activity;

	private int image_top_view_margins;
	

	private int image_right_view_margins;
	

	private int image_bottom_view_margins;
	

	private int image_left_view_margins;
	
	private int slice_border;
	
	private HashMap<String,Object> mysettings;
		
	private int active_game_type; 
	
	public PuzzleSetting(Activity activity){
		this.activity = activity;
		
		init();		
	}
	
	public PuzzleSetting(HashMap<String,Object> settings){
		mysettings = settings;
		
		init();
	}

	private void init(){
		_default();	
		
		optimizeSettings();
	}
	
	private void _default(){
		active_game_type = 1;
		
		slice_width    = 28;
		slice_height   = 28;
		
		xpuzzles = 4;
		ypuzzles = 5;
		
		main_image_height = 0;
		main_image_width  = 0;

		image_top_view_margins 		= 40;
		image_right_view_margins	= 8;
		image_bottom_view_margins 	= 40;
		image_left_view_margins 	= 8;
		
		slice_border = 0;
		
		allowJump = false;
	}
	
	public boolean isAllowJump() {
		return allowJump;
	}

	public void setAllowJump(boolean allowJump) {
		this.allowJump = allowJump;
	}

	public void setHeight(int height){
		this.slice_height = height;
	}
	
	public void setWidth(int width){
		this.slice_width = width;
	}

	public void setXPuzzles(int xpuzzles){
		this.xpuzzles = xpuzzles;
	}
	
	public void setYPuzzles(int ypuzzles){
		this.ypuzzles = ypuzzles;
	}

	public void setImage_panel_width(int image_panel_width) {
		this.main_image_width = image_panel_width;
	}
	
	public void setImage_panel_height(int image_panel_height) {
		this.main_image_height = image_panel_height;
	}
	
	public int getImage_top_view_margins() {
		return image_top_view_margins;
	}

	public int getActive_game_type() {
		return active_game_type;
	}

	public void setActive_game_type(int active_game_type) {
		this.active_game_type = active_game_type;
	}

	public void setImage_top_view_margins(int image_top_view_margins) {
		this.image_top_view_margins = image_top_view_margins;
	}

	public int getImage_right_view_margins() {
		return image_right_view_margins;
	}

	public void setImage_right_view_margins(int image_right_view_margins) {
		this.image_right_view_margins = image_right_view_margins;
	}

	public int getImage_bottom_view_margins() {
		return image_bottom_view_margins;
	}

	public void setImage_bottom_view_margins(int image_bottom_view_margins) {
		this.image_bottom_view_margins = image_bottom_view_margins;
	}

	public int getImage_left_view_margins() {
		return image_left_view_margins;
	}

	public void setImage_left_view_margins(int image_left_view_margins) {
		this.image_left_view_margins = image_left_view_margins;
	}

	public void setSlice_border(int slice_border) {
		this.slice_border = slice_border;
	}

	public void setView_height(int view_height) {
		this.view_height = view_height;
	}

	public void setView_width(int view_width) {
		this.view_width = view_width;
	}
	
	public int getView_width() {
		return view_width;
	}
	
	public int getView_height() {
		return view_height;
	}
	
	public int getSlice_border() {
		return slice_border;
	}

	public int getImageWidth() {
		return main_image_width;
	}
	
	public int getImageHeight() {
		return main_image_height;
	}
	public  int getSliceWidth() {
		return slice_width;
	}

	public  int getSliceHeight() {
		return slice_height;
	}

	public  int getXpuzzles() {
		return xpuzzles;
	}

	public  int getYpuzzles() {
		return ypuzzles;
	}	
	
	public void optimizeSettings(){
		Display disp = activity.getWindowManager().getDefaultDisplay();

		int error_margin = 2;
		
		main_image_height = (disp.getHeight() - (image_bottom_view_margins + image_top_view_margins)) - (ypuzzles * slice_border) ;
		
		main_image_width  = (disp.getWidth() - (image_left_view_margins + image_right_view_margins)) - (xpuzzles * slice_border) ;	
		
		view_width  = main_image_width + error_margin;
		
		view_height = main_image_height + error_margin;
		
		slice_width    = main_image_width  / xpuzzles;
		
		slice_height   = main_image_height / ypuzzles;
	}
	
}
