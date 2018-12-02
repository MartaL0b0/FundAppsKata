package source;

import java.util.HashSet;

public class PlutoRover {

	int x_coord;
	int y_coord;
	char orientation;
	int mapSize;
	HashSet<String> obstacles;
	
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
		return mapSize;
	}
	public void setMapSize(int size) throws Exception {
		if (size > 1){
			this.mapSize = size;
		} else {
			throw new Exception("Map size not valid");
		}
		
	}
	public void setObstacles(HashSet<String> obs) {
		//could check if obstacles are legal or not, but as a set it is not that important.
		this.obstacles = obs;
	}
	
	public void setObstacles() {
		//could check if obstacles are legal or not, but as a set it is not that important.
		this.obstacles = new HashSet<String>();
	}
	public HashSet<String> getObstacles(){
		return obstacles;
	}
	
	public PlutoRover(){
		
		try {
			setMapSize(100);
			setX_coord(0);
			setY_coord(0);
			setOrientation('N');
			setObstacles();
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
			setObstacles();
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
	
	public boolean checkObstacle(int x, int y){		
		return getObstacles().contains(x + "," + y);
	}
	
	
	public void moveForward() throws Exception{
		int mapSize = getMapSize();
		int newCoord = 0;
		switch(getOrientation()){
			case ('N'):
				newCoord = positiveMod((getY_coord() +1), mapSize);
				if (!checkObstacle(getX_coord(), newCoord)){
					setY_coord(newCoord);
				}
				break;
			case ('S'):	
				newCoord = positiveMod((getY_coord() -1), mapSize);
				if (!checkObstacle(getX_coord(), newCoord)){
					System.out.println(newCoord);
					setY_coord(newCoord);
				}
				break;
			case ('E'):
				newCoord = positiveMod((getX_coord() +1), mapSize);
				if (!checkObstacle(newCoord, getY_coord())){
					setX_coord(newCoord);
				}
				break;
			case ('W'):
				newCoord = positiveMod((getX_coord() -1), mapSize);
				if (!checkObstacle(newCoord, getY_coord())){
					setX_coord(newCoord);
				}
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
