package com.example.connectionpool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class ConnectionpoolExampleApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ConnectionpoolExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String sql = "SELECT * FROM country";
        jdbcTemplate.query(sql, (rs, rowNum) -> {
            System.out.println("code ID: " + rs.getString("code"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("continent: " + rs.getString("continent"));
            System.out.println("region: " + rs.getString("region"));
            System.out.println("--------------------------------");
            return null;

        });
    }
}
