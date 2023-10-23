package ru.itmo.hls1.model.dto;

import ru.booking.playground.model.entity.Team;
import ru.booking.playground.model.entity.User;

import java.util.Collection;

public record TeamManagerDto(
            Long teamManager_id,
            User manager,
            Collection<Team> teams) {}


