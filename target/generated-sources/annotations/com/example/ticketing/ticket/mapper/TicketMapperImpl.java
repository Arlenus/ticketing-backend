package com.example.ticketing.ticket.mapper;

import com.example.ticketing.event.model.Event;
import com.example.ticketing.ticket.dto.TicketDto;
import com.example.ticketing.ticket.model.Ticket;
import com.example.ticketing.user.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-13T18:27:09+0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.15 (Amazon.com Inc.)"
)
@Component
public class TicketMapperImpl implements TicketMapper {

    @Override
    public TicketDto toDto(Ticket ticket) {
        if ( ticket == null ) {
            return null;
        }

        TicketDto.TicketDtoBuilder ticketDto = TicketDto.builder();

        ticketDto.userId( ticketUserId( ticket ) );
        ticketDto.eventId( ticketEventId( ticket ) );
        ticketDto.userName( ticketUserUsername( ticket ) );
        ticketDto.eventName( ticketEventName( ticket ) );
        ticketDto.id( ticket.getId() );
        ticketDto.purchaseDate( ticket.getPurchaseDate() );
        ticketDto.ticketPrice( ticket.getTicketPrice() );
        ticketDto.status( ticket.getStatus() );
        ticketDto.seatNumber( ticket.getSeatNumber() );
        ticketDto.createdAt( ticket.getCreatedAt() );
        ticketDto.updatedAt( ticket.getUpdatedAt() );

        return ticketDto.build();
    }

    @Override
    public Ticket toEntity(TicketDto ticketDto) {
        if ( ticketDto == null ) {
            return null;
        }

        Ticket.TicketBuilder ticket = Ticket.builder();

        ticket.user( ticketDtoToUser( ticketDto ) );
        ticket.event( ticketDtoToEvent( ticketDto ) );
        ticket.id( ticketDto.getId() );
        ticket.purchaseDate( ticketDto.getPurchaseDate() );
        ticket.ticketPrice( ticketDto.getTicketPrice() );
        ticket.status( ticketDto.getStatus() );
        ticket.seatNumber( ticketDto.getSeatNumber() );
        ticket.createdAt( ticketDto.getCreatedAt() );
        ticket.updatedAt( ticketDto.getUpdatedAt() );

        return ticket.build();
    }

    private Long ticketUserId(Ticket ticket) {
        if ( ticket == null ) {
            return null;
        }
        User user = ticket.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long ticketEventId(Ticket ticket) {
        if ( ticket == null ) {
            return null;
        }
        Event event = ticket.getEvent();
        if ( event == null ) {
            return null;
        }
        Long id = event.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String ticketUserUsername(Ticket ticket) {
        if ( ticket == null ) {
            return null;
        }
        User user = ticket.getUser();
        if ( user == null ) {
            return null;
        }
        String username = user.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }

    private String ticketEventName(Ticket ticket) {
        if ( ticket == null ) {
            return null;
        }
        Event event = ticket.getEvent();
        if ( event == null ) {
            return null;
        }
        String name = event.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    protected User ticketDtoToUser(TicketDto ticketDto) {
        if ( ticketDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( ticketDto.getUserId() );

        return user.build();
    }

    protected Event ticketDtoToEvent(TicketDto ticketDto) {
        if ( ticketDto == null ) {
            return null;
        }

        Event.EventBuilder event = Event.builder();

        event.id( ticketDto.getEventId() );

        return event.build();
    }
}
