package com.example.MovieList.Service;

import com.example.MovieList.Entity.FileDataEntity;
import com.example.MovieList.Repository.FileDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
public class FileDataServiceImpl implements FileDataService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileDataServiceImpl.class);

    @Autowired
    FileDataRepository fileDataRepository;
    String line = "";

    /**
     * This function is created to get list of Movies which is direct by specific director within the specific period of year
     * @param director
     * @param startYear
     * @param endYear
     * @return
     */
    @Override
    public List<FileDataEntity> getListOfMoviesInGivenYear(String director, String startYear, String endYear) {
        try {
            LOGGER.info("Started fetching data from database");
            List<FileDataEntity> data = fileDataRepository.getListOfMoviesInGivenYear(director, startYear, endYear);
            LOGGER.info("Data successfully fetched");
            return data;
        } catch (Exception e) {
            LOGGER.error("Not able to fetch data");
        }
        return Collections.emptyList();
    }

    /**
     * This function is created to get Highest Budget Movie of specific country in specific year
     * @param year
     * @param country
     * @return
     */
    @Override
    public List<FileDataEntity> getHighestBudgetMovie(String year, String country) {
        try {
            LOGGER.info("Started fetching data from database");
            List<FileDataEntity> data = fileDataRepository.getHighestBudgetMovies(year, country);
            LOGGER.info("Data successfully fetched");
            return data;
        } catch (Exception e) {
            LOGGER.error("Not able to fetch data");
        }
        return Collections.emptyList();
    }

    /**
     * THis function is created to get Movie list whose rating is higher than what is provided by user
     * @param rating
     * @return
     */
    @Override
    public List<FileDataEntity> getMovieWithHigherRating(Integer rating) {
        try {
            LOGGER.info("Started fetching data from database");
            List<FileDataEntity> data = fileDataRepository.getMovieWithHigherRatings(rating);
            LOGGER.info("Data successfully fetched");
            return data;
        } catch (Exception e) {
            LOGGER.error("Not able to fetch data");
        }
        return Collections.emptyList();
    }

    @Override
    public void saveData() {
        BufferedReader bufferedReader=null;
        int iteration=0;
        try {
            bufferedReader = new BufferedReader(new FileReader("src/main/resources/movies.csv"));
                LOGGER.info("Start storing the CSV file data in PostgreSQL database");
                while ((line = bufferedReader.readLine()) != null) {
                    if (iteration == 0) {
                        iteration++;
                        continue;
                    }
                    //Regex to split the data of CSV File
                    String data[] = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                    FileDataEntity fileDataEntity = new FileDataEntity(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9], data[10], data[11], data[12], data[13], data[14], data[15], data[17], data[18], data[19], data[21]);
                    if (!data[16].isEmpty()) {
                        fileDataEntity.setBudget(Integer.parseInt(data[16]));
                    }
                    if (!data[20].isEmpty()) {
                        fileDataEntity.setReviews_from_users(Integer.parseInt(data[20]));
                    }
                    fileDataRepository.save(fileDataEntity);
                }
                LOGGER.info("Data is successfully stored in PostgreSQL database");

        } catch (Exception e) {
            LOGGER.error("Exception:" + e);
        }finally {
            // this block will be executed in every case, success or caught exception
            if (bufferedReader != null) {
                // again, a resource is involved, so try-catch another time
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
