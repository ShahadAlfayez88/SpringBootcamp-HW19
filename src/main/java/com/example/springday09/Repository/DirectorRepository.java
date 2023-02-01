package com.example.springday09.Repository;

import com.example.springday09.Model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer> {

    Director findDirectorById(Integer id);

}
