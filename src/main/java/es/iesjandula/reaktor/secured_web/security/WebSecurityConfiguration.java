package es.iesjandula.reaktor.secured_web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author David Martinez
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration
{

	/*
	 * Estos son por un lado nuestro UserDetailsService y por otro lado una instancia de 
	 * BCryptPasswordEncoder para encriptación de password.
	 */
	/** Attribute bCryptPasswordEncoder */
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	/** Attribute userDetailsService */
	@Autowired
	private ReaktorUserDetailsService userDetailsService;

	/**
	 * Method authenticationProvider 
	 * Este sirve para recuperar los datos del usuario que está intentado loguearse 
	 * sacando los datos desde nuestro UsersDetail y retornará DaoAuthenticationProvider , 
	 * este es para llamadas internas de spring security y nosotros no vamos a llamarlo directamente.
	 *
	 * @return DaoAuthenticationProvider
	 */
	@Bean
	public DaoAuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(this.userDetailsService);
		authProvider.setPasswordEncoder(this.bCryptPasswordEncoder);
		return authProvider;
	}


	/**
	 * Method filterChain 
	 * Este es el más importante de esta clase , ya que se encarga de
	 * decidir qué Roles pueden acceder a qué recursos y cuáles no.
	 * @param http
	 * @return SecurityFilterChain
	 * @throws Exception
	 */
	@Bean
	public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception
	{
		//Desactivar https y habilitar http básico, por defecto está activo.
		http.csrf().disable().authorizeHttpRequests()
			//Permitir a cualquier usuario el acceso a todas esas rutas, las que tienen asteriscos significan que empiezan con eso y cualquier otra dirección siempre que nazca de esta.
			.requestMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**").permitAll()
			//Es importante permitir a todos entrar al login.
			.requestMatchers("/login").permitAll()
			
			// Indicamos que se necesitan permisos de ADMIN , para todos los js ya que están en esa carpeta y para cualquier dirección que empiece por / ,
			// con esto logramos que el login primeramente esté abierto y que todo lo demás necesite permisos de admin.
			.requestMatchers("/js/**").hasAnyAuthority("ADMIN")
			.requestMatchers("/**").hasAnyAuthority("ADMIN")
			
		//Con todo esto último, estamos indicando que el formulario de login, estará en ”/login” que la url por defecto (raíz) será / y 
		//que los parámetros de nombre de usuario y password son aquellos 
		//que pusimos en la página del login con exactamente el mismo nombre. 
		.and()
			.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/")
			.usernameParameter("user_name")
			.passwordParameter("password")
		.and()
			.logout()
		.and()
			.httpBasic();

		return http.build();
	}
}
