package com.movies.app.Controller.ApiControllers;


import com.movies.app.Controller.Repository.ActorRepo;
//import com.movies.app.Controller.Repository.CountryRepo;
import com.movies.app.Controller.exception.ResourceNotFoundException;
import com.movies.app.Controller.model.Actor;
//import com.movies.app.Controller.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class ActorController {
    @Autowired
    private ActorRepo actorRepo;

    // get all actors
    @GetMapping(value = "/actors")
    public List<Actor> getAllActors(){
        return actorRepo.findAll();
    }
    //create actor Rest API
    @PostMapping("/actors")
    public Actor createActor(@RequestBody Actor actor){
        return actorRepo.save(actor);
    }
    //get actor by id
    @GetMapping(value = "/actors/{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable int id){
        Actor actor=actorRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Actor not exist with id:" + id));
        return ResponseEntity.ok(actor);
    }

    // update actor Rest API
    @PutMapping(value = "/actors/{id}")
    public ResponseEntity<Actor> updateActor(@PathVariable int id,@RequestBody Actor actorDetails){
        Actor actor=actorRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Actor not exist with id:" + id));

        actorDetails.setFirstName(actor.getFirstName());
        actor.setLastName(actor.getLastName());
        actor.setTimestamp(actor.getTimestamp());

        actorRepo.save(actorDetails);
        return ResponseEntity.ok(actor);
    }

    // delete actor from rest API
    @DeleteMapping(value = "/actors/{id}")
    public  ResponseEntity<HttpStatus> deleteActor(@PathVariable int id){
        Actor actor=actorRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Actor not exist with id:" + id));
        actorRepo.delete(actor);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
