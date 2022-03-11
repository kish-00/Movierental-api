package com.movies.app.Controller.Service;

import com.movies.app.Controller.Exception.ResourceNotFoundException;
import com.movies.app.Controller.Model.Actor;
import com.movies.app.Controller.Repository.ActorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    //read a list of all the actors
    public List<Actor> getAllActors(){
        return actorRepo.findAll();
    }

    //reads an actor by its id
    public Actor getActorById(int id){
        return actorRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Actor with id "+id+" does not exit."));
    }

    //reads an actor by their first name
    public Actor getActorByFirstName(String firstName) {
        return actorRepo.findByFirstName(firstName);
    }

    //reads an actor by the last name
    public Actor getActorByLastName(String lastName) {
        return actorRepo.findByLastName(lastName);
    }

    //update actor
    public Actor updateActor(int id, Actor actorInfo){
        Actor actor=actorRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Actor with id "+id+" does not exist."));
        actor.setFirstName(actorInfo.getFirstName());
        actor.setLastName(actorInfo.getLastName());
        actor.setTimestamp(actorInfo.getTimestamp());
        return  actorRepo.save(actor);
    }

    // delete actor from rest API
    public String deleteActor(int id) {
        Actor actor = actorRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Actor with id " + id + " does not exist."));
        actorRepo.delete(actor);
        return "Actor"+id+"has been deleted!";
    }
}