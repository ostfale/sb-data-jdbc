package de.ostfale.sbdatajdbc.model;

import org.springframework.data.annotation.Id;

public class Minion {

    @Id
    private Long id;
    String name;

    public Minion() {
        this.id = null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
