package com.example.Cryptozoology;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("animal")
    public ArrayList<AnimalDto> getAnimals(){
        return this.animals;
    }
}
