package com.geekster.University.Event.Management.System.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Event {
    @Id
    private Integer eventId;
    private String eventName;
    private String locationOfEvent;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

}
