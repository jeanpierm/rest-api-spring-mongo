package com.jm.demo.champion;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document
public class Champion {

    @Id
    private String id;

    private String name;

    private Role role;

    private String difficulty;

    private Set<String> abilities;

}
