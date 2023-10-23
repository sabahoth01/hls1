package ru.itmo.hls1.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Collection;

/**
 * Table 'user' contains data about registered persons
 */

@Entity
@Table(name=user)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    private Long user_id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "gender", nullable = false, length = 1)
    private Character gender;

    @Column(name = "phone", nullable = false, unique = true, length = 15)
    private String phone;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @JsonIgnore
    @OneToOne(mappedBy = "user", orphanRemoval = true, fetch=FetchType.LAZY)
    private Player player;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

}
