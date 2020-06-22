package com.mcks.spring.microservices.usermanagementservice;

import com.mcks.spring.microservices.usermanagementservice.document.Role;
import com.mcks.spring.microservices.usermanagementservice.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
public class UserManagementApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepository;
	public static void main(String[] args) {
		SpringApplication.run(UserManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		roleRepository.save(new Role(1, "Administrator", "ADMIN", "Y"));
		roleRepository.save(new Role(2, "Vendor", "VNDR", "Y"));
		roleRepository.save(new Role(13, "Customer", "CUST", "Y"));
	}

	
}
							