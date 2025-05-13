package com.example.ticketing.event.mapper;

import com.example.ticketing.event.dto.EventDto;
import com.example.ticketing.event.model.Event;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    EventDto toDto(Event event);

    Event toEntity(EventDto eventDto);
}