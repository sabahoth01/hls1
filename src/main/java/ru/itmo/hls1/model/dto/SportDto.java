package ru.itmo.hls1.model.dto;
import lombok.Data;
import ru.itmo.hls1.constant.SportType;


@Data
public record SportDto(
        Integer sport_id,
        SportType sport_type
) {}
