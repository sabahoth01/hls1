package ru.itmo.hls1.model.dto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.itmo.hls1.constant.SportType;


@EqualsAndHashCode(callSuper = true)
@Data
public record SportDto(
        Integer sport_id,
        SportType sport_type
) {}
