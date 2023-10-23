package ru.itmo.hls1.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import ru.booking.playground.constant.LocationList;
import ru.booking.playground.constant.PlaygroundName;

import java.util.Collection;

@Entity
@Table(name=playground)
public class Playground {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playground_id", unique = true, nullable = false)
    private Long playground_id;

    @Enumerated(EnumType.STRING)
    @Column(name = "playground_name", nullable = false)
    private PlaygroundName playgroundName;

    @Enumerated(EnumType.STRING)
    @Column(name = "location", nullable = false)
    private LocationList locationList;

    @JsonIgnore
    @OneToMany(mappedBy = "playgrounds", orphanRemoval = true, fetch = FetchType.LAZY)
    private Collection<Sport> sports;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private PlaygroundAvailability playgroundAvailability;

}
