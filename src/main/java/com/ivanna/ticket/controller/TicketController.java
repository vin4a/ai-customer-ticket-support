package com.ivanna.ticket.controller;

import com.ivanna.ticket.dto.CreateTicketRequest;
import com.ivanna.ticket.dto.TicketResponse;
import com.ivanna.ticket.model.TicketStatus;
import com.ivanna.ticket.service.TicketService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Tickets", description = "Operations for managing support tickets")
@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @Operation(summary = "Get all tickets")
    @GetMapping
    public List<TicketResponse> getAllTickets(){
        return ticketService.getAllTickets();
    }

    @Operation(summary = "Get ticket by id")
    @GetMapping("/{id}")
    public TicketResponse getTicket(@PathVariable Long id){
        return ticketService.getTicketById(id);
    }


    @Operation(summary = "Create a new ticket")
    @PostMapping
    public TicketResponse createTicket(@Valid @RequestBody CreateTicketRequest request){
        return ticketService.createTicket(request);
    }

    @Operation(summary = "Update ticket status")
    @PatchMapping("/{id}")
    public TicketResponse updateTicketStatus(@PathVariable Long id, @RequestBody TicketStatus status){
        return ticketService.updateTicketStatus(id, status);
    }

    @Operation(summary = "Delete a ticket")
    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Long id){
        ticketService.deleteTicket(id);
    }
}
