package com.example.springday09.Service;

import com.example.springday09.Exception.ApiException;
import com.example.springday09.Model.Director;
import com.example.springday09.Repository.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DirectorService {
    final private DirectorRepository directorRepository;
    final private MovieService movieService;
    // CRUD

    //ADD
    public void addDirector(Director director){
        directorRepository.save(director);
    }

    //DISPLAY
    public List<Director> getDirector(){
        return directorRepository.findAll();
    }

    //UPDATE
    public void updateDirector(Integer id,Director director){
        Director newDirector = directorRepository.findDirectorById(id);

        if (newDirector==null){
            throw new ApiException("Director not found!!");
        }
        newDirector.setName(director.getName());
        directorRepository.save(newDirector);
    }

    //DELETE
    public void deleteDirector(Integer id){
        Director currenDirector = directorRepository.findDirectorById(id);
        if(!directorRepository.existsById(id)){
            throw new ApiException("Id is not found");
        }
        directorRepository.delete(currenDirector);
    }

    // Get director movies by id;

    public void getDirectorMovies(Integer id){
        Director currenDirector = directorRepository.findDirectorById(id);
        if(!directorRepository.existsById(id)){
            throw new ApiException("Id is not found");
        }
     movieService.findAllByDirectorID(id);
    }

}
