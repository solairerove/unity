package com.github.vlsidlyarevich.unity.web.controller;

import com.github.vlsidlyarevich.unity.db.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api/vacancies/{vacancyId}/candidates/delete")
public class CandidateDeleteQueryController {

    @Autowired
    private CandidateService service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> deleteQuery(@RequestBody Map<String, String> ids, @PathVariable String vacancyId) {
        return new ResponseEntity<>(service.deleteQuery(vacancyId, ids), HttpStatus.OK);
    }
}
