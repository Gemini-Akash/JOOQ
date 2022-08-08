package com.example.jooq.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Lazy;
import org.springframework.lang.NonNull;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class category {

    private int category_id;

    private String name;


    @JsonIgnore
    private List<movies> movies;

    @Override
    public String toString() {

//        String format="category{" +
//                "category_id=" + category_id +
//                ", name='" + name + '\''+'}';
//        if (movies == null){
//            return format;
//        }
        return "category{" +
                "category_id=" + category_id +
                ", name='" + name + '\'' +
                ", moviesList=" + movies +
                '}';

    }
}
