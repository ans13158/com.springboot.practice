package com.practice.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_contacts")
public class UserContacts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull(message = "Phone number cant be blank")
    @Size(min=10, max = 13, message = "Phone number should be 10 or 13 characters long")
    private String phone;
    @NotNull(message = "Address must be present")
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id", referencedColumnName = "id")
    private User users;

    public UserContacts() { }

    public UserContacts(Integer id,
                        @NotNull(message = "Phone number cant be blank")
                        @Size(min = 10, max = 13, message = "Phone number should be 10 or 13 characters long")
                                String phone, @NotNull(message = "Address must be present")
                        String address,
                        User users) {
        this.id = id;
        this.phone = phone;
        this.address = address;
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public UserContacts setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserContacts setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserContacts setAddress(String address) {
        this.address = address;
        return this;
    }

    public User getUsers() {
        return users;
    }

    public UserContacts setUsers(User users) {
        this.users = users;
        return this;
    }

    @Override
    public String toString() {
        return "UserContacts{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", users=" + users.toString() +
                '}';
    }
}
