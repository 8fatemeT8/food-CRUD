package com.example.demo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(value = "com.example.demo.repository")
@EnableTransactionManagement
public class SpringJPAConfig {
}
