package com.example;

import lombok.Data;

import javax.persistence.*;

@Table(name = "authorities")
@Entity
@Data
public class Authority {
    @Id
    private String username;

    private String authority;
}
