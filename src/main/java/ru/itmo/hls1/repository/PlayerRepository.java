package ru.itmo.hls1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.hls1.model.entity.Player;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    Player getPlayerByFirstName(String Firstname);


}
