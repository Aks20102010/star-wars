package com.dzm.starwars.service;


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


    public static final String HTTPS_SWAPI_DEV_API_STARSHIPS_PAGE = "https://swapi.dev/api/starships/?page=";
    public static final String HTTPS_SWAPI_DEV_API_STARSHIPS_BASE_URL = "https://swapi.dev/api/starships";
    @Autowired
    private RestTemplate restTemplate;

    public List<StarWar> getAllStarWars() {
        List<StarWar> results = new ArrayList<>();
        StarWarList starWarList = restTemplate.getForObject(HTTPS_SWAPI_DEV_API_STARSHIPS_BASE_URL, StarWarList.class);
        Integer count = starWarList.getCount();
        int pageSize = 9;
        for (int page = 1; page <= count / pageSize; page++) {
            extractedStarWar(results, page);

        }

        return results;
    }

    private void extractedStarWar(List<StarWar> results, int page) {
        StarWarList warList = restTemplate.getForObject(HTTPS_SWAPI_DEV_API_STARSHIPS_PAGE + page, StarWarList.class);
        log.info("warList" + warList);
        results.addAll(warList.getResults());
    }

    @Override
    public List<StarWar> getAllStarWarsPerPage(Integer page) {
        List<StarWar> pageResult = new ArrayList<>();
        extractedStarWar(pageResult,page);
        return pageResult;
    }
}
