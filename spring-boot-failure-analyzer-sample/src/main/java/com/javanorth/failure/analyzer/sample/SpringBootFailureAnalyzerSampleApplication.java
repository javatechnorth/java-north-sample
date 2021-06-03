package com.javanorth.failure.analyzer.sample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootFailureAnalyzerSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFailureAnalyzerSampleApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner() throws JavaNorthException {
        throw new JavaNorthException("Java North error.");
    }
}
