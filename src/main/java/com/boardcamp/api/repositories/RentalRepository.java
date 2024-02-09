package com.boardcamp.api.repositories;

import com.boardcamp.api.models.RentalModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<RentalModel, Long> {
}
