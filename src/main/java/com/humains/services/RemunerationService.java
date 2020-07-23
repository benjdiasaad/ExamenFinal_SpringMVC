package com.humains.services;

import com.humains.entities.Remuneration;
import com.humains.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface RemunerationService {

    Page<Remuneration> findAllRemunerations (Optional<Integer> pageNo, Integer pageSize, String sortBy);
    List<Remuneration> getAllRemunerations();
    Remuneration findById(long id) throws ResourceNotFoundException;
    void save(Remuneration remuneration);
    void deleteById(long id);
}
