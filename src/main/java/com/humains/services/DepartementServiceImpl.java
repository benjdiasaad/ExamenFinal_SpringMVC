package com.humains.services;

import com.humains.entities.Departement;
import com.humains.exceptions.ResourceNotFoundException;
import com.humains.repositories.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class DepartementServiceImpl implements DepartementService{

    @Autowired
    private DepartementRepository departementRepository;

    @Override
    @Transactional
    public Page<Departement> findAllDepartements(Optional<Integer> pageNo, Integer pageSize, String sortBy) {
        if(pageNo.isPresent()){
            Pageable paging = PageRequest.of(pageNo.get(), pageSize, Sort.by(sortBy));
            return departementRepository.findAll(paging);
        }else{
            Pageable paging = PageRequest.of(0, pageSize, Sort.by(sortBy));
            return departementRepository.findAll(paging);
        }
    }

    @Override
    @Transactional
    public List<Departement> findAll() {
        return departementRepository.findAll();
    }

    @Override
    @Transactional
    public Departement findById(long id) throws ResourceNotFoundException {
        return departementRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException(id)
        );
    }

    @Override
    @Transactional
    public void save(Departement departement) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        departement.setCreated(timestamp);
        departementRepository.save(departement);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        departementRepository.deleteById(id);
    }
}
