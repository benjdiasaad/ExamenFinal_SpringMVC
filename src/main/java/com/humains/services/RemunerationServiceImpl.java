package com.humains.services;

import com.humains.entities.Remuneration;
import com.humains.exceptions.ResourceNotFoundException;
import com.humains.repositories.EmployeeRepository;
import com.humains.repositories.RemunerationRepository;
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
public class RemunerationServiceImpl implements RemunerationService {
    @Autowired
    private RemunerationRepository remunerationRepository;

    @Override
    @Transactional
    public Page<Remuneration> findAllRemunerations(Optional<Integer> pageNo, Integer pageSize, String sortBy) {
        if(pageNo.isPresent()){
            Pageable paging = PageRequest.of(pageNo.get(), pageSize, Sort.by(sortBy));
            return remunerationRepository.findAll(paging);
        }else{
            Pageable paging = PageRequest.of(0, pageSize, Sort.by(sortBy));
            return remunerationRepository.findAll(paging);
        }
    }

    @Override
    @Transactional
    public List<Remuneration> getAllRemunerations() {
        return remunerationRepository.findAll();
    }

    @Override
    @Transactional
    public Remuneration findById(long id) throws ResourceNotFoundException {
        return remunerationRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException(id)
        );
    }

    @Override
    @Transactional
    public void save(Remuneration remuneration) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        remuneration.setCreated(timestamp);
        remunerationRepository.save(remuneration);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        remunerationRepository.deleteById(id);
    }
}
