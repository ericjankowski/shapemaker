package com.erj.shapemaker.controller;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.erj.shapemaker.shapes.Triangle;

@Controller
public class ShapeController {

	@RequestMapping("/shape")
	public ModelAndView respond() {
		Triangle shape = new Triangle();
		String imageFileName = buildImage(shape);
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("shape");
		mav.addObject("shape", shape);
		mav.addObject("image", imageFileName);
		mav.addObject("numberOfSides", shape.getNumberOfSides());
		
		return mav;
	}
	
	private String buildImage(Triangle shape){
		BufferedImage image = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
		double center = (image.getWidth()*0.5);
		double radius = (center *0.75);
		double angle = 2 * Math.PI / shape.getNumberOfSides();
		Graphics graphics = image.getGraphics();
		int x1 = (int)(center);
		int y1 = (int)(center - radius);
		
		for (int i = 1; i<= shape.getNumberOfSides(); i++){
			int x2 = (int)(center + ((Math.sin(angle * i)))*radius);
			int y2 = (int)(center - ((Math.cos(angle * i)))*radius);
			graphics.drawLine(x1, y1, x2, y2);
			x1 = x2;
			y1 = y2;
		}
		String path = shape.getNumberOfSides() + "_" + 1 + ".jpg";
		try {
			ImageIO.write(image, "jpg", new File("src/main/webapp/" + path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}
