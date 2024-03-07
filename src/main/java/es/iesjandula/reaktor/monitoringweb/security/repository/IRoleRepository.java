package es.iesjandula.reaktor.monitoringweb.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.reaktor.models.Role;

/**
 * @author David Martinez
 *
 */
public interface IRoleRepository extends JpaRepository<Role, Integer>
{

	/**
	 * Method findByRole
	 * 
	 * @param  role
	 * @return
	 */
	Role findByRole(String role);

}
