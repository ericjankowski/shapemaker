package com.erj.shapemaker.shapes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TriangleTest {

	@Test
	public void equalsReturnsTrueWhenTrianglesHaveTheSameSideLength() {
		Triangle a = new Triangle();
		Triangle b = new Triangle();
		
		assertEquals(a,b);
	}
	
	@Test
	public void equalsReturnsFalseWhenTrianglesHaveDifferentSideLengths() {
		Triangle a = new Triangle(1);
		Triangle b = new Triangle(2);
		
		assertFalse(a.equals(b));
		
	}

}
