package ru.itmo.hls1.model.dto;

import ru.itmo.hls1.constant.*;
import ru.itmo.hls1.model.entity.*;
import java.util.Collection;
import lombok.Data;


@Data
public record PlaygroundDto(
        Integer playground_id,
        String playground_name,
        String locationList,
        Collection<Sport> sports,
        PlaygroundAvailability playgroundAvailability
) {}
