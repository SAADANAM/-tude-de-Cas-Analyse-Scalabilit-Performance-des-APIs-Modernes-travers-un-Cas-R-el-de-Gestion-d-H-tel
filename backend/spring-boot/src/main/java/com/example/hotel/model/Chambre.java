
package com.example.hotel.model;
import jakarta.persistence.*;

@Entity
public class Chambre {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private double prix;
    private boolean disponible;
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long newId) { this.id = newId; }
    
    public String getType() { return type; }
    public void setType(String roomType) { this.type = roomType; }
    
    public double getPrix() { return prix; }
    public void setPrix(double price) { this.prix = price; }
    
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean isAvailable) { this.disponible = isAvailable; }
}
