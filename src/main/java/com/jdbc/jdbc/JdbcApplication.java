package com.jdbc.jdbc;

import com.jdbc.jdbc.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcApplication implements CommandLineRunner {
	@Autowired
	PersonJdbcDao dao;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {

		SpringApplication.run(JdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("\nAll users: {}", dao.findAll());
		log.info("\nUser with id 10001: {}", dao.findById(10001));
		log.info("\nUser with name James {}", dao.findByName("James"));
		log.info("\nDelete user  ", dao.deleteById(10004));
	}
}
