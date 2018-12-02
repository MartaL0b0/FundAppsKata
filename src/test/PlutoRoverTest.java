package test;
import static org.junit.Assert.*;

import org.junit.Test;

import source.PlutoRover;


public class PlutoRoverTest {

	@Test
	public void testInitEmpty() {
		PlutoRover rover = new PlutoRover();
		assertEquals(0, rover.getX_coord());
		assertEquals(0, rover.getY_coord());
		assertEquals('N', rover.getOrientation());
		assertEquals(100, rover.getMapSize());
	}
	
	@Test
	public void testInitParameters() {
		PlutoRover rover = new PlutoRover(5, 5, 'S', 40);
		assertEquals(5, rover.getX_coord());
		assertEquals(5, rover.getY_coord());
		assertEquals('S', rover.getOrientation());
		assertEquals(40, rover.getMapSize());
	}
	
	
	@Test
	public void testInitParametersExceptionNegativeCoord() {
		try{
			PlutoRover rover = new PlutoRover(5, -5, 'S', 40);
		}catch (Exception e){
			assertEquals("Position cannnot be negative", e.getMessage());
		}
	}
	
	@Test
	public void testInitParametersExceptionInvalidOrientation() {
		try{
			PlutoRover rover = new PlutoRover(5, 5, 'M', 40);
		}catch (Exception e){
			assertEquals("Orientation not valid", e.getMessage());
		}
	}
	
	@Test
	public void testInitParametersExceptionInvalidSize() {
		try{
			PlutoRover rover = new PlutoRover(5, 5, 'S', -20);
		}catch (Exception e){
			assertEquals("Map size not valid", e.getMessage());
		}
	}
	
	@Test
	public void testInitParametersExceptionMapTooSmall() {
		try{
			PlutoRover rover = new PlutoRover(5, 5, 'S', 1);
		}catch (Exception e){
			assertEquals("Map size not valid", e.getMessage());
		}
	}
	
	
	@Test
	public void testCurrentPositionDefault() {
		PlutoRover rover = new PlutoRover();
		assertEquals("(0,0,N)", rover.getCurrentPosition());
	}
	
