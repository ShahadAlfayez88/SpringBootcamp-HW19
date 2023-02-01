package com.example.springday09.Service;

import com.example.springday09.Exception.ApiException;
import com.example.springday09.Model.Director;
import com.example.springday09.Model.Movie;
import com.example.springday09.Repository.DirectorRepository;
import com.example.springday09.Repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    final private MovieRepository movieRepository;

    final private DirectorRepository directorRepository;

    // CRUD

    //ADD
    public void addMovie(Movie movie){
        movieRepository.save(movie);
    }

    //DISPLAY
    public List<Movie> getMovie(){
        return movieRepository.findAll();
    }

    //UPDATE
    public void updateMovie(Integer id,Movie movie){
     Movie Oldmovie = movieRepository.findMovieById(id);

     if (Oldmovie==null){
         throw new ApiException("Movie not found!!");
     }
     Oldmovie.setDuration(movie.getDuration());
     Oldmovie.setName(movie.getName());
     Oldmovie.setGenre(movie.getGenre());
     Oldmovie.setRate(movie.getRate());

     movieRepository.save(Oldmovie);
    }

    //DELETE
    public void deleteMovie(Integer id){
        Movie currentMovie = movieRepository.findMovieById(id);
        if(!movieRepository.existsById(id)){
            throw new ApiException("Id is not found");
        }
        movieRepository.delete(currentMovie);
    }

    // find by name
    public Movie findMovieByName(String name){
        Movie movie = movieRepository.findMovieByName(name);
        if (movie==null){
            throw new ApiException("movie is not found");
        }
        return movie;
    }

    // find all movie with a rate
    public List<Movie> findAllByRate(double rate){
        List<Movie> movies = movieRepository.findAllByRateGreaterThan(rate);
        if (movies.isEmpty()){
            throw new ApiException("Movie is not found");
        }
        return movies;
    }

    // find by genre

    public List<Movie> findAllByGenre(String genre){
        List<Movie> movies = movieRepository.findAllByGenre(genre);
        if (movies.isEmpty()){
            throw new ApiException("there is no movies under this genre");
        }
        return movies;
    }


    // find by director id

    public List<Movie> findAllByDirectorID(Integer id){
        List<Movie> movies = movieRepository.findAllByDirectorID(id);
        if (movies.isEmpty()){
            throw new ApiException("there is no movies by this director");
        }
        return movies;
    }

    // find director name by movie name
    public String findDirectorByName(String name){
        Movie movie = movieRepository.findMovieByName(name);
        if (movie==null){
            throw new ApiException("movie is not found");
        }
        Director DirectorName = directorRepository.findDirectorById(movie.getDirectorID());
        return DirectorName.getName();
    }

}
