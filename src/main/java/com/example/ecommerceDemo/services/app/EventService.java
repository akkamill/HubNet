package com.example.ecommerceDemo.services.app;

import com.example.ecommerceDemo.DTO.app.EventDTO;
import com.example.ecommerceDemo.entities.app.EventEntity;
import com.example.ecommerceDemo.repositories.app.EventRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public EventDTO createEvent(EventDTO eventDTO) {
        EventEntity eventEntity = toEntity(eventDTO);

        eventEntity = eventRepository.save(eventEntity);

        return toDTO(eventEntity);
    }

    public List<EventDTO> getAllEvents() {
        List<EventEntity> entities = eventRepository.findAll();
        List<EventDTO> dtoList = new ArrayList<>();
        for (EventEntity e : entities) {
            EventDTO eventDTO = toDTO(e);
            dtoList.add(eventDTO);
        }
        return dtoList;
    }

    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }






//------------------------------------------------------------------------------------------------------------------//

    public static EventDTO toDTO(EventEntity event) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setEventId(event.getEventId());
        eventDTO.setTitle(event.getTitle());
        eventDTO.setDescription(event.getDescription());
        eventDTO.setStartTime(event.getStartTime());
        eventDTO.setEndTime(event.getEndTime());

        return eventDTO;
    }

    public static EventEntity toEntity(EventDTO eventDTO) {
        EventEntity event = new EventEntity();
        event.setEventId(eventDTO.getEventId());
        event.setTitle(eventDTO.getTitle());
        event.setDescription(eventDTO.getDescription());
        event.setStartTime(eventDTO.getStartTime());
        event.setEndTime(eventDTO.getEndTime());

        return event;
    }


}
