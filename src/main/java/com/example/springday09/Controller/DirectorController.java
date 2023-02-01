package com.example.springday09.Controller;

import com.example.springday09.Model.Director;
import com.example.springday09.Service.DirectorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/director")
@RequiredArgsConstructor
public class DirectorController {
    final private DirectorService directorService;
    //display
    @GetMapping("/display")
    public ResponseEntity getDirector(){
        List<Director> directors = directorService.getDirector();
        return ResponseEntity.status(200).body(directors);
    }

//    Add
    @PostMapping("/add")
    public ResponseEntity addMovie(@Valid @RequestBody Director director){
        directorService.addDirector(director);
        return ResponseEntity.status(200).body("Director Added");
    }

    //update
    @PutMapping("/update/{id}")
    public ResponseEntity updateMovie(@Valid @RequestBody Director director, @PathVariable Integer id) {
        directorService.updateDirector(id,director);
        return ResponseEntity.status(200).body("Director is updated ");
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMovie(@PathVariable Integer id){
        directorService.deleteDirector(id);
        return ResponseEntity.status(200).body("Director is deleted ");
    }

}
