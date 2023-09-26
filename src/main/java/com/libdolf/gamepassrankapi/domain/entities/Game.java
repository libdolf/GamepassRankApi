package com.libdolf.gamepassrankapi.domain.entities;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
    private List<String> categories = new ArrayList<>();
    private Double reviewScore;
    private Integer reviewCount;
}
