package org.shakilsmash.khidashamlao.web.controller;

import org.shakilsmash.khidashamlao.domain.Cuisine;
import org.shakilsmash.khidashamlao.service.CuisineService;
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
@RequestMapping(value = "cuisine")
public class CuisineController {

    private CuisineService cuisineService;

    @Autowired
    public CuisineController(CuisineService cuisineService) {
        this.cuisineService = cuisineService;
    }

    /**
     * POST /cuisine : Create a new cuisine to be inserted into the database
     *
     * @param cuisine is the object that is initiated with the information from the input JSON
     * @return the ResponseEntity with status 200 (OK) and with cuisine in the body, or with status 404 (Not Found)
     */
    @PostMapping(value = "")
    public ResponseEntity<Cuisine> createCuisine(@Valid @RequestBody Cuisine cuisine) {
        Cuisine result = cuisineService.save(cuisine);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * GET /cuisine/:id : Get a cuisine from the database with the given id
     *
     * @param id specifies the id of the object of the cuisine that is to be shown from the database
     * @return Returns and displays all the information of the fetched cuisine in JSON format.
     */
    @GetMapping(value = "{id}")
    public Cuisine retrieveCuisine(@RequestParam long id) {
        return cuisineService.retrieve(id);
    }

    /**
     * GET /cuisine/ : Get all the cuisines from the database
     *
     * @return Returns and displays all the information of the fetched cuisines in JSON format.
     */
    @GetMapping(value = "")
    public ResponseEntity<List<Cuisine>> retrieveAllCuisines(Pageable pageable) {
        Page<Cuisine> page = cuisineService.retrieveAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "localhost:8080/cuisine");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * PUT /cuisine/:id : Updates cuisine's basic info.
     *
     * @param cuisine is the object that is initiated with the information from the input JSON
     * @return the ResponseEntity with status 200 (OK) and with cuisine in the body, or with status 404 (Not Found)
     */
    @PutMapping(value = "{id}")
    public ResponseEntity<Cuisine> updateCuisine(@Valid @RequestBody Cuisine cuisine) {
        Cuisine result = cuisineService.save(cuisine);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * PUT /cuisine/delete:id : Soft deletes a cuisine.
     *
     * @param id is the id of the object that is to be deleted
     * @return A success message
     */
    @PutMapping(value = "delete/{id}")
    public String deleteCuisine(@PathVariable long id) {
        cuisineService.delete(id);
        return "Cuisine deleted.";
    }

    /**
     * DELETE /cuisine/:id : Hard deletes a cuisine.
     *
     * @param id is the id of the object that is to be deleted
     * @return A success message
     */
    @DeleteMapping(value = "{id}")
    public String deleteCuisinePermanently(@RequestParam long id) {
        cuisineService.deletePermanently(id);
        return "Cuisine deleted.";
    }
}
