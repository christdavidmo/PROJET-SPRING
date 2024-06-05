package com.ism.core;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages={"core.ism.dependance","com.ism.core"})
@EntityScan("core.ism.dependance.Data.Entity")
@EnableJpaRepositories({"core.ism.dependance.Data.Repository",
						"com.ism.core.Security.data.repositories"})



public class CoreApplication implements CommandLineRunner {

	public static void main(String[] args) { SpringApplication.run(CoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
