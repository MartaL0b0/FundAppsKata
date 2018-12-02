package source;

public class PlutoRover {

	int x_coord;
	int y_coord;
	char orientation;
	boolean[][] map;
	
	public int getX_coord() {
		return x_coord;
	}
	public void setX_coord(int x_coord) throws Exception {
		if (x_coord >= 0){
			this.x_coord = x_coord;
		}else{
			throw new Exception ("Position cannnot be negative");
		}
	}
	public int getY_coord() {
		return y_coord;
	}
	public void setY_coord(int y_coord) throws Exception {
		if (y_coord >= 0){
			this.y_coord = y_coord;
		}else{
			throw new Exception ("Position cannnot be negative");
		}
	}
	public char getOrientation() {
		return orientation;
	}
	public void setOrientation(char orientation) throws Exception{
		if (orientation == 'N' || orientation == 'E' ||orientation == 'S' ||orientation == 'W'){
			this.orientation = orientation;
		} else {
			throw new Exception("Orientation not valid");
		}
	}
	public int getMapSize() {
		return map.length;
	}
	public void setMapSize(int size) throws Exception {
		if (size > 1){
			this.map = new boolean[size][size];
		} else {
			throw new Exception("Map size not valid");
		}
		
	}
	
	public PlutoRover(){
		
		try {
			setX_coord(0);
			setY_coord(0);
			setOrientation('N');
			setMapSize(100);
		} catch (Exception e) {
			System.out.println("Unable to create PlutoRover. Invalid Parameters");
			e.printStackTrace();
		}
		
	}
	public PlutoRover(int x, int y, char orient, int size) {
		try{
			setX_coord(x);
			setY_coord(y);
			setOrientation(orient);
			setMapSize(size);
		}catch (Exception e){
			System.out.println("Unable to create PlutoRover. Invalid Parameters");
			e.printStackTrace();
		}
		
	}
	
}
