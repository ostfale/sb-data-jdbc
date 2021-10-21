package de.ostfale.sbdatajdbc.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Date;

public class Minion {

    @Id
    private Long id;
    String name;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastModified;

    @Column("DOB") // to map db column if property not same as column name
    private Date dateOfBirth;

    @Transient
    private String dateOfBirthString;

    public Minion() {
        this.id = null;
    }

    public String getDateOfBirthString() {
        return dateOfBirthString;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        this.dateOfBirthString = dateOfBirth.toString();
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
}
