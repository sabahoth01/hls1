package ru.itmo.hls1.model.dto;
import java.time.LocalDateTime;
import lombok.Data;


@Data
public record PlaygroundAvailabilityDto(
        Integer playgroundAvailability_id,
        Boolean availability,
        LocalDateTime available_from,
        LocalDateTime available_to,
        PlaygroundDto playground
) {}
