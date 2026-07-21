package com.ivanna.ticket.controller;

import com.ivanna.ticket.model.Ticket;
import com.ivanna.ticket.model.TicketStatus;
import com.ivanna.ticket.service.TicketService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    public Ticket getTicket(@PathVariable Long id){
        return ticketService.getTicketById(id);
    }

    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket){
        return ticketService.createTicket(ticket);
    }

    @PatchMapping("/{id}")
    public Ticket updateTicketStatus(@PathVariable Long id, @RequestBody TicketStatus status){
        return ticketService.updateTicketStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Long id){
        ticketService.deleteTicket(id);
    }
}
