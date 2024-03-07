package es.iesjandula.reaktor.monitoringweb.security;

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

	/** Attribute bCryptPasswordEncoder */
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	/** Attribute userDetailsService */
	@Autowired
	private ReaktorUserDetalisService userDetailsService;

	/**
	 * Method authenticationProvider that get all the data from the user stored
	 * in the UserDetails
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
	 * Method filterChain , used for set specific privileges when the user try to get any resource
	 * @param http
	 * @return SecurityFilterChain
	 * @throws Exception
	 */
	@Bean
	public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception
	{
		http.
			csrf().
				disable().
					authorizeHttpRequests()
						.requestMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**").permitAll()
							.requestMatchers("/login").permitAll()
								.requestMatchers("/js/**").hasAnyAuthority("ADMIN")
									.requestMatchers("/**").hasAnyAuthority("ADMIN")
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
