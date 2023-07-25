package com.katsevich.mvcapp.entity;



import javax.persistence.*;

import javax.validation.constraints.*;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Surname cannot be empty")
    @Size(min = 2, max = 50, message = "Surname must be between 2 and 50 characters")
    @Column(name = "surname")
    private String surName;

    @NotNull(message = "Age cannot be null")
    @Min(value = 18, message = "Age must be at least 18")
    @Column(name = "age")
    private int age;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    @Column(name = "email")
    private String email;

    public User (){

    }

    public User(String name, String surName, int age, String email) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
