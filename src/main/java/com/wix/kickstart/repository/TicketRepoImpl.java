package com.wix.kickstart.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wix.kickstart.model.Ticket;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class TicketRepoImpl {

    public List<Ticket> getAll() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read JSON file again
            ClassPathResource resource = new ClassPathResource("data.json");
            InputStream inputStream = resource.getInputStream();

            // Map JSON to List<Employee>
            return objectMapper.readValue(inputStream, new TypeReference<>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResponseEntity<List<Ticket>> getTicketsByTitle(String title) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read JSON file again
            ClassPathResource resource = new ClassPathResource("data.json");
            InputStream inputStream = resource.getInputStream();

            // Map JSON to List<Employee>
            List<Ticket> allTickets = objectMapper.readValue(inputStream, new TypeReference<>() {
            });

            // Filter tickets based on search term
            List<Ticket> matchedTickets = allTickets.stream()
                    .filter(ticket -> ticket.getTitle().toLowerCase().contains(title.toLowerCase()))
                    .toList();

            return new ResponseEntity<>(matchedTickets, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<Ticket>> getTicketsByTimeSpan(Long from, Long to) {
        ObjectMapper objectMapper = new ObjectMapper();
        if (null == from) from = Long.MIN_VALUE;
        if (null == to) to = Long.MAX_VALUE;
        try {
            // Read JSON file again
            ClassPathResource resource = new ClassPathResource("data.json");
            InputStream inputStream = resource.getInputStream();

            // Map JSON to List<Employee>
            List<Ticket> allTickets = objectMapper.readValue(inputStream, new TypeReference<>() {
            });

            // Filter tickets based on search term
            Long finalTo = to;
            Long finalFrom = from;
            List<Ticket> matchedTickets = allTickets.stream()
                    .filter(ticket -> (ticket.getCreationTime() <= finalTo) && (ticket.getCreationTime() >= finalFrom))
                    .toList();

            return new ResponseEntity<>(matchedTickets, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<Ticket>> getTicketsBySearchTerm(String searchTerm) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read JSON file again
            ClassPathResource resource = new ClassPathResource("data.json");
            InputStream inputStream = resource.getInputStream();

            // Map JSON to List<Employee>
            List<Ticket> allTickets = objectMapper.readValue(inputStream, new TypeReference<>() {
            });

            // Filter tickets based on search term
            List<Ticket> matchedTickets = allTickets.stream()
                    .filter(ticket -> (
                            ticket.getTitle().toLowerCase().contains(searchTerm.toLowerCase())
                            || ticket.getContent().toLowerCase().contains(searchTerm.toLowerCase())
                            || ticket.getUserEmail().toLowerCase().contains(searchTerm.toLowerCase()))
                    ).toList();

            return new ResponseEntity<>(matchedTickets, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
