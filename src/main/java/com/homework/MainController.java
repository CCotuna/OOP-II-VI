package com.homework;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping(value = "/laptops", method = RequestMethod.GET)
	public ModelAndView brandPage(@RequestParam String brand) {

		ModelAndView mav = new ModelAndView();
		
		int charCount = brand.length();
		
		if(charCount % 2 == 0) { 
			String isEven = "Even";
			mav.addObject("parity", isEven);
		} else {
			String isOdd = "Odd";
			mav.addObject("parity", isOdd);
		}
		
		mav.addObject("brand", brand);
		mav.addObject("count", charCount);
		
		mav.setViewName("StExercise");
		
		return mav;
	}
	
	@RequestMapping(value = "/convert" , method = RequestMethod.GET)
	public ModelAndView converterPage(@RequestParam String ron, String EURO) {
		
		ModelAndView mav = new ModelAndView();
		
		int convertedSum = Integer.parseInt(ron) / Integer.parseInt(EURO);
		
		mav.addObject("convertedSum", convertedSum);
		mav.setViewName("NdExercise");
		
		return mav;
	}
	
	@RequestMapping(value = "/laptopsInput", method = RequestMethod.POST)
	public ModelAndView brandInputPage(@RequestParam("brand") String brandName) {
		ModelAndView mav = new ModelAndView();
		
		int charCount = brandName.length();
		String oddEven = (charCount % 2 == 0) ? "Even" : "Odd";
		
		mav.addObject("brand", brandName);
		mav.addObject("count", charCount);
		mav.addObject("parity", oddEven);
		
		mav.setViewName("RdExerciseInput");
		
		return mav;
	}
	
	@RequestMapping(value = "/laptopsInput", method = RequestMethod.GET)
	public ModelAndView showBrandInputPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("RdExerciseInput");
		
		return mav;
	}
	
	@RequestMapping(value = "/convertInput", method = RequestMethod.POST)
	public ModelAndView convertInputPage(@RequestParam("RON") String ron, @RequestParam("EURO") String euro) {
		ModelAndView mav = new ModelAndView();
		
		int sumRon = Integer.parseInt(ron);
		int sumConverted = sumRon / Integer.parseInt(euro);
		
		mav.addObject("sumConverted", sumConverted);
		mav.addObject("sumRon", sumRon);
		mav.setViewName("ThExerciseDisplay");
		
		return mav;
	}
	
	@RequestMapping(value = "/convertInput", method = RequestMethod.GET)
	public ModelAndView showConvertInputPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ThExerciseInput");
		
		return mav;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHomePage() {
		return "index";
	}
}
