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
    @PostMapping("/addActor")
    public Actor handleAddActor(@RequestBody Actor actor){
        return actorService.addActor(actor);
    }

    //gets all actors
    @GetMapping("/actors")
    public List<Actor> handleGetAllActors(){
        return actorService.getAllActors();
    }

    //gets an actor by its id
    @GetMapping("/actor/{id}")
    public Actor handleGetActorById(@PathVariable int id){
        return actorService.getActorById(id);
    }

    //get actor by first name
    @GetMapping("/actors/{firstName}")
    public Actor handleGetActorByFirstName(@RequestParam(value = "firstName") String firstName){
        return actorService.getActorByFirstName(firstName);
    }

    //get actor by last name
    @GetMapping("/actor/{lastName}")
    public Actor handleGetActorByLastName(@RequestParam(value = "lastName") String lastName){
        return actorService.getActorByLastName(lastName);
    }

    //update actor Rest API
    @PutMapping("/updateActor/{id}")
    public Actor handleUpdateActor(int id, Actor actorInfo){
        return actorService.updateActor(id, actorInfo);
    }

    // delete actor from rest API
    @DeleteMapping("/deleteActor/{id}")
    public String handleDeleteActor(@PathVariable int id){
        return actorService.deleteActor(id);
    }
}
