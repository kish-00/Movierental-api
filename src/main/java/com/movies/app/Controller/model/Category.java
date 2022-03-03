package com.movies.app.Controller.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int categoryId;

    @Column(name = "name")
    private String name;

    @Column(name="lastUpdate")
    private Timestamp lastUpdate;

    @ManyToMany(mappedBy = "categories")
    private List<Film> films;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> filmCategories) {
        this.films = filmCategories;
    }
}
