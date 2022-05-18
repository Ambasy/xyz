package com.example.MovieList.Repository;

import com.example.MovieList.Entity.FileDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileDataRepository extends JpaRepository<FileDataEntity, String> {
    @Query(value = "SELECT * FROM movie_data WHERE director = ?1 AND year between ?2 and ?3", nativeQuery = true)
    List<FileDataEntity> getListOfMoviesInGivenYear(String director, String startYear,String endYear);

    @Query(value = "SELECT * FROM movie_data WHERE reviews_from_users> ?1 ORDER BY reviews_from_users DESC", nativeQuery = true)
    List<FileDataEntity> getMovieWithHigherRatings(Integer rating);

    @Query(value = "SELECT * FROM movie_data WHERE budget IN (SELECT MAX(budget) FROM movie_data where year=?1 AND country=?2)", nativeQuery = true)
    List<FileDataEntity> getHighestBudgetMovies(String year, String country);

}
