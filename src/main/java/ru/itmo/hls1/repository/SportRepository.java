package ru.itmo.hls1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.booking.playground.model.entity.Sport;

public class SportRepository extends JpaRepository<Sport, Long> {
}
