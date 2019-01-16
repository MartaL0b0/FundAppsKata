package test;
import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import source.Coordinates;
import source.PlutoRover;


public class PlutoRoverTest {

	/*Initialization tests*/
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
	
	
	/*helper method tests. check current position of the rover*/
	
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
	
	
	
	/*move forward tests req1*/
	
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
	
	/*move forward tests req3*/
	
	
	@Test
	public void testMoveForwardNorthEdge() {
		PlutoRover rover = new PlutoRover(6, 39, 'N', 40);
		try {
			rover.moveForward();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(6,0,N)", rover.getCurrentPosition());
	}
	
		
	@Test
	public void testMoveForwardSouthEdge() {
		PlutoRover rover = new PlutoRover(5, 0, 'S', 40);
		try {
			rover.moveForward();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(5,39,S)", rover.getCurrentPosition());
	}
	
		
	@Test
	public void testMoveForwardEastEdge() {
		PlutoRover rover = new PlutoRover(39, 5, 'E', 40);
		try {
			rover.moveForward();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(0,5,E)", rover.getCurrentPosition());
	}
	
	
	@Test
	public void testMoveForwardWestEdge() {
		PlutoRover rover = new PlutoRover(0, 5, 'W', 40);
		try {
			rover.moveForward();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(39,5,W)", rover.getCurrentPosition());
	}
	
	
	/*move backwards tests req1*/
	
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
	
	
	/*move backwards tests req3*/
	
	@Test
	public void testMoveBackwardsNorthEdge() {
		PlutoRover rover = new PlutoRover(6, 0, 'N', 40);
		try {
			rover.moveBackwards();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(6,39,N)", rover.getCurrentPosition());
	}
	
	
	@Test
	public void testMoveBackwardsSouthEdge() {
		PlutoRover rover = new PlutoRover(5, 39, 'S', 40);
		try {
			rover.moveBackwards();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(5,0,S)", rover.getCurrentPosition());
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
		assertEquals("(39,5,E)", rover.getCurrentPosition());
	}
	
	
	@Test
	public void testMoveBackwardsWestInvalid() {
		PlutoRover rover = new PlutoRover(39, 5, 'W', 40);
		try {
			rover.moveBackwards();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(0,5,W)", rover.getCurrentPosition());
	}
	
	
	/*turn left tests req2*/
	
	@Test
	public void testTurnLeftNorth(){
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
	public void testTurnLeftEast(){
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
	public void testTurnLeftSouth(){
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
	public void testTurnLeftWest(){
		PlutoRover rover = new PlutoRover(5, 0, 'W', 40);
		try {
			rover.turnLeft();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(5,0,S)", rover.getCurrentPosition());
	}
	
	
	
	/*turn right tests req2*/
	
	@Test
	public void testTurnRightNorth(){
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
	public void testTurnRightEast(){
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
	public void testTurnRightSouth(){
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
	public void testTurnRightWest(){
		PlutoRover rover = new PlutoRover(5, 0, 'W', 40);
		try {
			rover.turnRight();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("(5,0,N)", rover.getCurrentPosition());
	}
	
	
	/*obstacle detention req4*/
	@Test
	public void testCheckObstacleTrue(){
		PlutoRover rover = new PlutoRover();
		HashSet<String> obstacles = new HashSet<>();
		obstacles.add(1+","+1);
		rover.setObstacles(obstacles);
		assertEquals(true, rover.checkObstacle(1,1));
	}
	
	@Test
	public void testCheckObstacleFalse(){
		PlutoRover rover = new PlutoRover();
		HashSet<String> obstacles = new HashSet<>();
		obstacles.add(1+","+1);
		rover.setObstacles(obstacles);
		assertEquals(false, rover.checkObstacle(2,1));
	}
	
	@Test
	public void testMoveForwardNorthObstacle(){
		PlutoRover rover = new PlutoRover(1,1,'N', 5);
		HashSet<String> obstacles = new HashSet<>();
		obstacles.add(1+","+2);
		obstacles.add(2+","+1);
		rover.setObstacles(obstacles);
		try{
			rover.moveForward();
		} catch (Exception e){
			e.printStackTrace();
		}
		assertEquals("(1,1,N)", rover.getCurrentPosition());
	}
	
	@Test
	public void testMoveForwardEastObstacle(){
		PlutoRover rover = new PlutoRover(1,1,'E', 5);
		HashSet<String> obstacles = new HashSet<>();
		obstacles.add(1+","+2);
		obstacles.add(2+","+1);
		rover.setObstacles(obstacles);
		try{
			rover.moveForward();
		} catch (Exception e){
			e.printStackTrace();
		}
		assertEquals("(1,1,E)", rover.getCurrentPosition());
	}
}
