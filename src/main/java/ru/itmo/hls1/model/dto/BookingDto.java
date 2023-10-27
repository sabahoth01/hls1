package ru.itmo.hls1.model.dto;


import lombok.Data;
import ru.itmo.hls1.model.entity.*;
import java.time.LocalDateTime;

@Data
public record BookingDto(
        Long booking_id,
        LocalDateTime start_time,
        LocalDateTime end_time,
        TeamManager teamManager,
        PlaygroundAvailability playgroundAvailability
) {}
