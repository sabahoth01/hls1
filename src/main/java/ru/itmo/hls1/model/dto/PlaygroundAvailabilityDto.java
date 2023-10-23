package ru.itmo.hls1.model.dto;
import java.time.LocalDateTime;

public record PlaygroundAvailabilityDto(
        Long playgroundAvailability_id,
        Boolean availability,
        LocalDateTime available_from,
        LocalDateTime available_to,
        PlaygroundDto playground
) {}
