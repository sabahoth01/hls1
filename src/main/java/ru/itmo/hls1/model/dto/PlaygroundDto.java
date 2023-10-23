package ru.itmo.hls1.model.dto;

import ru.booking.playground.constant.LocationList;
import ru.booking.playground.constant.PlaygroundName;
import ru.booking.playground.model.entity.PlaygroundAvailability;
import ru.booking.playground.model.entity.Sport;

import java.util.Collection;

public record PlaygroundDto(
        Long playground_id,
        PlaygroundName playground_name,
        LocationList locationList,
        Collection<Sport> sports,
        PlaygroundAvailability playgroundAvailability
) {}
