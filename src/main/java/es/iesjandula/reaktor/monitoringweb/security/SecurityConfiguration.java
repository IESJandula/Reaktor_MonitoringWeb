package es.iesjandula.reaktor.monitoringweb.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author David Martinez
 * Thus class is for enable crypt passwords
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
