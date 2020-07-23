package com.humains.services;

import com.humains.entities.Departement;
import com.humains.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface DepartementService {

    Page<Departement> findAllDepartements (Optional<Integer> pageNo, Integer pageSize, String sortBy);
    List<Departement> findAll();
    Departement findById(long id) throws ResourceNotFoundException;
    void save(Departement departement);
    void deleteById(long id);

}
