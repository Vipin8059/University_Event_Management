package com.geekster.University.Event.Management.System.service;

import com.geekster.University.Event.Management.System.model.Event;
import com.geekster.University.Event.Management.System.repository.IEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    IEventRepo eventRepo;

    public String addEvent(Event event) {
        eventRepo.save(event);
        return "event added successfully"+event;
    }

    public Iterable<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    public List<Event> getEventById(LocalDate date) {
        return eventRepo.findByDate(date);
    }

    public String updateEventById(Integer id, String location) {
        Optional<Event> eventOptional = eventRepo.findById(id);
        Event event =  eventOptional.get();
        if(event==null){
            return "event not found for id "+id;

        }
        event.setLocationOfEvent(location);
        eventRepo.save(event);
        return "event updated successfully for event id "+id;

    }

    public String deleteEventById(Integer id) {
        eventRepo.deleteById(id);
        return "event deleted successfully for id "+id;
    }
}
