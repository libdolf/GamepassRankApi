package com.libdolf.gamepassrankapi.data.adapters;

import com.libdolf.gamepassrankapi.domain.entities.Game;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface GamePassApiGateway {
    List<Game> getAll();
}
