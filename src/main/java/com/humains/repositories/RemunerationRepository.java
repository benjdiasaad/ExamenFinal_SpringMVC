package com.humains.repositories;

import com.humains.entities.Remuneration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemunerationRepository extends JpaRepository<Remuneration, Long> {
    Page<Remuneration> findAll(Pageable pageable);
}
