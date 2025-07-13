package com.cognizant.springlearn;

import org.slf4j.Logger;
import java.util.Scanner;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Starting SpringLearnApplication...");
        SpringApplication.run(SpringLearnApplication.class, args);
        displayCountry();
        LOGGER.info("SpringLearnApplication ended.");
    }

    public static void displayCountry() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 2-letter country code (IN, US, DE, JP): ");
        String inputCode = scanner.nextLine().toUpperCase();

        try {
            Country country = context.getBean(inputCode, Country.class);
            LOGGER.debug("Country : {}", country.toString());
        } catch (Exception e) {
            System.out.println("❌ Invalid country code entered!");
            LOGGER.error("Bean with id '{}' not found.", inputCode);
        }
    }
}
