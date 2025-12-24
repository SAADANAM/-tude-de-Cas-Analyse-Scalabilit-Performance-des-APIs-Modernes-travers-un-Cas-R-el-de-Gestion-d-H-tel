
package com.example.hotel.controller;

import com.example.hotel.model.Reservation;
import com.example.hotel.repo.ReservationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationRepository repo;

    public ReservationController(ReservationRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public ResponseEntity<Reservation> create(@RequestBody Reservation res) {
        // Save the new reservation
        Reservation savedRes = repo.save(res);
        return ResponseEntity.status(201).body(savedRes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> get(@PathVariable Long id) {
        Optional<Reservation> res = repo.findById(id);
        return res.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> update(@PathVariable Long id, @RequestBody Reservation res) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        
        res.setId(id);
        Reservation updatedRes = repo.save(res);
        return ResponseEntity.ok(updatedRes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
