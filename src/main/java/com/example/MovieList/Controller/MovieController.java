package com.example.MovieList.Controller;

import com.example.MovieList.Entity.FileDataEntity;
import com.example.MovieList.Service.FileDataService;
import com.example.MovieList.Service.FileDataServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class MovieController {

    @Value("${auth.token}")
    private String authToken;

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
    private final FileDataService fileService;

    @Autowired
    public MovieController(FileDataService fileService) {
        this.fileService = fileService;
    }

    /**
     * This API is created to fetch the list of movies which is direct by specific director in given range of the year
     * @param XAuthToken
     * @param director
     * @param startYear
     * @param endYear
     * @return
     */
    @GetMapping("/listOfMovieInGivenYear")
    public ResponseEntity<List<FileDataEntity>> listOfMovies(@RequestHeader("X-AUTH-TOKEN") String XAuthToken,@RequestParam String director, @RequestParam String startYear, @RequestParam String endYear) {
        try {
            if(XAuthToken.equals(authToken)) {
                LOGGER.info("Query based on parameter director:{},startYear:{}, endYear:{}", director, startYear, endYear);
                List<FileDataEntity> data = fileService.getListOfMoviesInGivenYear(director, startYear, endYear);
                LOGGER.info("Fetched the data Successfully");
                return ResponseEntity.status(HttpStatus.OK).body(data);
            }
            else{
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }

        } catch (Exception e) {
            LOGGER.error("Exception while getting data");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    /**
     * This API is created to fetch the list of movies whose rating is higher than what user has provided
     * @param XAuthToken
     * @param rating
     * @return
     */
    @GetMapping("/movieWithHigherRating")
    public ResponseEntity<List<FileDataEntity>> listOfMoviesWithHigherRating(@RequestHeader("X-AUTH-TOKEN") String XAuthToken,@RequestParam Integer rating) {
        try {
            if(XAuthToken.equals(authToken)) {
                LOGGER.info("Query based on parameter rating:{}",rating);
                List<FileDataEntity> data=fileService.getMovieWithHigherRating(rating);
                return ResponseEntity.status(HttpStatus.OK).body(data);
            }
            else{
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }
        } catch (Exception e) {
            LOGGER.error("Exception while getting data");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    /**
     * This API is created to fetch the list of MOVIES whose budget is highest in specific country and in the specific year
     * @param XAuthToken
     * @param year
     * @param country
     * @return
     */
    @GetMapping("/highestBudgetMovie")
    public ResponseEntity<List<FileDataEntity>> listOfMoviesOfHighBudget(@RequestHeader("X-AUTH-TOKEN") String XAuthToken,@RequestParam String year, @RequestParam String country) {
        try {
            if(XAuthToken.equals(authToken)) {
                LOGGER.info("Query based on parameter year:{},country:{}, endYear:{}",year,country);
                List<FileDataEntity> data=fileService.getHighestBudgetMovie(year,country);
                return ResponseEntity.status(HttpStatus.OK).body(data);
            }
            else{
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }
        } catch (Exception e) {
            LOGGER.error("Exception while getting data");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}
