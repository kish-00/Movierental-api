package com.movies.app.Controller.Repository;

import com.movies.app.Controller.Model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepo extends JpaRepository<Actor,Integer> {
    Actor findByFirstName(String firstName);
    Actor findByLastName(String lastName);
}
