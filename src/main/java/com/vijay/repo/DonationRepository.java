package com.vijay.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijay.entity.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {

}
