package es.iesjandula.reaktor.monitoringweb.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import es.iesjandula.reaktor.models.Role;
import es.iesjandula.reaktor.models.User;
import es.iesjandula.reaktor.monitoringweb.security.repository.IUserRepository;
import jakarta.transaction.Transactional;

/**
 * @author David Martinez
 * interfaz de spring security que se implementa para que podamos
 * consultar qué usuarios tienen autoridad o no para acceder a recursos y ver si existen o no
 *
 */
@Service
public class ReaktorUserDetalisService implements UserDetailsService
{

	/** Attribute iUserRepository */
	private IUserRepository iUserRepository;

	/**
	 * Constructor for create new ReaktorUserDetalisService
	 *
	 * @param iUserRepository
	 */
	@Autowired
	public ReaktorUserDetalisService(IUserRepository iUserRepository)
	{
		this.iUserRepository = iUserRepository;
	}


	/**
	 * Method loadUserByUsername
	 * Este se encarga de llamar al repositorio y buscar el usuario por su username que le llega por parámetro, este será el que se recogerá en el campo nombre de usuario.
	 * Comprobará si el usuario existe o no mediante un null , y si no existe , arrojamos UsernameNotFoundException.
	 * Si encuentra usuario , llamará al método getUserAuthority y le pasará los roles del usuario.
	 * List<GrantedAuthority> authorities = this.getUserAuthority(user.getRoles());
	 * Finalmente se encargará de llamar al metodo buildForAuthentication , pasandole el usuario y lista de autoridades.
	 * UserDetails userDetails = this.buildUserForAuthentication(user, authorities);
	 * @param userName the username from the loggin
	 * @return UserDetails the UserDetails for spring security
	 * @throws UsernameNotFoundException
	 */
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException
	{
		// --- GETTING USER WITH THE SPECIFIC USERNAME (FROM THE LOGGIN PAGE) ---
		User user = this.iUserRepository.findByUserName(userName);

		// --- IF THE USER ITS NULL , WE NEED TO TRHOW UsernameNotFoundException ---
		if (user == null)
		{
			throw new UsernameNotFoundException("User not found");
		}

		// --- GETTING THE LIST OF ROLES FROM THE USER , AND CONVERTS INTO GRANTED AUTHORITY LIST
		List<GrantedAuthority> authorities = this.getUserAuthority(user.getRoles());

		// --- GETTING THE USER DETAILS FROM THE buildUserForAuthentication WE SEND THE USER AND THE AUTHORITIES
		UserDetails userDetails = this.buildUserForAuthentication(user, authorities);


		// RETURN THE USER DETAILS , WITH ALL THE INFO DONE
		return userDetails;
	}

	/**
	 * Method getUserAuthority 
	 * Este recibe una lista de Role del usuario y creará por cada rol un SimpleGrantedAuthority , 
	 * el cual añadirá a una lista de GrantedAuthority y devolverá.
	 * and add all into List<GrantedAuthority>
	 * @param  userRoles
	 * @return List<GrantedAuthority>
	 */
	private List<GrantedAuthority> getUserAuthority(List<Role> userRoles)
	{
		List<GrantedAuthority> roles = new ArrayList<>();

		// FOR EACH ROLE IN LIST , CONVERT INTO SimpleGrantedAuthority AND ADD TO THE LIST
		for (Role role : userRoles)
		{
			roles.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return roles;
	}

	/**
	 * Method buildUserForAuthentication 
	 *  Este se encarga de evaluar el usuario y la lista de autoridades del método anterior , para determinar si el usuario tiene o no tiene privilegios para el recurso.
	 *	Este retornará un UserDetails camuflado en un objeto User de spring security.
	 *	En este user se indica el nombre de usuario , la password , si está activo , si la cuenta ha expirado , si los credenciales han expirado  ,si está bloqueada y si tiene permiso con la lista de autoridades pasada.
	 *
	 * @param  user
	 * @param  authorities
	 * @return
	 */
	private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities)
	{
		// --- CREATE AND RETURN NEW USER OBJECT (THIS OBJECT IS FROM SPRING SECURITY)---
		// --- THAT USER IMPLEMENTS USER DETAILS , AND COINTAIS ALL THE INFO DONE ---
		return new org.springframework.security.core.userdetails.User(
				// username
				user.getUserName(),
				// password
				user.getPassword(),
				// isActive
				user.getActive(),
				//accountNonExpired set to true if the account has not expired
				true,
				// credentialsNonExpired set to true if the credentials have notexpired
				true,
				//accountNonLocked set to true if the account is not locked
				true,
				// the authorities list
				authorities);
	}
}
