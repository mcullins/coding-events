package org.launchcode.codingevents.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message="Name is required")
    @Size(min=3, max=50, message="Name must be between 3-50 characters")
    private String name;

    @Size(max=500, message="Description too long")
    private String description;

    @NotBlank(message="Email is required")
    @Email(message="Invalid email")
    private String contactEmail;

    @NotBlank(message="Location required")
    @NotNull(message="Locationn required")
    private String location;

    private EventType type;

    private boolean register;

    public Event(){ }

    public Event(String name, String description, String contactEmail, String location, EventType type, boolean register) {
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.type = type;
        this.register = register;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public EventType getType() {
        return type;
    }

    public boolean getRegister(){
        return register;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
