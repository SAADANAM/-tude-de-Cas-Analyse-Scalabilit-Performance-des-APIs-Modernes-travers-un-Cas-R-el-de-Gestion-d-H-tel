
package com.example.hotel.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;

    @ManyToOne(cascade = CascadeType.ALL)
    private Chambre chambre;

    private LocalDate dateDebut;
    private LocalDate dateFin;
    @Column(columnDefinition = "TEXT")
    private String preferences;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long newId) { this.id = newId; }
    
    public Client getClient() { return client; }
    public void setClient(Client c) { this.client = c; }
    
    public Chambre getChambre() { return chambre; }
    public void setChambre(Chambre room) { this.chambre = room; }
    
    public LocalDate getDateDebut() { return dateDebut; }
    public void setDateDebut(LocalDate start) { this.dateDebut = start; }
    
    public LocalDate getDateFin() { return dateFin; }
    public void setDateFin(LocalDate end) { this.dateFin = end; }
    
    public String getPreferences() { return preferences; }
    public void setPreferences(String prefs) { this.preferences = prefs; }
}
