package com.apmosys;





import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;





@SpringBootApplication
public class ApMoSysQuizPortalApplication{

	public static void main(String[] args) {
		SpringApplication.run(ApMoSysQuizPortalApplication.class, args);
	}

//	@Autowired
//	private UserServiceImpl service;
//	@Override
//	public void run(String... args) throws Exception {
//		
//		User user=new User();
//		
//		user.setFirstName("Ujjawal");
//		user.setLastName("Kinker");
//		user.setUsername("Ujjawal012");
//		user.setPassword("pqr");
//		user.setEmail("pqr@gmail.com");
//		user.setProfile("default.png");
//		Role role1=new Role();
//		
//		role1.setRoleId(10L);
//		role1.setRoleName("ADMIN");
//		
//		Set<UserRole> userRoles=new HashSet<>();
//		UserRole userRole =new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//		userRoles.add(userRole);
//		
//		User user1=this.service.createUser(user, userRoles);
//		System.out.println(user1.getUsername());
//		
//	}
//	
	

}
