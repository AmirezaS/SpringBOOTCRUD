package org.j2ee.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "org.j2ee")
@EntityScan(basePackages = "org.j2ee.model.entity")
@EnableJpaRepositories("org.j2ee.model.repository")
@EnableAspectJAutoProxy

public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}
