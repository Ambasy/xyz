package com.example.MovieList.Service;

import com.example.MovieList.Entity.FileDataEntity;
import com.example.MovieList.Repository.FileDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class FileDataServiceImpl implements FileDataService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileDataServiceImpl.class);

    @Autowired
    FileDataRepository fileDataRepository;

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
        return null;
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
        return null;
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
        return null;
    }
}