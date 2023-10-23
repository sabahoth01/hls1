package ru.itmo.hls1.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name=team)
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id", unique = true, nullable = false)
    private Long team_id;

    @Column(name = "team_name", nullable = false)
    private String team_name;


    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "teams")
    private Collection<Player> players;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teams")
    private Collection<Booking> bookings;

    @OneToOne(mappedBy = "team", orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "captain_id", referencedColumnName = "player_id")
    private Player captain;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TeamManager manager;
}
