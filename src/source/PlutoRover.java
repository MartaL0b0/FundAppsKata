package source;

public class PlutoRover {

	int x_coord;
	int y_coord;
	char orientation;
	boolean[][] map;
	
	public int getX_coord() {
		return x_coord;
	}
	public void setX_coord(int x_coord) {
		this.x_coord = x_coord;
	}
	public int getY_coord() {
		return y_coord;
	}
	public void setY_coord(int y_coord) {
		this.y_coord = y_coord;
	}
	public char getOrientation() {
		return orientation;
	}
	public void setOrientation(char orientation) {
		this.orientation = orientation;
	}
	public int getMapSize() {
		return map.length;
	}
	public void setMapSize(int size) {
		this.map = new boolean[size][size];
	}
	
	public PlutoRover(){
		setX_coord(0);
		setY_coord(0);
		setOrientation('N');
		setMapSize(100);
	}
	public PlutoRover(int x, int y, char orient, int size) {
		setX_coord(x);
		setY_coord(y);
		setOrientation(orient);
		setMapSize(size);
	}
	
}
