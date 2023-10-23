package ru.itmo.hls1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.booking.playground.model.entity.PlaygroundAvailability;

public class PlaygroundAvailabilityRepository extends JpaRepository<PlaygroundAvailability, Long> {
}
