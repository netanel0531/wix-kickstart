package com.wix.kickstart.service;

import com.wix.kickstart.model.Ticket;
import com.wix.kickstart.repository.TicketRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private TicketRepoImpl ticketRepositoryImpl;

    @Autowired
    public TicketServiceImpl(TicketRepoImpl repository) {
        this.ticketRepositoryImpl = repository;
    }


    @Override
    public ResponseEntity<List<Ticket>> getAllTicketsResponse() {
        return new ResponseEntity<>(ticketRepositoryImpl.getAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Ticket>> getTicketsResponse(String title) {
        return ticketRepositoryImpl.getTicketsByTitle(title);
    }

    @Override
    public ResponseEntity<List<Ticket>> getTicketsResponse(Long from, Long to) {
        return ticketRepositoryImpl.getTicketsByTimeSpan(from, to);
    }

    @Override
    public ResponseEntity<List<Ticket>> getTicketsResponseBySearchTerm(String term) {
        return ticketRepositoryImpl.getTicketsBySearchTerm(term);
    }
}

