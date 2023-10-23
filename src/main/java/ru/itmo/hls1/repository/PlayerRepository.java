package ru.itmo.hls1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.booking.playground.model.entity.Player;

public class PlayerRepository extends JpaRepository<Player, Long> {
}
