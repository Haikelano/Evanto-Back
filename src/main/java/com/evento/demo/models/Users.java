package com.evento.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;


@Document(collection = "user")
public class Users {
   @Id
   private String id;
   private String username;
   private String name;
   private String prenom;
   private String email;
   private String tel;
   private Boolean etat;
   private String contry;

    public Users(String username) {
        this.username = username;
    }

    public Users() {

    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    public String getContry() {
        return contry;
    }

    public void setContry(String contry) {
        this.contry = contry;
    }

    public Users(String id, String name, String prenom, String email, String tel, Boolean etat, String contry) {
        this.id = id;
        this.name = name;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.etat = etat;
        this.contry = contry;
    }
}
