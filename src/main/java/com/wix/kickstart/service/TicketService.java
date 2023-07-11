package com.wix.kickstart.service;

import com.wix.kickstart.model.Ticket;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TicketService {
    public ResponseEntity<List<Ticket>> getAllTicketsResponse();

    public ResponseEntity<List<Ticket>> getTicketsResponse(String title);
    public ResponseEntity<List<Ticket>> getTicketsResponse(Long from, Long to);
    public ResponseEntity<List<Ticket>> getTicketsResponseBySearchTerm(String term);
}
