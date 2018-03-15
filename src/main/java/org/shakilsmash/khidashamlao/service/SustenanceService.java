package org.shakilsmash.khidashamlao.service;

import org.shakilsmash.khidashamlao.model.Sustenance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by shakilsmash on 3/10/2018.
 */
public interface SustenanceService {

    Sustenance save(Sustenance sustenance);

    Sustenance retrieve(long id);

    Page<Sustenance> retrieveAll(Pageable pageable);

    void delete(long id);

    void deletePermanently(long id);

}
