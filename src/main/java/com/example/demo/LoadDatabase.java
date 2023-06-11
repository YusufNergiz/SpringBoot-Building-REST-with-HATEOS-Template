package com.example.demo;

import com.example.demo.models.Employee;
import com.example.demo.models.Order;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {

        return args -> {
            log.info("Preloading " + employeeRepository.save(new Employee("Yussuf", "Nergiz", "Software Engineer")));
            log.info("Preloading " + employeeRepository.save(new Employee("Hamza", "Nergiz", "Data Scientist")));

            employeeRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));

            orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
            orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));

            orderRepository.findAll().forEach(order -> {
                log.info("Preloaded " + order);
            });
        };
    }
}
