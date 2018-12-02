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
		if (x_coord >= 0 && x_coord < getMapSize()){
			this.x_coord = x_coord;
		}else{
			throw new Exception ("Position cannnot be negative or out of map bounds");
		}
	}
	public int getY_coord() {
		return y_coord;
	}
	public void setY_coord(int y_coord) throws Exception {
		if (y_coord >= 0 && y_coord < getMapSize()){
			this.y_coord = y_coord;
		}else{
			throw new Exception ("Position cannnot be negative or out of map bounds");
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
			setMapSize(100);
			setX_coord(0);
			setY_coord(0);
			setOrientation('N');
			
		} catch (Exception e) {
			System.out.println("Unable to create PlutoRover. Invalid Parameters");
			e.printStackTrace();
		}
		
	}
	public PlutoRover(int x, int y, char orient, int size) {
		try{
			setMapSize(size);
			setX_coord(x);
			setY_coord(y);
			setOrientation(orient);
		} catch (Exception e){
			System.out.println("Unable to create PlutoRover. Invalid Parameters");
			e.printStackTrace();
		}
		
	}
	public String getCurrentPosition() {
		//can also be implemented as a PlutoRover.toString() - override
		int x = getX_coord();
		int y = getY_coord();
		char orient = getOrientation();
		
		return "(" + x + "," + y + "," + orient + ")";
	}
	
	public void moveForward() throws Exception{
		int mapSize = getMapSize();
		switch(getOrientation()){
			case ('N'):
					setY_coord(positiveMod((getY_coord() +1), mapSize));
				break;
			case ('S'):	
					setY_coord(positiveMod((getY_coord() -1), mapSize));
				break;
			case ('E'):
					setX_coord(positiveMod((getX_coord() +1), mapSize));
				break;
			case ('W'):
					setX_coord(positiveMod((getX_coord() -1), mapSize));
				break;
				
			default:
				break;
		}
		
	}
	public void moveBackwards() throws Exception {
		int mapSize = getMapSize();
		switch(getOrientation()){
			case ('N'):
				
				setY_coord(positiveMod((getY_coord() -1), mapSize));
				
				break;
			case ('S'):	
				
				setY_coord(positiveMod((getY_coord() +1), mapSize));
			
				break;
			case ('E'):
			
				setX_coord(positiveMod((getX_coord() -1), mapSize));
				break;
			case ('W'):
				
				setX_coord(positiveMod((getX_coord() +1), mapSize));
			
				break;
				
			default:
				break;
		}
		
	}
	
	public void turnLeft() throws Exception {
		switch(getOrientation()){
			case ('N'):
				setOrientation('W');
				break;
			case ('S'):	
				setOrientation('E');
				break;
			case ('E'):
				setOrientation('N');
				break;
			case ('W'):
				setOrientation('S');
				break;
				
			default:
				break;
		}
	}
	
	public void turnRight() throws Exception {
		switch(getOrientation()){
			case ('N'):
				setOrientation('E');
				break;
			case ('S'):	
				setOrientation('W');
				break;
			case ('E'):
				setOrientation('S');
				break;
			case ('W'):
				setOrientation('N');
				break;
				
			default:
				break;
		}
	}
	
	
	private int positiveMod(int value, int mod){
	    return ((value % mod + mod) % mod);
	}


}
