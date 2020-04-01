package com.cafeto.codechallenge.model;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Table(name = "\"user\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    public User() {
        super();
    }

    public User(String login, String name, String email) {
        super();
        this.login = login;
        this.name = name;
        this.email = email;
    }

    public String getPassword() {

        return password;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setPassword(String password) {

       AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.cafeto.codechallenge");
        context.refresh();

        //Getting Bean by Class
        PasswordEncoder passwordEncoder = context.getBean(PasswordEncoder.class);

        this.password = passwordEncoder.encode(password);
        //this.password = password;
    }

    public String getEmail() {

        return email;
    }

    public void setLogin(String login) {

        this.login = login;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public String getLogin() {

        return login;
    }

}
