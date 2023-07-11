package com.wix.kickstart.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

@Entity
@Data
@Getter
@Table(name = "Tickets")
public class Ticket {

    @Id
    private UUID id;

    private String title;
    private String content;
    private String userEmail;
    private Long creationTime;
    private ArrayList<String> labels;

    @Convert(converter = AttributeConverter.class)
    private Map<String, Object> customerAttributes;

}
