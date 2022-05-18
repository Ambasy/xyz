package com.example.MovieList.Service;

import com.example.MovieList.Entity.FileDataEntity;

import java.util.List;

public interface FileDataService {
    List<FileDataEntity> getListOfMoviesInGivenYear(String director, String startYear, String endYear);
    List<FileDataEntity> getHighestBudgetMovie(String year, String country);
    List<FileDataEntity> getMovieWithHigherRating(Integer rating);
    public void saveData();
}
