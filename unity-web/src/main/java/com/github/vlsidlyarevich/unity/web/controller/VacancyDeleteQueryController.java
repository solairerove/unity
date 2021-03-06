package com.github.vlsidlyarevich.unity.web.controller;

import com.github.vlsidlyarevich.unity.db.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/api/vacancies/delete")
public class VacancyDeleteQueryController {

    @Autowired
    private VacancyService service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> deleteQuery(@RequestBody Map<String, String> ids) {
        return new ResponseEntity<>(service.deleteQuery(ids), HttpStatus.OK);
    }
}
