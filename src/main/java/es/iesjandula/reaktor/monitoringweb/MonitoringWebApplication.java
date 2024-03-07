package es.iesjandula.reaktor.monitoringweb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import es.iesjandula.reaktor.models.Role;
import es.iesjandula.reaktor.models.User;
import es.iesjandula.reaktor.monitoringweb.security.repository.IRoleRepository;
import es.iesjandula.reaktor.monitoringweb.security.repository.IUserRepository;

/**
 * @author David Martinez
 *
 */
@SpringBootApplication
@EnableJpaRepositories
@EntityScan(basePackages = "es.iesjandula.reaktor.models")
public class MonitoringWebApplication implements CommandLineRunner
{
	/** Attribute iRoleRepository */
	@Autowired
	private IRoleRepository iRoleRepository;

	/** Attribute iUserRepository */
	@Autowired
	private IUserRepository iUserRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	/**
	 * Method main
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		SpringApplication.run(MonitoringWebApplication.class, args);
	}

	/**
	 * Method run
	 * 
	 * @param  args
	 * @throws Exception
	 */
	@Override
	public void run(String... args) throws Exception
	{
		// --- CREATING ROLES AND USERS ---
		
		// --- ADMIN ROLE ---
		Role newRole = new Role();
		newRole.setRole("ADMIN");
		this.iRoleRepository.save(newRole);
		this.iRoleRepository.flush();
		
		// --- USER ROLE ---
		Role newRoleTwo = new Role();
		newRoleTwo.setRole("USER");
		this.iRoleRepository.save(newRoleTwo);
		this.iRoleRepository.flush();
		
		// --- ADMIN USER ---
		User user = new User();
		user.setPassword("1234");
		user.setUserName("admin");
		user.setRoles(new ArrayList<Role>());
		user.setActive(true);

		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(true);
		user.setRoles(new ArrayList<Role>(List.of(this.iRoleRepository.findByRole("ADMIN"))));
		this.iUserRepository.save(user);
		this.iUserRepository.flush();
		
		
		// --- NORMAL USER ---
		User userTwo = new User();
		userTwo.setPassword("1234");
		userTwo.setUserName("user");
		userTwo.setRoles(new ArrayList<Role>());
		userTwo.setActive(true);

		userTwo.setPassword(bCryptPasswordEncoder.encode(userTwo.getPassword()));
		userTwo.setActive(true);
		userTwo.setRoles(new ArrayList<Role>(List.of(this.iRoleRepository.findByRole("USER"))));
		this.iUserRepository.save(userTwo);
		this.iUserRepository.flush();

	}
}
