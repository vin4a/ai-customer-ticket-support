package com.ivanna.ticket.service;

import com.ivanna.ticket.model.Ticket;
import com.ivanna.ticket.model.TicketStatus;
import com.ivanna.ticket.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService{

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    public Ticket createTicket(Ticket ticket){
        return null;
    }

    public List<Ticket> getAllTickets(){
        return null;
    }

    public Ticket getTicketByID(Long id){

        return null;
    }

    public Ticket updateTicketStatus(Long id, TicketStatus status){
        return null;
    }

    public void deleteTicket(Long id){

    }

}
