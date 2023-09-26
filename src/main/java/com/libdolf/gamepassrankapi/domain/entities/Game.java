package com.libdolf.gamepassrankapi.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Game {
    private String id;
    private String title;
    private String developerName;
    private String publisherName;
    private LocalDateTime releaseDate;
    private Set<String> categories;
    private Double reviewScore;
    private Integer reviewCount;
}
