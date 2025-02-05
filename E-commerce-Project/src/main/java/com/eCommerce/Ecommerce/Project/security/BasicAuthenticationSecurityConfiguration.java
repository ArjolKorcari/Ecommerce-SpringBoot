//package com.eCommerce.Ecommerce.Project.security;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//import java.util.function.Function;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import com.eCommerce.Ecommerce.Project.services.UserService;
//
//@Configuration
//public class BasicAuthenticationSecurityConfiguration {
//	
//	
//
//	
//	@Autowired
//	private UserService userService;
//	
//
//	
//	@Bean
//	public InMemoryUserDetailsManager createUserDetalisManager() {
//		InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//		
//		for(com.eCommerce.Ecommerce.Project.models.User user: userService.getUsers()) {
//			UserDetails userDetails= createNewUser(user.getUsername(),user.getPassword());
//			userDetailsManager.createUser(userDetails);
//		}
//		return userDetailsManager;
//	}
//	
//	
//	private UserDetails createNewUser(String username, String password) {
//		Function<String, String> passwordEncoder 
//		= input-> passwordEncoder().encode(input);
//		
//		UserDetails userDetails= User.builder()
//									.passwordEncoder(passwordEncoder)
//									.username(username)
//									.password(password)
//									.roles("USER","ADMIN")
//									.build();
//		
//		return userDetails;
//	}
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//		http.authorizeHttpRequests(
//				auth->auth.anyRequest().authenticated());
//		http.formLogin(withDefaults());
//		
//		http.csrf().disable();
//		http.headers().frameOptions().disable();
//		
//		return http.build();
//	}
//
//}
