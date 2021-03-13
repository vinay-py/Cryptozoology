package com.example.Cryptozoology;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ZooController {
    ArrayList<AnimalDto> animals;

    public ZooController(){
        animals = new ArrayList<AnimalDto>();
    }

    @PostMapping("animal")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAnimals(@RequestBody AnimalDto animalDto){
        animals.add(animalDto);
    }
}
