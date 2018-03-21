package org.shakilsmash.khidashamlao.web.controller;

import org.shakilsmash.khidashamlao.domain.SustenanceType;
import org.shakilsmash.khidashamlao.service.SustenanceTypeService;
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
@RequestMapping(value = "sustenanceType")
public class SustenanceTypeController {

    private SustenanceTypeService sustenanceTypeService;

    @Autowired
    public SustenanceTypeController(SustenanceTypeService sustenanceTypeService) {
        this.sustenanceTypeService = sustenanceTypeService;
    }

    /**
     * POST /sustenanceType : Create a new sustenanceType to be inserted into the database
     *
     * @param sustenanceType is the object that is initiated with the information from the input JSON
     * @return the ResponseEntity with status 200 (OK) and with sustenanceType in the body, or with status 404 (Not Found)
     */
    @PostMapping(value = "")
    public ResponseEntity<SustenanceType> createSustenanceType(@Valid @RequestBody SustenanceType sustenanceType) {
        SustenanceType result = sustenanceTypeService.save(sustenanceType);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * GET /sustenanceType/:id : Get a sustenanceType from the database with the given id
     *
     * @param id specifies the id of the object of the sustenanceType that is to be shown from the database
     * @return Returns and displays all the information of the fetched sustenanceType in JSON format.
     */
    @GetMapping(value = "{id}")
    public SustenanceType retrieveSustenanceType(@RequestParam long id) {
        return sustenanceTypeService.retrieve(id);
    }

    /**
     * GET /sustenanceType/ : Get all the sustenanceTypes from the database
     *
     * @return Returns and displays all the information of the fetched sustenanceTypes in JSON format.
     */
    @GetMapping(value = "")
    public ResponseEntity<List<SustenanceType>> retrieveAllSustenanceTypes(Pageable pageable) {
        Page<SustenanceType> page = sustenanceTypeService.retrieveAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "localhost:8080/sustenanceType");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * PUT /sustenanceType/:id : Updates sustenanceType's basic info.
     *
     * @param sustenanceType is the object that is initiated with the information from the input JSON
     * @return the ResponseEntity with status 200 (OK) and with sustenanceType in the body, or with status 404 (Not Found)
     */
    @PutMapping(value = "{id}")
    public ResponseEntity<SustenanceType> updateSustenanceType(@Valid @RequestBody SustenanceType sustenanceType) {
        SustenanceType result = sustenanceTypeService.save(sustenanceType);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * PUT /sustenanceType/delete:id : Soft deletes a sustenanceType.
     *
     * @param id is the id of the object that is to be deleted
     * @return A success message
     */
    @PutMapping(value = "delete/{id}")
    public String deleteSustenanceType(@PathVariable long id) {
        sustenanceTypeService.delete(id);
        return "SustenanceType deleted.";
    }

    /**
     * DELETE /sustenanceType/:id : Hard deletes a sustenanceType.
     *
     * @param id is the id of the object that is to be deleted
     * @return A success message
     */
    @DeleteMapping(value = "{id}")
    public String deleteSustenanceTypePermanently(@RequestParam long id) {
        sustenanceTypeService.deletePermanently(id);
        return "SustenanceType deleted.";
    }
}
