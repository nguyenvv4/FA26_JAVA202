package com.example.java202.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    public Integer id;

    public String name;

    public Users(String name) {
        this.name = name;
    }
}
