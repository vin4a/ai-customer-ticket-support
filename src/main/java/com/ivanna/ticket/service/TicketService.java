package com.ivanna.ticket.service;

import com.ivanna.ticket.exception.TicketNotFoundException;
import com.ivanna.ticket.model.Ticket;
import com.ivanna.ticket.model.TicketPriority;
import com.ivanna.ticket.model.TicketStatus;
import com.ivanna.ticket.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketService{

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    public Ticket createTicket(Ticket ticket){
        ticket.setStatus(TicketStatus.OPEN);
        ticket.setPriority(TicketPriority.MEDIUM);
        ticket.setCreatedAt(LocalDateTime.now());
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long id){
        return ticketRepository.findById(id).orElseThrow(()-> new TicketNotFoundException(id));
    }

    public Ticket updateTicketStatus(Long id, TicketStatus status){
        Ticket ticket = getTicketById(id);
        ticket.setStatus(status);
        return ticketRepository.save(ticket);
    }

    public void deleteTicket(Long id){
        ticketRepository.deleteById(id);
    }

}