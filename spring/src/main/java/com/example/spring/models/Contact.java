package com.example.spring.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "contacts")
@IdClass(Contact.class)
public class Contact implements Serializable {
    @Id
    @SequenceGenerator(name="identifier", sequenceName="contacts_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="identifier")
    @Column(name="id")
    Long id;

    @Id
    @Column(name="name")
    String name;

    @Id
    @Column(name="address")
    String address;

    @Id
    @Column(name="city")
    String city;

    @Id
    @Column(name="phone")
    String phone;

    @Id
    @Column(name="email")
    String email;

    public Contact() {
    }

    public Contact(String name, String address, String city, String phone, String email) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}