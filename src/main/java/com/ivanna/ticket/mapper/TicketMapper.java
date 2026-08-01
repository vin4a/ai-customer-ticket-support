package com.ivanna.ticket.mapper;

import com.ivanna.ticket.dto.TicketResponse;
import com.ivanna.ticket.model.Ticket;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TicketMapper {

    public TicketMapper(){}

    public TicketResponse toResponse(Ticket ticket) {
        TicketResponse response = new TicketResponse();
        response.setId(ticket.getId());
        response.setTitle(ticket.getTitle());
        response.setDescription(ticket.getDescription());
        response.setStatus(ticket.getStatus());
        response.setPriority(ticket.getPriority());
        response.setCreatedAt(ticket.getCreatedAt());
        return response;
    }

    public List<TicketResponse> toResponseList(List<Ticket> tickets){
        List<TicketResponse> response = new ArrayList<>();
        for (Ticket ticket: tickets) {
            response.add(toResponse(ticket));
        }
        return response;
    }
}
