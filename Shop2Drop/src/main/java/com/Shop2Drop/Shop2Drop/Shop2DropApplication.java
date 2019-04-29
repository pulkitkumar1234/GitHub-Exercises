package com.Shop2Drop.Shop2Drop;

import com.Shop2Drop.Shop2Drop.entity.Role;
import com.Shop2Drop.Shop2Drop.entity.User;
import com.Shop2Drop.Shop2Drop.entity.UserRole;
import com.Shop2Drop.Shop2Drop.service.UserService;
import com.Shop2Drop.Shop2Drop.utility.SecurityUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class Shop2DropApplication implements CommandLineRunner {

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(Shop2DropApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user=new User();
		user.setFirstname("Pulkit");;
		user.setLastname("Kumar");
		user.setUsername("pk");
		user.setPassword(SecurityUtility.passwordEncoder().encode("pkj"));
		user.setEmail("pkj@gmail.com");
		Set<UserRole> userRoles=new HashSet<>();
		Role role=new Role();
		role.setRoleid(1);
		role.setName("ROLE_USER");
		userRoles.add(new UserRole(user,role));
		userService.createUser(user,userRoles);

	}
}
