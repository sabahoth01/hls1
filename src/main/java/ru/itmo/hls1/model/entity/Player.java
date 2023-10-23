package ru.itmo.hls1.model.entity;

import jakarta.persistence.*;

import java.util.Collection;

/**
 * Table 'player' contains data about users that are players t.e. user that has a team.
 */
@Entity
@Table(name=player)
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id", unique = true, nullable = false)
    private Long player_id;

    @Column(name = "height_cm", nullable = false)
    private String height_cm;

    @Column(name = "weight_kg", nullable = false)
    private Integer weight_kg;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;


    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "player_team", joinColumns = @JoinColumn(name = "player_id"), inverseJoinColumns = @JoinColumn(name = "team_id"))
    private Collection<Team> teams;
}
//public Long getPlayer_id() {
//        return player_id;
//    }
//
//    public void setPlayer_id(Long player_id) {
//        this.player_id = player_id;
//    }
//}