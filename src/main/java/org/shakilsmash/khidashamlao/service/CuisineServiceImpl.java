package org.shakilsmash.khidashamlao.service;

import org.shakilsmash.khidashamlao.domain.Cuisine;
import org.shakilsmash.khidashamlao.domain.Status;
import org.shakilsmash.khidashamlao.repository.CuisineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class CuisineServiceImpl implements CuisineService {

    private final CuisineRepository cuisineRepository;

    @Autowired
    public CuisineServiceImpl(CuisineRepository cuisineRepository) {
        this.cuisineRepository = cuisineRepository;
    }


    /**
     * @inheritDoc
     */
    public Cuisine save(Cuisine cuisine) {
        return cuisineRepository.save(cuisine);
    }

    /**
     * @inheritDoc
     */
    public Cuisine retrieve(long id) {
        return cuisineRepository.findOne(id);
    }

    /**
     * @inheritDoc
     */
    public Page<Cuisine> retrieveAll(Pageable pageable) {
        return cuisineRepository.findAll(pageable);
    }

    /**
     * @inheritDoc
     */
    public void delete(long id) {
        Cuisine cuisine = cuisineRepository.findOne(id);
        cuisine.setStatus(Status.DELETED);
        cuisine.setDeletedAt(new Timestamp(new Date().getTime()));
        cuisineRepository.save(cuisine);
    }

    /**
     * @inheritDoc
     */
    public void deletePermanently(long id) {
        cuisineRepository.delete(id);
    }
}
