package com.practice.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    @NotNull(message = "Name cannot be blank")
    @Size(min=10, message = "Name must be at-least 10 character long")
    private String name;
    @NotNull(message = "Salary cannot be blank")
    @Min(value = 1000, message = "Salary should be greater than 1000")
    private int salary;
    @Column(name="team_name")
    @NotNull(message = "Team name cannot be blank")
    private String teamName;

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public int getSalary() {
        return salary;
    }

    public User setSalary(int salary) {
        this.salary = salary;
        return this;
    }

    public String getTeamName() {
        return teamName;
    }

    public User setTeamName(String teamName) {
        this.teamName = teamName;
        return this;
    }

    public User() {}

    public User(int id, String name, int salary, String teamName) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.teamName = teamName;
    }
}
