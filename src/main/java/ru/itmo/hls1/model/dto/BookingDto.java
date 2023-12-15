package ru.itmo.hls1.model.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.itmo.hls1.model.entity.*;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public record BookingDto(
        Long booking_id,
        LocalDateTime start_time,
        LocalDateTime end_time,
        TeamManager teamManager,
        PlaygroundAvailability playgroundAvailability
) {}
