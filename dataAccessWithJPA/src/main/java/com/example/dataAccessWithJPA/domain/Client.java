package com.example.dataAccessWithJPA.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    private String firstName;
    private String lastName;

    protected Client(){} // Este construtor só existe para o "bem" do JPA. Ele não será usado. Por isso "protected"

    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Client [id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }
}
