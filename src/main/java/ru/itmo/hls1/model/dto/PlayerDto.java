package ru.itmo.hls1.model.dto;

import lombok.EqualsAndHashCode;
import ru.itmo.hls1.model.entity.*;
import java.util.Collection;
import lombok.Data;



@EqualsAndHashCode(callSuper = true)
@Data
public record PlayerDto(
        Integer player_id,
        String first_name,
        String last_name,
        Integer age,
        Float height_cm,
        Float weight_kg,
        String gender,
        User user,
        Collection<Team> teams
) {}
