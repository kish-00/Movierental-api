package com.movies.app.Controller.Service;

import com.movies.app.Controller.Exception.ResourceNotFoundException;
import com.movies.app.Controller.Model.Actor;
import com.movies.app.Controller.Repository.ActorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {
    @Autowired
    private final ActorRepo actorRepo;

    public ActorService(ActorRepo actorRepo) {
        this.actorRepo = actorRepo;
    }

    //creates an actor
    public Actor addActor(Actor actor){
        return actorRepo.save(actor);
    }

    //create a list of actors

    //read a list of all the actors
    public List<Actor> getAllActors(){
        return actorRepo.findAll();
    }

    //reads an actor by its id
    public ResponseEntity<Actor> getActorById(int id){
        Actor actor=actorRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Actor with id "+id+" does not exit."));
        return ResponseEntity.ok(actor);
    }

    //update actor Rest API
    public ResponseEntity<Actor> updateActor(int id, Actor actorInfo){
        Actor actor=actorRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Actor with id "+id+" does not exist."));

        actor.setFirstName(actorInfo.getFirstName());
        actor.setLastName(actorInfo.getLastName());
        actor.setTimestamp(actorInfo.getTimestamp());

        actorRepo.save(actor);
        return ResponseEntity.ok(actor);
    }

    // delete actor from rest API
    public  ResponseEntity<HttpStatus> deleteActor(int id) {
        Actor actor = actorRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Actor with id " + id + " does not exist."));
        actorRepo.delete(actor);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}