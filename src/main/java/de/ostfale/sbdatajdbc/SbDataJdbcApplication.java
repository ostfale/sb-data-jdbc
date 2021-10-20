package de.ostfale.sbdatajdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

@SpringBootApplication
@EnableJdbcAuditing
public class SbDataJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbDataJdbcApplication.class, args);
    }
}
