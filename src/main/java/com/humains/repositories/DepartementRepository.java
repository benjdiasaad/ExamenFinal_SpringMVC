package com.humains.repositories;

import com.humains.entities.Departement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository  extends JpaRepository<Departement, Long> {
    Page<Departement> findAll(Pageable pageable);
}
