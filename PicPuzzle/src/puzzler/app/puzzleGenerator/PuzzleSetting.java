package puzzler.app.puzzleGenerator;

import java.util.HashMap;

public class PuzzleSetting {

	private  int width;
	
	private  int height;
	
	private  int xpuzzles;
	
	private  int ypuzzles;
	
	public PuzzleSetting(){
		_default();
	}
	
	public PuzzleSetting(HashMap<String,Object> settings){
		_default();
		
		SetSetting(settings);
	}

	private void _default(){
		width    = 40;
		height   = 40;
		xpuzzles = 40;
		ypuzzles = 40;
	}
	
	public void SetSetting(HashMap<String,Object> settings){
		if(settings.containsKey("width")){
			width = Integer.parseInt(settings.get("width").toString()); 
		}
		
		else if(settings.containsKey("height")){
			height = Integer.parseInt(settings.get("height").toString()); 
		}
		
		else if(settings.containsKey("xpuzzles")){
			xpuzzles = Integer.parseInt(settings.get("xpuzzles").toString()); 
		}
		
		else if(settings.containsKey("ypuzzles")){
			ypuzzles = Integer.parseInt(settings.get("ypuzzles").toString()); 
		}
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
