package com.example.ticketing.ticket.dto;

import com.example.ticketing.ticket.model.Ticket.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {
    private Long id;
    private Long userId;
    private Long eventId;
    private String eventName;
    private String userName;
    private LocalDateTime purchaseDate;
    private Double ticketPrice;
    private TicketStatus status;
    private String seatNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}