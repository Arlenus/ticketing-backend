package com.example.ticketing.event.repository;

import com.example.ticketing.event.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByEventDateAfter(LocalDateTime date);
    List<Event> findByNameContainingIgnoreCase(String name);
    List<Event> findByVenueNameContainingIgnoreCase(String venueName);
}