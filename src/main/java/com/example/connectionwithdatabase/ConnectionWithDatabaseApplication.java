package com.example.connectionwithdatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class ConnectionWithDatabaseApplication {//implements CommandLineRunner {

    /*
    @Autowired
    private JdbcTemplate jdbcTemplate;
    */

    public static void main(String[] args) {
        SpringApplication.run(ConnectionWithDatabaseApplication.class, args);
    }

    /*
    @Override
    public void run(String... args) throws Exception {
        String sql = "INSERT INTO user (username, email, password) VALUES (?, ?, ?);";
        int a = jdbcTemplate.update(sql,"ddd", "ddd@gmail.com", "password4");
    }
    */

}
