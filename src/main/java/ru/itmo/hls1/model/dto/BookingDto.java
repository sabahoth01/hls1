package ru.itmo.hls1.model.dto;

import ru.booking.playground.model.entity.PlaygroundAvailability;
import ru.booking.playground.model.entity.TeamManager;

import java.time.LocalDateTime;

public record BookingDto(
        Long booking_id,
        LocalDateTime start_time,
        LocalDateTime end_time,
        TeamManager teamManager,
        PlaygroundAvailability playgroundAvailability
) {}
