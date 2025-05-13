package com.example.ticketing.ticket.service;

import com.example.ticketing.event.model.Event;
import com.example.ticketing.event.repository.EventRepository;
import com.example.ticketing.ticket.dto.TicketDto;
import com.example.ticketing.ticket.mapper.TicketMapper;
import com.example.ticketing.ticket.model.Ticket;
import com.example.ticketing.ticket.model.Ticket.TicketStatus;
import com.example.ticketing.ticket.repository.TicketRepository;
import com.example.ticketing.user.model.User;
import com.example.ticketing.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final TicketMapper ticketMapper;

    @Transactional(readOnly = true)
    public List<TicketDto> getAllTickets() {
        return ticketRepository.findAll().stream()
                .map(ticketMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public TicketDto getTicketById(Long id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id: " + id));
        return ticketMapper.toDto(ticket);
    }

    @Transactional(readOnly = true)
    public List<TicketDto> getTicketsByUserId(Long userId) {
        return ticketRepository.findByUserId(userId).stream()
                .map(ticketMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<TicketDto> getTicketsByEventId(Long eventId) {
        return ticketRepository.findByEventId(eventId).stream()
                .map(ticketMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public TicketDto createTicket(TicketDto ticketDto) {
        User user = userRepository.findById(ticketDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + ticketDto.getUserId()));
        
        Event event = eventRepository.findById(ticketDto.getEventId())
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + ticketDto.getEventId()));
        
        // Check if event has available capacity
        long soldTickets = ticketRepository.countByEventId(event.getId());
        if (soldTickets >= event.getCapacity()) {
            throw new RuntimeException("Event is sold out");
        }
        
        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setEvent(event);
        ticket.setPurchaseDate(LocalDateTime.now());
        ticket.setTicketPrice(event.getTicketPrice());
        ticket.setStatus(TicketStatus.PURCHASED);
        ticket.setSeatNumber(ticketDto.getSeatNumber());
        
        Ticket savedTicket = ticketRepository.save(ticket);
        return ticketMapper.toDto(savedTicket);
    }

    @Transactional
    public TicketDto updateTicketStatus(Long id, TicketStatus status) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id: " + id));
        
        ticket.setStatus(status);
        Ticket updatedTicket = ticketRepository.save(ticket);
        return ticketMapper.toDto(updatedTicket);
    }

    @Transactional
    public void cancelTicket(Long id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id: " + id));
        
        ticket.setStatus(TicketStatus.CANCELLED);
        ticketRepository.save(ticket);
    }

    @Transactional(readOnly = true)
    public long getAvailableTicketsCount(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + eventId));
        
        long soldTickets = ticketRepository.countByEventIdAndStatus(eventId, TicketStatus.PURCHASED);
        return event.getCapacity() - soldTickets;
    }
}