package ru.itmo.hls1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.booking.playground.model.entity.Playground;

public class PlaygroundRepository extends JpaRepository<Playground, Long> {
}