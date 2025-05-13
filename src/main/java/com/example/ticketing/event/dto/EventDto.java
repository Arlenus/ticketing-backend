package com.example.ticketing.event.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime eventDate;
    private String venueName;
    private String venueAddress;
    private Integer capacity;
    private Double ticketPrice;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}