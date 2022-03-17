package com.movies.app.Controller.Controller;

import com.movies.app.Controller.Model.Actor;
import com.movies.app.Controller.Service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class ActorController {

    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService){
        this.actorService = actorService;
    }

    //adds an actor
    @PostMapping(value = "/addActor", consumes = "application/JSON")
    public Actor handleAddActor(@RequestBody Actor actor){
        return actorService.addActor(actor);
    }

    //gets all actors
    @GetMapping(value = "/actors", produces = "application/JSON")
    public List<Actor> handleGetAllActors(){
        return actorService.getAllActors();
    }

    //gets an actor by its id
    @GetMapping(value = "/actor/{id}", consumes = "application/JSON", produces = "application/JSON")
    public Actor handleGetActorById(@PathVariable int id){
        return actorService.getActorById(id);
    }

    //get actor by first name
    @GetMapping(value = "/actors/{firstName}", produces = "application/json")
    public Actor handleGetActorByFirstName(@RequestParam(value = "firstName") String firstName){
        return actorService.getActorByFirstName(firstName);
    }

    //get actor by last name
    @GetMapping(value = "/actor/{lastName}", produces = "application/json")
    public Actor handleGetActorByLastName(@RequestParam(value = "lastName") String lastName){
        return actorService.getActorByLastName(lastName);
    }

    //update actor Rest API
    @PutMapping(value = "/updateActor/{id}", consumes = "application/JSON", produces = "application/JSON")
    public Actor handleUpdateActor(int id, Actor actorInfo){
        return actorService.updateActor(id, actorInfo);
    }

    // delete actor from rest API
    @DeleteMapping(value = "/deleteActor/{id}")
    public String handleDeleteActor(@PathVariable int id){
        return actorService.deleteActor(id);
    }
}
