package ru.itmo.hls1.model.dto;

import ru.booking.playground.model.entity.Booking;
import ru.booking.playground.model.entity.Player;
import ru.booking.playground.model.entity.TeamManager;

import java.util.Collection;

public record TeamDto(
        Long team_id,
        String team_name,
        Collection<Player> players,
        Collection<Booking> bookings,
        Player captain,
        TeamManager manager
) {}

