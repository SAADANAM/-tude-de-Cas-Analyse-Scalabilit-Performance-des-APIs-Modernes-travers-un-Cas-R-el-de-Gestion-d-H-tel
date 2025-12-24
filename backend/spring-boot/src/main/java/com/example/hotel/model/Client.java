
package com.example.hotel.model;

import jakarta.persistence.*;

@Entity
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long newId) { this.id = newId; }
    
    public String getNom() { return nom; }
    public void setNom(String n) { this.nom = n; }
    
    public String getPrenom() { return prenom; }
    public void setPrenom(String p) { this.prenom = p; }
    
    public String getEmail() { return email; }
    public void setEmail(String mailAddr) { this.email = mailAddr; }
    
    public String getTelephone() { return telephone; }
    public void setTelephone(String tel) { this.telephone = tel; }
}
