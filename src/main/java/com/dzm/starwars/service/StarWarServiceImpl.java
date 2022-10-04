package com.dzm.starwars.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.dzm.starwars.dto.StarWar;
import com.dzm.starwars.dto.StarWarList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StarWarServiceImpl implements StarWarService {


    @Autowired
    private RestTemplate restTemplate;

    public List<StarWar> getAllStarWars() {
        List<StarWar> results = new ArrayList<>();
        StarWarList starWarList = restTemplate.getForObject("https://swapi.dev/api/starships", StarWarList.class);
        Integer count = starWarList.getCount();
        int pageSize = 9;
        for (int page = 1; page <= count / pageSize; page++) {
            StarWarList warList = restTemplate.getForObject("https://swapi.dev/api/starships/?page=" + page, StarWarList.class);
            log.info("warList" + warList);
            results.addAll(warList.getResults());

        }

        return results;
    }
}
