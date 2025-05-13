package com.example.ticketing.event.mapper;

import com.example.ticketing.event.dto.EventDto;
import com.example.ticketing.event.model.Event;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-13T18:27:09+0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.15 (Amazon.com Inc.)"
)
@Component
public class EventMapperImpl implements EventMapper {

    @Override
    public EventDto toDto(Event event) {
        if ( event == null ) {
            return null;
        }

        EventDto.EventDtoBuilder eventDto = EventDto.builder();

        eventDto.id( event.getId() );
        eventDto.name( event.getName() );
        eventDto.description( event.getDescription() );
        eventDto.eventDate( event.getEventDate() );
        eventDto.venueName( event.getVenueName() );
        eventDto.venueAddress( event.getVenueAddress() );
        eventDto.capacity( event.getCapacity() );
        eventDto.ticketPrice( event.getTicketPrice() );
        eventDto.createdAt( event.getCreatedAt() );
        eventDto.updatedAt( event.getUpdatedAt() );

        return eventDto.build();
    }

    @Override
    public Event toEntity(EventDto eventDto) {
        if ( eventDto == null ) {
            return null;
        }

        Event.EventBuilder event = Event.builder();

        event.id( eventDto.getId() );
        event.name( eventDto.getName() );
        event.description( eventDto.getDescription() );
        event.eventDate( eventDto.getEventDate() );
        event.venueName( eventDto.getVenueName() );
        event.venueAddress( eventDto.getVenueAddress() );
        event.capacity( eventDto.getCapacity() );
        event.ticketPrice( eventDto.getTicketPrice() );
        event.createdAt( eventDto.getCreatedAt() );
        event.updatedAt( eventDto.getUpdatedAt() );

        return event.build();
    }
}
