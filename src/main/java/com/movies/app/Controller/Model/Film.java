package com.movies.app.Controller.Model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "Film")

public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "filmId")
    private int filmId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "releaseYear", nullable = false)
    private Date releaseYear;

    @Column(name = "rentalDuration", nullable = false)
    private byte rentalDuration;

    @Column(name = "rentalRate", nullable = false)
    private BigDecimal rentalRate;

    @Column(name = "length", nullable = false)
    private int length;

    @Column(name = "replacementCost", nullable = false)
    private BigDecimal replacementCost;

    @Column(name = "rating", nullable = false)
    private String rating;

    @Column(name = "lastUpdate", nullable = false)
    private Timestamp lastUpdate;

    @Column(name = "specialFeatures", nullable = false)
    private String specialFeatures;

    @Column(name = "fullTxt", nullable = false)
    private String fullTxt;

    @OneToMany(mappedBy = "filmInventory")
    private List<Inventory> inventories;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "film_actor",
            joinColumns = {@JoinColumn(name = "film_Id", referencedColumnName = "filmId", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "actor_Id",referencedColumnName = "actorId")})
    private List<Actor> actors;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "film_category",
            joinColumns = {@JoinColumn(name = "film_Id", referencedColumnName = "filmId", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "category_Id", referencedColumnName = "categoryId")})
    private List<Category> categories;

    @ManyToOne
    private  Language language;

}
