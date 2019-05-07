package com.Shop2Drop.Shop2DropAdminPanel;

import com.Shop2Drop.Shop2DropAdminPanel.config.SecurityConfig;
import com.Shop2Drop.Shop2DropAdminPanel.entity.Role;
import com.Shop2Drop.Shop2DropAdminPanel.entity.User;
import com.Shop2Drop.Shop2DropAdminPanel.entity.UserRole;
import com.Shop2Drop.Shop2DropAdminPanel.service.UserSecurityService;
import com.Shop2Drop.Shop2DropAdminPanel.service.UserService;
import com.Shop2Drop.Shop2DropAdminPanel.utility.SecurityUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
//@EntityScan
public class Shop2DropApplication implements CommandLineRunner {

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(Shop2DropApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setUsername("admin");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("admin"));
		user1.setEmail("admin@gmail.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1= new Role();
		role1.setRoleid(0);
		role1.setName("ROLE_ADMIN");
		userRoles.add(new UserRole(user1, role1));

		userService.createUser(user1, userRoles);
	}

}
