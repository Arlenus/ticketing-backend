package com.example.ticketing.ticket.mapper;

import com.example.ticketing.ticket.dto.TicketDto;
import com.example.ticketing.ticket.model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "event.id", target = "eventId")
    @Mapping(source = "user.username", target = "userName")
    @Mapping(source = "event.name", target = "eventName")
    TicketDto toDto(Ticket ticket);

    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "event.id", source = "eventId")
    Ticket toEntity(TicketDto ticketDto);
}