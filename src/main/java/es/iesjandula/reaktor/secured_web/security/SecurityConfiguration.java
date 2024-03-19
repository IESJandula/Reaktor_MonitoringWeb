package es.iesjandula.reaktor.secured_web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author David Martinez
 * Una clase muy importante es la que habilita que las password estén encriptadas y 
 * no en plano, para ello crearemos la siguiente clase 
 * Está simplemente está como configuración para habilitar la encriptación de password.
 */
@Configuration
public class SecurityConfiguration
{

	/**
	 * Method passwordEncoder
	 * 
	 * @return
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

}
