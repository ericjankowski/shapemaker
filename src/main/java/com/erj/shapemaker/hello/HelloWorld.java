package com.erj.shapemaker.hello;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorld {
	
	@RequestMapping("/greet")
	public ModelAndView greet() {
		BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();
		graphics.drawString("Hello World!!!", 10, 20);
		String path = "hello.jpg";
		try {
			ImageIO.write(image, "jpg", new File("src/main/webapp/" + path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("greet");
		mav.addObject("greetingImg", path);
		
		return mav;
	}
}
