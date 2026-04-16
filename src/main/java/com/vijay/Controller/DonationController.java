package com.vijay.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.entity.Donation;
import com.vijay.repo.DonationRepository;

@RestController
@CrossOrigin
public class DonationController {

    @Autowired
    private DonationRepository repo;

    @PostMapping("/donate")
    public Donation donate(@RequestBody Donation d) {
        return repo.save(d);
    }

    @GetMapping("/donations")
    public List<Donation> getAll() {
        return repo.findAll();
    }

    @PostMapping("/accept/{id}")
    public Donation accept(@PathVariable Long id) {
        Donation d = repo.findById(id).orElseThrow();
        d.setStatus("Accepted");
        return repo.save(d);
    }
}
