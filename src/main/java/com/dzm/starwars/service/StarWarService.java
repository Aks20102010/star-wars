package com.dzm.starwars.service;

import com.dzm.starwars.dto.StarWar;
import com.dzm.starwars.dto.StarWarList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StarWarService {
    public List<StarWar> getAllStarWars();
}
