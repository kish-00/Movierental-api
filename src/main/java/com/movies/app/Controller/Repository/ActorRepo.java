package com.movies.app.Controller.Repository;

import com.movies.app.Controller.model.Actor;
import com.movies.app.Controller.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepo extends JpaRepository<Actor,Integer> {
}
