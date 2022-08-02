package com.example.jooq.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    private int d_id;
    private  String d_name;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + d_id +
                ", name='" + d_name + '\'' +
                '}';
    }
}
