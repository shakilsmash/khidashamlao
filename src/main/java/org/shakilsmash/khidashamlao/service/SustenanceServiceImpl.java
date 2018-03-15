package org.shakilsmash.khidashamlao.service;

import org.shakilsmash.khidashamlao.model.Sustenance;
import org.shakilsmash.khidashamlao.model.Status;
import org.shakilsmash.khidashamlao.repository.SustenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class SustenanceServiceImpl implements SustenanceService {
    private final SustenanceRepository sustenanceRepository;

    @Autowired
    public SustenanceServiceImpl(SustenanceRepository sustenanceRepository) {
        this.sustenanceRepository = sustenanceRepository;
    }
    
    /**
     * Saves a sustenance.
     *
     * @param sustenance is the id of the object that is to be saved
     * @return null
     */
    public Sustenance save(Sustenance sustenance) {
        return sustenanceRepository.save(sustenance);
    }

    /**
     * @param id is the id of the object that is to be returned
     * @return the sustenance object
     */
    public Sustenance retrieve(long id) {
        return sustenanceRepository.findOne(id);
    }

    /**
     * @return all the sustenance objects available on the database
     */
    public Page<Sustenance> retrieveAll(Pageable pageable) {
        return sustenanceRepository.findAll(pageable);
    }

    /**
     * Updates the sustenance status and deletion time but doesn't delete the entity from the database.
     * @return null
     */
    public void delete(long id) {
        Sustenance sustenance = sustenanceRepository.findOne(id);
        sustenance.setStatus(Status.DELETED);
        sustenance.setDeletedAt(new Timestamp(new Date().getTime()));
        sustenanceRepository.save(sustenance);
    }

    /**
     * Deletes the sustenance entity from the database.
     * @return null
     */
    public void deletePermanently(long id) {
        sustenanceRepository.delete(id);
    }}
