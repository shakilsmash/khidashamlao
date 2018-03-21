package org.shakilsmash.khidashamlao.web.controller;

import org.shakilsmash.khidashamlao.domain.Environment;
import org.shakilsmash.khidashamlao.service.EnvironmentService;
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
@RequestMapping(value = "environment")
public class EnvironmentController {

    private EnvironmentService environmentService;

    @Autowired
    public EnvironmentController(EnvironmentService environmentService) {
        this.environmentService = environmentService;
    }

    /**
     * POST /environment : Create a new environment to be inserted into the database
     *
     * @param environment is the object that is initiated with the information from the input JSON
     * @return the ResponseEntity with status 200 (OK) and with environment in the body, or with status 404 (Not Found)
     */
    @PostMapping(value = "")
    public ResponseEntity<Environment> createEnvironment(@Valid @RequestBody Environment environment) {
        Environment result = environmentService.save(environment);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * GET /environment/:id : Get a environment from the database with the given id
     *
     * @param id specifies the id of the object of the environment that is to be shown from the database
     * @return Returns and displays all the information of the fetched environment in JSON format.
     */
    @GetMapping(value = "{id}")
    public Environment retrieveEnvironment(@RequestParam long id) {
        return environmentService.retrieve(id);
    }

    /**
     * GET /environment/ : Get all the environments from the database
     *
     * @return Returns and displays all the information of the fetched environments in JSON format.
     */
    @GetMapping(value = "")
    public ResponseEntity<List<Environment>> retrieveAllEnvironments(Pageable pageable) {
        Page<Environment> page = environmentService.retrieveAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "localhost:8080/environment");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * PUT /environment/:id : Updates environment's basic info.
     *
     * @param environment is the object that is initiated with the information from the input JSON
     * @return the ResponseEntity with status 200 (OK) and with environment in the body, or with status 404 (Not Found)
     */
    @PutMapping(value = "{id}")
    public ResponseEntity<Environment> updateEnvironment(@Valid @RequestBody Environment environment) {
        Environment result = environmentService.save(environment);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * PUT /environment/delete:id : Soft deletes a environment.
     *
     * @param id is the id of the object that is to be deleted
     * @return A success message
     */
    @PutMapping(value = "delete/{id}")
    public String deleteEnvironment(@PathVariable long id) {
        environmentService.delete(id);
        return "Environment deleted.";
    }

    /**
     * DELETE /environment/:id : Hard deletes a environment.
     *
     * @param id is the id of the object that is to be deleted
     * @return A success message
     */
    @DeleteMapping(value = "{id}")
    public String deleteEnvironmentPermanently(@RequestParam long id) {
        environmentService.deletePermanently(id);
        return "Environment deleted.";
    }
}
