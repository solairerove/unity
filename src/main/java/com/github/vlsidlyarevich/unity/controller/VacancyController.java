package com.github.vlsidlyarevich.unity.controller;

import com.github.vlsidlyarevich.unity.dto.VacancyDTO;
import com.github.vlsidlyarevich.unity.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/vacancies")
public class VacancyController {

    @Autowired
    private VacancyService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllVacancies() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getVacancyById(@PathVariable String id) {
        return new ResponseEntity<>(service.find(Long.valueOf(id)), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addVacancy(@RequestBody VacancyDTO vacancy) {
        return new ResponseEntity<>(service.create(vacancy), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateVacancyById(@PathVariable String id, @RequestBody VacancyDTO vacancy) {
        return new ResponseEntity<>(service.update(Long.valueOf(id), vacancy), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteVacancyById(@PathVariable String id) {
        return new ResponseEntity<>(service.delete(Long.valueOf(id)), HttpStatus.OK);
    }
}