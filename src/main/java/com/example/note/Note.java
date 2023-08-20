package com.example.note;

import lombok.Data;

import javax.persistence.*;

@Table(name = "note")
@Entity
@Data
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String content;
}
