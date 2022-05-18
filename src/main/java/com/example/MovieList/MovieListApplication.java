package com.example.MovieList;

import com.example.MovieList.Entity.FileDataEntity;
import com.example.MovieList.Repository.FileDataRepository;
import com.example.MovieList.Service.FileDataService;
import com.example.MovieList.Timer.ExecuterTimeInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication
public class MovieListApplication extends WebMvcConfigurerAdapter implements CommandLineRunner {
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieListApplication.class);

	@Autowired
	FileDataService fileDataService;
//	@Autowired
//	FileDataRepository fileRepository;
//	String line = "";

	public static void main(String[] args) {
		SpringApplication.run(MovieListApplication.class, args);
	}

	/**
	 * This method is used to add X-TIME-TO-EXECUTE header in response
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new ExecuterTimeInterceptor()).addPathPatterns("/**");
	}

	/**
	 * This method is used to store the data in PostgreSQL database when we start our application
	 * @param args
	 * @throws IOException
	 */
	public void run(String... args) throws IOException {
		LOGGER.info("Start Storing Data in Database");
		fileDataService.saveData();
		LOGGER.info("Stored Successfully");
	}
}