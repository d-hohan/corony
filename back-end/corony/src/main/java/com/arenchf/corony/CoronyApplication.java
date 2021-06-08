package com.arenchf.corony;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication

public class CoronyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronyApplication.class, args);
	}

}
