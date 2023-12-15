package ru.itmo.hls1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.hls1.model.entity.Booking;
import ru.itmo.hls1.model.entity.Playground;

import java.util.List;


@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Playground> findByPlaygroundAvailability(Boolean availability);

}
