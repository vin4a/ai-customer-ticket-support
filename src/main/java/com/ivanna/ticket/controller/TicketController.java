package com.ivanna.ticket.controller;

import com.ivanna.ticket.dto.CreateTicketRequest;
import com.ivanna.ticket.dto.TicketResponse;
import com.ivanna.ticket.model.TicketStatus;
import com.ivanna.ticket.service.TicketService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Tickets", description = "Operations for managing support tickets.")
@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @Operation(summary = "Create a new ticket")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ticket created succesfully"),
            @ApiResponse(responseCode = "400", description = "Validation error")
    })
    @PostMapping
    public TicketResponse createTicket(@Valid @RequestBody CreateTicketRequest request){
        return ticketService.createTicket(request);
    }

    @Operation(summary = "Get all tickets")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of tickets"),})
    @GetMapping
    public List<TicketResponse> getAllTickets(){
        return ticketService.getAllTickets();
    }

    @Operation(summary = "Get ticket by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ticket found"),
            @ApiResponse(responseCode = "404", description = "Ticket not found")
    })
    @GetMapping("/{id}")
    public TicketResponse getTicket(@PathVariable Long id){
        return ticketService.getTicketById(id);
    }

    @Operation(summary = "Update ticket status")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ticket updated"),
            @ApiResponse(responseCode = "404", description = "Ticket not found")
    })
    @PatchMapping("/{id}")
    public TicketResponse updateTicketStatus(@PathVariable Long id, @RequestBody TicketStatus status){
        return ticketService.updateTicketStatus(id, status);
    }

    @Operation(summary = "Delete a ticket")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ticket deleted"),
            @ApiResponse(responseCode = "404", description = "Ticket not found")
    })
    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Long id){
        ticketService.deleteTicket(id);
    }
}
