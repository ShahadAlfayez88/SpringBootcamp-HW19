package com.example.springday09.Repository;

import com.example.springday09.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Movie findMovieById(Integer id);

    Movie findMovieByName(String name);

    List<Movie> findAllByRateGreaterThan(double rate);

    List<Movie> findAllByGenre(String genre);

    List<Movie> findAllByDirectorID(Integer directorId);



}
