package com.example.analofurnitureinterface;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.example.analofurnitureinterface.dao")
public class JpaConfiguration {

}
