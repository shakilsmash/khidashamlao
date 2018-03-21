package org.shakilsmash.khidashamlao.service;

import org.shakilsmash.khidashamlao.domain.SustenanceType;
import org.shakilsmash.khidashamlao.domain.Status;
import org.shakilsmash.khidashamlao.repository.SustenanceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class SustenanceTypeServiceImpl implements SustenanceTypeService{
    
    private final SustenanceTypeRepository sustenanceTypeRepository;

    @Autowired
    public SustenanceTypeServiceImpl(SustenanceTypeRepository sustenanceTypeRepository) {
        this.sustenanceTypeRepository = sustenanceTypeRepository;
    }


    /**
     * @inheritDoc
     */
    public SustenanceType save(SustenanceType sustenanceType) {
        return sustenanceTypeRepository.save(sustenanceType);
    }

    /**
     * @inheritDoc
     */
    public SustenanceType retrieve(long id) {
        return sustenanceTypeRepository.findOne(id);
    }

    /**
     * @inheritDoc
     */
    public Page<SustenanceType> retrieveAll(Pageable pageable) {
        return sustenanceTypeRepository.findAll(pageable);
    }

    /**
     * @inheritDoc
     */
    public void delete(long id) {
        SustenanceType sustenanceType = sustenanceTypeRepository.findOne(id);
        sustenanceType.setStatus(Status.DELETED);
        sustenanceType.setDeletedAt(new Timestamp(new Date().getTime()));
        sustenanceTypeRepository.save(sustenanceType);
    }

    /**
     * @inheritDoc
     */
    public void deletePermanently(long id) {
        sustenanceTypeRepository.delete(id);
    }
}
