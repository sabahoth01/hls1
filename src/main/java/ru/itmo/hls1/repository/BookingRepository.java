package ru.itmo.hls1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.booking.playground.model.entity.Booking;

public class BookingRepository extends JpaRepository<Booking, Long> {
}
