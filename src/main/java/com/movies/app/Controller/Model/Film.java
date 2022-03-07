package com.movies.app.Controller.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Film")

public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int filmID;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "releaseYear")
    private Date releaseYear;

    @Column(name = "rentalDuration")
    private byte rentalDuration;

    @Column(name = "rentalRate")
    private BigDecimal rentalRate;

    @Getter @Setter
    @Column(name = "length")
    private int length;

    @Column(name = "replacementCost")
    private BigDecimal replacementCost;

    @Column(name = "rating")
    private String rating;

    @Column(name = "lastUpdate")
    private Timestamp lastUpdate;

    @Column(name = "specialFeatures")
    private String specialFeatures;

    @Column(name = "fullTxt")
    private String fullTxt;

    @OneToMany(mappedBy = "filmInventory")
    private List<Inventory> inventories;

    //why?
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_actor",joinColumns = {@JoinColumn(referencedColumnName = "Id")},inverseJoinColumns = {@JoinColumn(referencedColumnName = "Id")})
    private List<Actor> actors;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_category",joinColumns = {@JoinColumn(referencedColumnName = "Id")},inverseJoinColumns = {@JoinColumn(referencedColumnName = "Id1", insertable = false, updatable = false)})
    private List<Category> categories;

    @ManyToOne
    private  Language language1;

}
