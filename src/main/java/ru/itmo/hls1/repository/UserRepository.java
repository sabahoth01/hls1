package ru.itmo.hls1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.booking.playground.model.entity.User;

import java.util.Optional;


public class UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
