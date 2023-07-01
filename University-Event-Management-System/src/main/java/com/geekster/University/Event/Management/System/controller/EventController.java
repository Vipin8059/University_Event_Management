package com.geekster.University.Event.Management.System.controller;

import com.geekster.University.Event.Management.System.model.Event;
import com.geekster.University.Event.Management.System.service.EventService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class EventController {
    @Autowired
    EventService eventService;

    // add event into database
    @PostMapping("event")
    public String addEvent(@RequestBody Event event){
        return eventService.addEvent(event);
    }

    // get all the events
    @GetMapping("events")
    public Iterable<Event> getAllEvents(){
        return eventService.getAllEvents();
    }

    //get event by DATE
    @GetMapping("event/{date}")
    public List<Event> getEventById(@PathVariable LocalDate date){
        return eventService.getEventById(date);
    }

    // update event by id
    @PutMapping("event/{id}/{location}")
    public String updateEventById(@PathVariable Integer id,@PathVariable String location){
        return eventService.updateEventById(id,location);
    }

    //delete event by id
    @DeleteMapping("event/{id}")
    public String deleteEventById(@PathVariable Integer id){
        return  eventService.deleteEventById(id);
    }



}
