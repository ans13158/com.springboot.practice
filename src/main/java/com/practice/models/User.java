package com.practice.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
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

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public User() {}

    public User(int id, String name, int salary, String teamName) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.teamName = teamName;
    }
}
