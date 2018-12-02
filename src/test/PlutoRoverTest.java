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
		rover.moveForward();
		assertEquals("(6,5,N)", rover.getCurrentPosition());
	}
	
	@Test
	public void testMoveForwardSouth() {
		PlutoRover rover = new PlutoRover(5, 5, 'S', 40);
		rover.moveForward();
		assertEquals("(5,4,S)", rover.getCurrentPosition());
	}
	
	@Test
	public void testMoveForwardEast() {
		PlutoRover rover = new PlutoRover(5, 5, 'E', 40);
		rover.moveForward();
		assertEquals("(6,5,N)", rover.getCurrentPosition());
	}
	
	@Test
	public void testMoveForwardWest() {
		PlutoRover rover = new PlutoRover(5, 5, 'W', 40);
		rover.moveForward();
		assertEquals("(4,5,N)", rover.getCurrentPosition());
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
