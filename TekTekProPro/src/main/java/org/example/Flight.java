package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Flight {
    private String id;
    List<Passanger> passengers = new ArrayList<Passanger>();
    public Flight(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public List<Passanger> getPassengersList() {
        return Collections.unmodifiableList(passengers);
    }
    public abstract boolean addPassenger(Passanger passenger);
    public abstract boolean removePassenger(Passanger passenger);
}