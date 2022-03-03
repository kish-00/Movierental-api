package com.movies.app.Controller.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


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


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_actor",joinColumns = {@JoinColumn(referencedColumnName = "Id")},inverseJoinColumns = {@JoinColumn(referencedColumnName = "Id")})
    private List<Actor> actors;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_category",joinColumns = {@JoinColumn(referencedColumnName = "Id")},inverseJoinColumns = {@JoinColumn(referencedColumnName = "Id1", insertable = false, updatable = false)})
    private List<Category> categories;

    @ManyToOne
    private  Language language1;


    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public int getFilmID() {
        return filmID;
    }

    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public byte getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(byte rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Timestamp getLast_update() {
        return last_update;
    }

    public void setLast_update(Timestamp last_update) {
        this.last_update = last_update;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public String getFulltext() {
        return fulltext;
    }

    public void setFulltext(String fulltext) {
        this.fulltext = fulltext;
    }


    public List<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }

}
