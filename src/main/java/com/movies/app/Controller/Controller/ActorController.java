package com.movies.app.Controller.Controller;

//import java.net.URI;

import com.movies.app.Controller.Repository.ActorRepo;
import com.movies.app.Controller.Model.Actor;
import com.movies.app.Controller.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class ActorController {
    @Autowired
    private ActorRepo actorRepo;

    //gets all actors
    @GetMapping(value = "/actors", produces = "application/JSON")
    public List<Actor> getAllActors(){
        return actorRepo.findAll();
    }

    //adds an actor
    @PostMapping(value = "/actors", consumes = "application/JSON")
    public Actor addActor(@RequestBody Actor actor){
        return actorRepo.save(actor);
    }

    //gets an actor by its id
    @GetMapping(value = "/actors/{id}", consumes = "application/JSON", produces = "application/JSON")
    public ResponseEntity<Actor> getActorById(@PathVariable int id){
        Actor actor=actorRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Actor with id "+id+" does not exit."));
        return ResponseEntity.ok(actor);
    }

    //update actor Rest API
    @PutMapping(value = "/actors/{id}", consumes = "application/JSON", produces = "application/JSON")
    public ResponseEntity<Actor> updateActor(@PathVariable int id,@RequestBody Actor actorInfo){
        Actor actor=actorRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Actor with id "+id+" does not exist."));

        actor.setFirstName(actorInfo.getFirstName());
        actor.setLastName(actorInfo.getLastName());
        actor.setTimestamp(actorInfo.getTimestamp());

        actorRepo.save(actor);
        return ResponseEntity.ok(actor);
    }

    // delete actor from rest API
    @DeleteMapping(value = "/actors/{id}")
    public  ResponseEntity<HttpStatus> deleteActor(@PathVariable int id){
        Actor actor=actorRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Actor with id "+id+" does not exist."));
        actorRepo.delete(actor);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
