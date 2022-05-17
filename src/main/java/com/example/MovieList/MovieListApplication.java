package com.example.MovieList;

import com.example.MovieList.Entity.FileDataEntity;
import com.example.MovieList.Repository.FileDataRepository;
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
	FileDataRepository fileRepository;
	String line = "";

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
		int iteration=0;
		try {
			LOGGER.info("Start storing the CSV file data in PostgreSQL database");
			BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/movies.csv"));
			while ((line = bufferedReader.readLine()) != null) {
				if(iteration == 0) {
					iteration++;
					continue;
				}
				//Regex to split the data of CSV File
				String data[] = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)",-1);

				FileDataEntity fileDataEntity = new FileDataEntity(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9], data[10], data[11], data[12], data[13], data[14], data[15], data[17], data[18], data[19], data[21]);
				if(!data[16].isEmpty()) {
					fileDataEntity.setBudget(Integer.parseInt(data[16]));
				}
				if(!data[20].isEmpty())
				fileDataEntity.setReviews_from_users(Integer.parseInt(data[20]));
				fileRepository.save(fileDataEntity);
			}
			LOGGER.info("Data is successfully stored in PostgreSQL database");
		} catch (Exception e) {
			LOGGER.error("Exception:" + e);
		}
	}
}