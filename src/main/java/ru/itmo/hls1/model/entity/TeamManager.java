package ru.itmo.hls1.model.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = teamManager)
public class TeamManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_manager_id", unique = true, nullable = false)
    private Long teamManager_id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User manager;

    @OneToMany
    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    private Collection<Team> teams;
}
