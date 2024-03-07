package es.iesjandula.reaktor.monitoringweb.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author David Martinez
 * This is the Controller for spring secutiry , each method redirect to the specific resource
 */
@Controller
public class SecurityController
{

	/**
	 * Method showLogin redirect /login request to templates/login
	 * @return ModelAndView
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public ModelAndView showLogin()
	{
		// --- ModelAndView OBJECT IS USED FOR MVC , THAT CONTAINS ALL THE INFO FOR RETURNS VIEWS WITH DATA ---
		// --- THIS ModelAndView , SEARCH THE login RESOURCE , AND RETURNS IT (SEARCH THE RESOURCE IN TEMPLATES)---
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

}
