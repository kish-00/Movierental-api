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
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Film")

public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int filmID;

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

    //why?
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "filmActor",joinColumns = {@JoinColumn(referencedColumnName = "Id")},inverseJoinColumns = {@JoinColumn(referencedColumnName = "Id")})
    private List<Actor> actors;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "filmCategory",joinColumns = {@JoinColumn(referencedColumnName = "Id")},inverseJoinColumns = {@JoinColumn(referencedColumnName = "Id1", insertable = false, updatable = false)})
    private List<Category> categories;

    @ManyToOne
    private  Language language;

}
