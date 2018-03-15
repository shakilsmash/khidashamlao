package org.shakilsmash.khidashamlao.controller;

import org.shakilsmash.khidashamlao.model.Sustenance;
import org.shakilsmash.khidashamlao.service.SustenanceService;
import org.shakilsmash.khidashamlao.util.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "sustenance")
public class SustenanceController {

    private SustenanceService sustenanceService;

    @Autowired
    public SustenanceController(SustenanceService sustenanceService) {
        this.sustenanceService = sustenanceService;
    }

    /**
     * POST /sustenance : Create a new sustenance to be inserted into the database
     *
     * @param sustenance is the object that is initiated with the information from the input JSON
     * @return the ResponseEntity with status 200 (OK) and with sustenance in the body, or with status 404 (Not Found)
     */
    @PostMapping(value = "")
    public ResponseEntity<Sustenance> createSustenance(@Valid @RequestBody Sustenance sustenance) {
        Sustenance result = sustenanceService.save(sustenance);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * GET /sustenance/:id : Get a sustenance from the database with the given id
     *
     * @param id specifies the id of the object of the sustenance that is to be shown from the database
     * @return Returns and displays all the information of the fetched sustenance in JSON format.
     */
    @GetMapping(value = "{id}")
    public Sustenance retrieveSustenance(@RequestParam long id) {
        return sustenanceService.retrieve(id);
    }

    /**
     * GET /sustenance/ : Get all the sustenances from the database
     *
     * @return Returns and displays all the information of the fetched sustenances in JSON format.
     */
    @GetMapping(value = "")
    public ResponseEntity<List<Sustenance>> retrieveAllSustenances(Pageable pageable) {
        Page<Sustenance> page = sustenanceService.retrieveAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "localhost:8080/sustenance");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

     /**
     * PUT /sustenance/:id : Updates sustenance's basic info.
     *
     * @param sustenance is the object that is initiated with the information from the input JSON
     * @return the ResponseEntity with status 200 (OK) and with sustenance in the body, or with status 404 (Not Found)
     */
    @PutMapping(value = "{id}")
    public ResponseEntity<Sustenance> updateSustenance(@Valid @RequestBody Sustenance sustenance) {
        Sustenance result = sustenanceService.save(sustenance);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * PUT /sustenance/delete:id : Soft deletes a sustenance.
     *
     * @param id is the id of the object that is to be deleted
     * @return A success message
     */
    @PutMapping(value = "delete/{id}")
    public String deleteSustenance(@PathVariable long id) {
        sustenanceService.delete(id);
        return "Sustenance deleted.";
    }

    /**
     * DELETE /sustenance/:id : Hard deletes a sustenance.
     *
     * @param id is the id of the object that is to be deleted
     * @return A success message
     */
    @DeleteMapping(value = "{id}")
    public String deleteSustenancePermanently(@RequestParam long id) {
        sustenanceService.deletePermanently(id);
        return "Sustenance deleted.";
    }
}
