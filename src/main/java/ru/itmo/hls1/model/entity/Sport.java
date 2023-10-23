package ru.itmo.hls1.model.entity;
import jakarta.persistence.*;
import ru.booking.playground.constant.SportType;

@Entity
@Table(name=sport)
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sport_id", unique = true, nullable = false)
    private Long sport_id;

    @Enumerated(EnumType.STRING)
    @Column(name = "sport_name", nullable = false)
    private SportType sportType;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "playground_id", referencedColumnName = "playground_id")
    private Playground playground;

}
