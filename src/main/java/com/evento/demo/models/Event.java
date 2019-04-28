package com.evento.demo.models;

import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

@Document(collection = "event")
public class Event {

    @Id
    private String id;
    private String name;
    private String location;
    private int vote;
    private Date datedepart;
    private Date datearet;
    private String type;
    private String descreption;
    private int nombreplace;
    private double prixticket;
    private String image;


    public Event() {
    }

    public Event(String id, String name, String location, int vote, Date datedepart, Date datearet, String type, String descreption, int nombreplace, double prixticket, String image) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.vote = vote;
        this.datedepart = datedepart;
        this.datearet = datearet;
        this.type = type;
        this.descreption = descreption;
        this.nombreplace = nombreplace;
        this.prixticket = prixticket;
        this.image = image;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public Date getDatedepart() {
        return datedepart;
    }

    public void setDatedepart(Date datedepart) {
        this.datedepart = datedepart;
    }

    public Date getDatearet() {
        return datearet;
    }

    public void setDatearet(Date datearet) {
        this.datearet = datearet;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    public int getNombreplace() {
        return nombreplace;
    }

    public void setNombreplace(int nombreplace) {
        this.nombreplace = nombreplace;
    }

    public double getPrixticket() {
        return prixticket;
    }

    public void setPrixticket(double prixticket) {
        this.prixticket = prixticket;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
