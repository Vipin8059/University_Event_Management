package com.geekster.University.Event.Management.System.repository;

import com.geekster.University.Event.Management.System.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IEventRepo extends CrudRepository<Event,Integer> {
    List<Event> findByDate(LocalDate date);
}
