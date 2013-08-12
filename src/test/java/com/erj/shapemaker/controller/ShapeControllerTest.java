package com.erj.shapemaker.controller;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.erj.shapemaker.shapes.Triangle;

public class ShapeControllerTest {

	@Test
	public void viewNameIsShape() {
		ShapeController controller = new ShapeController();
		
		ModelAndView mav = controller.respond();
		
		assertEquals("shape", mav.getViewName());
	}
	
	@Test
	public void triangleWithSideLengthOneIsDefaultShape(){
		Triangle triangle = new Triangle();
		
		ShapeController controller = new ShapeController();
		
		ModelAndView mav = controller.respond();
		
		assertEquals(triangle, mav.getModelMap().get("shape"));
	}
	
	@Test
	public void controllerBuildsAnImageWithNumberOfSidesAndSideLength(){
		ShapeController controller = new ShapeController();
		
		controller.respond();
		
		File image = new File("src/main/webapp/3_1.jpg");
		
		assertTrue(image.exists());
	}
	
	@Test
	public void imageNameIsAvailableOnTheModel(){
		ShapeController controller = new ShapeController();
		
		ModelAndView mav = controller.respond();
		
		assertEquals("3_1.jpg", mav.getModelMap().get("image"));
	}
	
	@Test
	public void numberOfSidesIsOnTheModel(){
		ShapeController controller = new ShapeController();
		
		ModelAndView mav = controller.respond();
		
		assertEquals(3, mav.getModelMap().get("numberOfSides"));
	}
	
//	@Test
//	public void fakeBuildTheFiles(){
//		ShapeController controller = new ShapeController();
//		for(int i = 1; i<=200; i++){
//			controller.respond(i);
//		}
//	}
}
