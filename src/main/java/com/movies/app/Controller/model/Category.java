package com.movies.app.Controller.model;

import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id1")
    private int categoryID;

    @Column(name = "name")
    private String name;

    @Column(name="last_Update")
    private Timestamp last_Update;

    @ManyToMany(mappedBy = "categories")
    private List<Film> films;

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getLast_Update() {
        return last_Update;
    }

    public void setLast_Update(Timestamp last_Update) {
        this.last_Update = last_Update;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> filmCategories) {
        this.films = filmCategories;
    }
}
