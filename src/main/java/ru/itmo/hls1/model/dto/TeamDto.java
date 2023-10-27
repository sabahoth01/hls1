package ru.itmo.hls1.model.dto;


import ru.itmo.hls1.model.entity.*;
import java.util.Collection;
import lombok.Data;


@Data
public record TeamDto(
        Long team_id,
        String team_name,
        Integer team_size,
        Boolean join_team,
        Collection<Player> players,
        Collection<Booking> bookings,
        Player captain,
        TeamManager manager
) {}

