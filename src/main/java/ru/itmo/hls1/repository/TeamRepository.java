package ru.itmo.hls1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.booking.playground.model.entity.Team;

public class TeamRepository extends JpaRepository<Team, Long> {
}
