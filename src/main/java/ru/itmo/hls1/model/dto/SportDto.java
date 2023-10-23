package ru.itmo.hls1.model.dto;
import ru.booking.playground.constant.SportType;

public record SportDto(
        Long sport_id,
        SportType sport_type,
        PlaygroundDto playground
) {}
