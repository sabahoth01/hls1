package ru.itmo.hls1.model.dto;

import lombok.EqualsAndHashCode;
import ru.itmo.hls1.model.entity.*;
import java.util.Collection;
import lombok.Data;


@EqualsAndHashCode(callSuper = true)
@Data
public record PlaygroundDto(
        Integer playground_id,
        String playground_name,
        String locationList,
        Collection<Sport> sports,
        PlaygroundAvailability playgroundAvailability
) {}
