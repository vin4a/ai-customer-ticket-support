package com.ivanna.ticket.service;

import com.ivanna.ticket.dto.CreateTicketRequest;
import com.ivanna.ticket.dto.TicketResponse;
import com.ivanna.ticket.exception.TicketNotFoundException;
import com.ivanna.ticket.mapper.TicketMapper;
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
    private final TicketMapper ticketMapper;

    public TicketService(TicketRepository ticketRepository, TicketMapper ticketMapper){
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
    }

    public TicketResponse createTicket(CreateTicketRequest request){
        Ticket ticket = new Ticket();

        ticket.setTitle(request.getTitle());
        ticket.setDescription(request.getDescription());

        ticket.setStatus(TicketStatus.OPEN);
        ticket.setPriority(TicketPriority.MEDIUM);
        ticket.setCreatedAt(LocalDateTime.now());
        Ticket savedTicket = ticketRepository.save(ticket);

        return ticketMapper.toResponse(savedTicket);
    }

    public List<TicketResponse> getAllTickets(){
        List<Ticket> tickets = ticketRepository.findAll();
        return ticketMapper.toResponseList(tickets);
    }

    public TicketResponse getTicketById(Long id){
        Ticket ticket = this.findById(id);
        return ticketMapper.toResponse(ticket);
    }

    public TicketResponse updateTicketStatus(Long id, TicketStatus status){
        Ticket ticket = this.findById(id);
        ticket.setStatus(status);
        Ticket savedTicket = ticketRepository.save(ticket);
        return ticketMapper.toResponse(savedTicket);
    }

    public void deleteTicket(Long id){
        Ticket ticket = this.findById(id);
        ticketRepository.delete(ticket);
    }

    private Ticket findById(Long id){
        return ticketRepository.findById(id).orElseThrow(()-> new TicketNotFoundException(id));
    }

}