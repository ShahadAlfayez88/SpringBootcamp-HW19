package com.example.springday09.Controller;

import com.example.springday09.Model.Director;
import com.example.springday09.Model.Movie;
import com.example.springday09.Service.DirectorService;
import com.example.springday09.Service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
@RequiredArgsConstructor
public class MovieController {

    final private MovieService movieService;

    //display
    @GetMapping("/display")
    public ResponseEntity getMovie(){
        List<Movie> movies = movieService.getMovie();
        return ResponseEntity.status(200).body(movies);
    }

    //Add
    @PostMapping("/add")
    public ResponseEntity addMovie(@Valid @RequestBody Movie movie){
        movieService.addMovie(movie);
        return ResponseEntity.status(200).body("Movie Added");
    }

    //update
    @PutMapping("/update/{id}")
    public ResponseEntity updateMovie(@Valid @RequestBody Movie movie, @PathVariable Integer id) {

        movieService.updateMovie(id,movie);
        return ResponseEntity.status(200).body("Movie is updated ");
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMovie(@PathVariable Integer id){
        movieService.deleteMovie(id);
        return ResponseEntity.status(200).body("Movie is deleted ");
    }

    // Endpoints

    //Create endpoint that search for a specific movie by title
    @GetMapping("/getMovieByName/{name}")
    public ResponseEntity getMovieByName(@PathVariable String name ){
        Movie movie = movieService.findMovieByName(name);
        return ResponseEntity.status(200).body(movie);
    }

    //Create endpoint that takes movie name and return the duration of the movie
    @GetMapping("/getDurationByName/{name}")
    public ResponseEntity getDurationByName(@PathVariable String name ){
        Movie movie = movieService.findMovieByName(name);
        return ResponseEntity.status(200).body(" Movie Duration is "+movie.getDuration());
    }

    //Create endpoint that takes movie name and return the rate of the movie
    @GetMapping("/getRateByName/{name}")
    public ResponseEntity getRateByName(@PathVariable String name ){
        Movie movie = movieService.findMovieByName(name);
        return ResponseEntity.status(200).body(" Movie Rate is "+movie.getRate());
    }


    //Create endpoint that returns all movies above that rate

    @GetMapping("/getMovieByRate/{rate}")
    public ResponseEntity getMovieByRate(@PathVariable double rate ){
        List<Movie> movies = movieService.findAllByRate(rate);
        return ResponseEntity.status(200).body(movies);
    }

    //Create endpoint that returns all movies by a specific genre
    @GetMapping("/getMovieByGenre/{genre}")
    public ResponseEntity getMovieByRate(@PathVariable String genre ){
        List<Movie> movies =movieService.findAllByGenre(genre);
        return ResponseEntity.status(200).body(movies);
    }

    //Create endpoint to list movies to a specific director
    @GetMapping("/getMovieByDirectorId/{id}")
    public ResponseEntity getMovieByDirectorId(@PathVariable Integer id ){
        List<Movie> movies =movieService.findAllByDirectorID(id);
        return ResponseEntity.status(200).body(movies);
    }

    //Create endpoint that takes movie name and return the director name
    @GetMapping("/getDirectorByMovieName/{MovieName}")
    public ResponseEntity getMovieByMovieName(@PathVariable String MovieName ){
        String name = movieService.findDirectorByName(MovieName);
        return ResponseEntity.status(200).body(" Director Name is "+name);
    }



}
