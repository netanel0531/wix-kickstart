package com.wix.kickstart.controller;

import com.wix.kickstart.model.Ticket;
import com.wix.kickstart.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;


    @GetMapping("/tickets")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return ticketService.getAllTicketsResponse();
    }

    @GetMapping("/tickets/{title}")
    public ResponseEntity<List<Ticket>> getTicketByTitle(@PathVariable String title) {
        return ticketService.getTicketsResponse(title);
    }

    @PostMapping("/tickets")
    public ResponseEntity<List<Ticket>> getTicketByTimeSpan(@RequestParam Map<String,String> allParams) {
        if (allParams.containsKey("searchTerm")) return ticketService.getTicketsResponseBySearchTerm(allParams.get("searchTerm"));
        if (allParams.containsKey("from") || allParams.containsKey("to")) {
            Long from = allParams.containsKey("from") ? Long.parseLong(allParams.get("from")) : Long.MIN_VALUE;
            Long to = allParams.containsKey("to") ? Long.parseLong(allParams.get("to")) : Long.MAX_VALUE;
            return ticketService.getTicketsResponse(from, to);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}
