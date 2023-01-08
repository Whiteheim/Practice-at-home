package com.example.firstproject.objectmapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Burger {
    private String name;
    private int price;
    private List<String> ingredients;
}
