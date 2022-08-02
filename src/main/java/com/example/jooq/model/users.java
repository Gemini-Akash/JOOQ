package com.example.jooq.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class users {

    private int id;
    private String name;
    private List<address> address;

    @Override
    public String toString() {
        return "users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
