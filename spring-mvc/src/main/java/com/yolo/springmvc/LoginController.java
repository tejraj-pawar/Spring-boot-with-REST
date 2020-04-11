package com.yolo.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //this will handle web request
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET) //this will work only for GET requests
	//@ResponseBody // it send back string/anything(return type) as a response(on screen)
	//if we dont use @ResponseBody then it checks for view resolver.
	public String sayLoginPage()
	{
		//return "Hello World yolo";
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST) //this will work only for POST requests
	public String handleLoginRequest(@RequestParam String name, @RequestParam String password, ModelMap model)
	{
        //model is use to transfer data from controller to view.
     	
		// if credential are valid then redirect to welcome page, else redirect to login page.
		if(loginService.isUserValid(name, password))
     	{
			model.put("name", name); //setting value in model, so that view(jsp) can use it.
    		model.put("password", password);
    		return "welcome";
     	}
     	else
     	{
     		model.put("errorMessage", "Invalid Credentials");
     		return "login";
     	}
	}

}
