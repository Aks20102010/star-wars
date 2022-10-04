package com.dzm.starwars.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
@Component
@Getter
@Setter
@NoArgsConstructor
@ToString
public class StarWarList implements Serializable {
    private Integer count;
    private String next;
    private String previous;
    private List<StarWar> results;

  /*  "count": 36,
            "next": "https://swapi.dev/api/starships/?page=2",
            "previous": null,
            "results": []*/
}
