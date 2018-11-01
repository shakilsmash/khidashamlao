package org.shakilsmash.khidashamlao.service;

import org.shakilsmash.khidashamlao.domain.Sustenance;
import org.shakilsmash.khidashamlao.domain.Status;
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
     * @inheritDoc
     */
    public Sustenance save(Sustenance sustenance) {
        return sustenanceRepository.save(sustenance);
    }

    /**
     * @inheritDoc
     */
    public Sustenance retrieve(long id) {
        return sustenanceRepository.findById(id).get();
    }

    /**
     * @inheritDoc
     */
    public Page<Sustenance> retrieveAll(Pageable pageable) {
        return sustenanceRepository.findAll(pageable);
    }

    /**
     * @inheritDoc
     */
    public void delete(long id) {
        Sustenance sustenance = sustenanceRepository.findById(id).get();
        sustenance.setStatus(Status.DELETED);
        sustenance.setDeletedAt(new Timestamp(new Date().getTime()));
        sustenanceRepository.save(sustenance);
    }

    /**
     * @inheritDoc
     */
    public void deletePermanently(long id) {
        sustenanceRepository.deleteById(id);
    }}
