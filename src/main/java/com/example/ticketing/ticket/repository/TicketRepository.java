package com.example.ticketing.ticket.repository;

import com.example.ticketing.ticket.model.Ticket;
import com.example.ticketing.ticket.model.Ticket.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByUserId(Long userId);
    List<Ticket> findByEventId(Long eventId);
    List<Ticket> findByUserIdAndEventId(Long userId, Long eventId);
    List<Ticket> findByStatus(TicketStatus status);
    List<Ticket> findByUserIdAndStatus(Long userId, TicketStatus status);
    List<Ticket> findByEventIdAndStatus(Long eventId, TicketStatus status);
    long countByEventId(Long eventId);
    long countByEventIdAndStatus(Long eventId, TicketStatus status);
}