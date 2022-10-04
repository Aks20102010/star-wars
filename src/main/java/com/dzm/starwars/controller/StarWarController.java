package com.dzm.starwars.controller;

import com.dzm.starwars.dto.StarWar;
import com.dzm.starwars.dto.StarWarList;
import com.dzm.starwars.service.StarWarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class StarWarController {
    @Autowired
    private StarWarService starWarService;
    @GetMapping(value="/v1/starwars")
    public ResponseEntity<?> getAllStarWars(){
        List<StarWar> starWars = starWarService.getAllStarWars();
        log.info(starWars.toString());
        return new ResponseEntity<>(starWars, HttpStatus.OK);

    }
    @GetMapping(value="/v1/starwar/{page}")
    public ResponseEntity<?> getAllStarWars(@PathVariable Integer page){
        List<StarWar> starWarPerPage = starWarService.getAllStarWarsPerPage(page);
        log.info(starWarPerPage.toString());
        return new ResponseEntity<>(starWarPerPage, HttpStatus.OK);

    }

}
