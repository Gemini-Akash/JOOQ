package com.example.jooq.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class movies {
    private int movie_id;
    private String name;
    private List<category> categories;

    @Override
    public String toString() {
//
//        String format = "movies{" +
//                "movie_id=" + movie_id +
//                ", name='" + name + '\''+'}';
//
//        if (categories == null){
//            return format;
//        }
        return "movies{" +
                "movie_id=" + movie_id +
                ", name='" + name + '\'' +
                ", categories=" + categories +
                '}';
    }
}
