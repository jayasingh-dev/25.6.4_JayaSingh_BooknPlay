package com.codewithprojects.springsecurity;
import com.codewithprojects.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Code Generated by Sidekick is for learning and experimentation purposes only.
@SpringBootApplication
public class SpringsecurityApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityApplication.class, args);
	}

	@Override
	public void run(String... args) {
		// No admin creation logic here
	}
}





























//package com.codewithprojects.springsecurity;
//
//import com.codewithprojects.springsecurity.entities.Role;
//import com.codewithprojects.springsecurity.entities.User;
//import com.codewithprojects.springsecurity.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import java.util.List;
//
//@SpringBootApplication
//public class SpringsecurityApplication implements CommandLineRunner {
//
//	@Autowired
//	private UserRepository userRepository;
//
//
//	public static void main(String[] args) {
//		SpringApplication.run(SpringsecurityApplication.class, args);
//	}
//
//
//	//added logic to create the admin account on the startup of the application
//	public void run(String... args){
////		User adminAccount = userRepository.findByRole(Role.ADMIN);
//		List<User> adminAccount = userRepository.findByRole(Role.ADMIN);
//		if (adminAccount == null || adminAccount.isEmpty()){
//			User user = new User();
//			user.setEmail("admin@gmail.com");
//			user.setFirstName("admin");
//			user.setLastName("admin");
//			user.setRole(Role.ADMIN);
//			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
//			userRepository.save(user);
//		}
//
//	}
//
//}
