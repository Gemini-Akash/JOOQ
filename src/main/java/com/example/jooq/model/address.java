package com.example.jooq.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class address {

    private int id;
    private String name;

    @Override
    public String toString() {
        return "address{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
