package com.mabdullaev.lesson3;

import lombok.SneakyThrows;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class Lesson3Application {

    public static void main(String[] args) {
        SpringApplication.run(Lesson3Application.class, args);
    }

    @Bean
    @Scope("singleton")
    @SneakyThrows
    public SessionFactory getFactory() {
        return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

}
