package com.example.jooq.Annotations;

import com.example.jooq.model.Student;
import com.example.jooq.model.category;
import com.example.jooq.model.movies;
import com.example.jooq.repository.StudentRepoWithCodeGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static test.generated.Tables.*;
import static test.generated.Tables.MOVIE_CATEGORY_RL;

@RestController
public class Controller {
    @Autowired
    private StudentRepoWithCodeGen studentRepoWithCodeGen;


    @GetMapping("/getUser")
    public ResponseEntity gettheUser(){
        try {
            List<?> list =studentRepoWithCodeGen.manyToMany(
                    MOVIE,
                    CATEGORY,
                    MOVIE_CATEGORY_RL,
                    MOVIE.MOVIE_ID,
                    MOVIE.NAME,
                    CATEGORY.CATEGORY_ID,
                    CATEGORY.NAME,
                    MOVIE_CATEGORY_RL.MOVIE_ID,
                    MOVIE_CATEGORY_RL.CATEGORY_ID,
                    "categories",
                    movies.class);

            if (list.size()<=0){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("List is Empty");
            }
            return ResponseEntity.of(Optional.of(list));

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
