package org.shakilsmash.khidashamlao.service;

import org.shakilsmash.khidashamlao.model.Sustenance;

/**
 * Created by shakilsmash on 3/10/2018.
 */
public interface SustenanceService {

    Sustenance save(Sustenance sustenance);

    Sustenance retrieve(long id);

    Iterable<Sustenance> retrieveAll();

    void delete(long id);

    void deletePermanently(long id);

}
