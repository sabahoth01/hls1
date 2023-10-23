package ru.itmo.hls1.model.dto;

import ru.booking.playground.model.entity.Team;
import ru.booking.playground.model.entity.User;

import java.util.Collection;

public record PlayerDto(
        Long player_id,
        String height_cm,
        Integer weight_kg,
        User user,
        Collection<Team> teams
) {}