	@Test
	public void testCurrentPositionCustom() {
		PlutoRover rover = new PlutoRover(5, 5, 'S', 40);
		assertEquals("(5,5,S)", rover.getCurrentPosition());
	}
	
	
	@Test
	public void testMoveForwardNorth() {
		PlutoRover rover = new PlutoRover(6, 4, 'N', 40);
		try {
			rover.moveForward();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(6,5,N)", rover.getCurrentPosition());
	}
	
	@Test
	public void testMoveForwardNorthInvalid() {
		PlutoRover rover = new PlutoRover(6, 40, 'N', 40);
		try {
			rover.moveForward();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(6,40,N)", rover.getCurrentPosition());
	}
	
	@Test
	public void testMoveForwardSouth() {
		PlutoRover rover = new PlutoRover(5, 5, 'S', 40);
		try {
			rover.moveForward();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(5,4,S)", rover.getCurrentPosition());
	}
	
	@Test
	public void testMoveForwardSouthInvalid() {
		PlutoRover rover = new PlutoRover(5, 0, 'S', 40);
		try {
			rover.moveForward();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(5,0,S)", rover.getCurrentPosition());
	}
	
	@Test
	public void testMoveForwardEast() {
		PlutoRover rover = new PlutoRover(5, 5, 'E', 40);
		try {
			rover.moveForward();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(6,5,E)", rover.getCurrentPosition());
	}
	
	@Test
	public void testMoveForwardEastInvalid() {
		PlutoRover rover = new PlutoRover(40, 5, 'E', 40);
		try {
			rover.moveForward();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(40,5,E)", rover.getCurrentPosition());
	}
	
	@Test
	public void testMoveForwardWest() {
		PlutoRover rover = new PlutoRover(5, 5, 'W', 40);
		try {
			rover.moveForward();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(4,5,W)", rover.getCurrentPosition());
	}
	
	@Test
	public void testMoveForwardWestInvalid() {
		PlutoRover rover = new PlutoRover(0, 5, 'W', 40);
		try {
			rover.moveForward();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(0,5,W)", rover.getCurrentPosition());
	}
	
	
	@Test
	public void testMoveBackwardsNorth() {
		PlutoRover rover = new PlutoRover(6, 4, 'N', 40);
		try {
			rover.moveBackwards();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(6,3,N)", rover.getCurrentPosition());
	}
	
	@Test
	public void testMoveBackwardsNorthInvalid() {
		PlutoRover rover = new PlutoRover(6, 0, 'N', 40);
		try {
			rover.moveBackwards();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(6,0,N)", rover.getCurrentPosition());
	}
	
	@Test
	public void testMoveBackwardsSouth() {
		PlutoRover rover = new PlutoRover(5, 5, 'S', 40);
		try {
			rover.moveBackwards();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(5,6,S)", rover.getCurrentPosition());
	}
	
	@Test
	public void testMoveBackwardsSouthInvalid() {
		PlutoRover rover = new PlutoRover(5, 40, 'S', 40);
		try {
			rover.moveBackwards();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(5,40,S)", rover.getCurrentPosition());
	}
	
	@Test
	public void testMoveBackwardsEast() {
		PlutoRover rover = new PlutoRover(5, 5, 'E', 40);
		try {
			rover.moveBackwards();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(4,5,E)", rover.getCurrentPosition());
	}
	
	@Test
	public void testMoveBackwardsEastInvalid() {
		PlutoRover rover = new PlutoRover(0, 5, 'E', 40);
		try {
			rover.moveBackwards();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(0,5,E)", rover.getCurrentPosition());
	}
	
	@Test
	public void testMoveBackwardsWest() {
		PlutoRover rover = new PlutoRover(5, 5, 'W', 40);
		try {
			rover.moveBackwards();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(6,5,W)", rover.getCurrentPosition());
	}
	
	@Test
	public void testMoveBackwardsWestInvalid() {
		PlutoRover rover = new PlutoRover(40, 5, 'W', 40);
		try {
			rover.moveBackwards();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(40,5,W)", rover.getCurrentPosition());
	}
	
	
	@Test
	public void turnLeftNorth(){
		PlutoRover rover = new PlutoRover(5, 0, 'N', 40);
		try {
			rover.turnLeft();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(5,0,W)", rover.getCurrentPosition());
		
	}
	
	@Test
	public void turnLeftEast(){
		PlutoRover rover = new PlutoRover(5, 0, 'E', 40);
		try {
			rover.turnLeft();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(5,0,N)", rover.getCurrentPosition());
	}
	
	@Test
	public void turnLeftSouth(){
		PlutoRover rover = new PlutoRover(5, 0, 'S', 40);
		try {
			rover.turnLeft();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(5,0,E)", rover.getCurrentPosition());
	}
	
	@Test
	public void turnLeftWest(){
		PlutoRover rover = new PlutoRover(5, 0, 'W', 40);
		try {
			rover.turnLeft();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(5,0,S)", rover.getCurrentPosition());
	}
	
	
	@Test
	public void turnRightNorth(){
		PlutoRover rover = new PlutoRover(5, 0, 'N', 40);
		try {
			rover.turnRight();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(5,0,E)", rover.getCurrentPosition());
	}
	
	@Test
	public void turnRightEast(){
		PlutoRover rover = new PlutoRover(5, 0, 'E', 40);
		try {
			rover.turnRight();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(5,0,S)", rover.getCurrentPosition());
	}
	
	@Test
	public void turnRightSouth(){
		PlutoRover rover = new PlutoRover(5, 0, 'S', 40);
		try {
			rover.turnRight();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(5,0,W)", rover.getCurrentPosition());
	}
	
	@Test
	public void turnRightWest(){
		PlutoRover rover = new PlutoRover(5, 0, 'W', 40);
		try {
			rover.turnRight();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(5,0,N)", rover.getCurrentPosition());
	}
	
	
	
	/*
	@Test
	public void testMoveForwardEdgeNS() {
		
	}
	
	@Test
	public void testMoveForwardEdgeEW() {
		
	}
	*/
	
}
