package ru.itmo.hls1.model.dto;

import ru.itmo.hls1.model.entity.*;
import java.util.Collection;
import lombok.Data;

@Data
public record TeamManagerDto(
        Integer teamManager_id,
        Player player,
        Collection<Team> teams) {}


