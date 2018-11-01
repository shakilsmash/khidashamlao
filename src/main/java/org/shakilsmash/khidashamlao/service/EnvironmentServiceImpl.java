package org.shakilsmash.khidashamlao.service;

import org.shakilsmash.khidashamlao.domain.Environment;
import org.shakilsmash.khidashamlao.domain.Status;
import org.shakilsmash.khidashamlao.repository.EnvironmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class EnvironmentServiceImpl implements EnvironmentService{

    private final EnvironmentRepository environmentRepository;

    @Autowired
    public EnvironmentServiceImpl(EnvironmentRepository environmentRepository) {
        this.environmentRepository = environmentRepository;
    }


    /**
     * @inheritDoc
     */
    public Environment save(Environment environment) {
        return environmentRepository.save(environment);
    }

    /**
     * @inheritDoc
     */
    public Environment retrieve(long id) {
        return environmentRepository.findById(id).get();
    }

    /**
     * @inheritDoc
     */
    public Page<Environment> retrieveAll(Pageable pageable) {
        return environmentRepository.findAll(pageable);
    }

    /**
     * @inheritDoc
     */
    public void delete(long id) {
        Environment environment = environmentRepository.findById(id).get();
        environment.setStatus(Status.DELETED);
        environment.setDeletedAt(new Timestamp(new Date().getTime()));
        environmentRepository.save(environment);
    }

    /**
     * @inheritDoc
     */
    public void deletePermanently(long id) {
        environmentRepository.deleteById(id);
    }
}
