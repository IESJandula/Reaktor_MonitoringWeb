package es.iesjandula.reaktor.monitoringweb.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author David Martinez
 * En esta clase indicamos que cuando se realice una solicitud a mano o redireccionada hasta la dirección “/login/” como un GET ,
 * retorna el recurso de la web de login mediante un objeto ModelAndView.
 * Este objeto se basa en MVC , mientras tengamos el recurso debajo de templates/… 
 * solamente con pasarle el ViewName , buscará el recurso con ese nombre asociado y lo devolverá con los datos necesarios para la vista.
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
