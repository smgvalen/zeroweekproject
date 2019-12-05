package com.projectphase.zero.controllers;

import com.projectphase.zero.models.Civilization;
import com.projectphase.zero.services.CivilizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

@RestController
public class CivilizationRestController {

  private CivilizationService civilizationService;

  @Autowired
  public CivilizationRestController(
      CivilizationService civilizationService) {
    this.civilizationService = civilizationService;
  }


  @GetMapping("/civilizations")
  public ResponseEntity<?> getCivilizationsFromApi() {
    civilizationService.getCivilizations();
    return ResponseEntity.status(HttpStatus.OK).body("save succesfull");
  }

  @GetMapping("/listOfCivilizations")
  public ResponseEntity<?> listFromDatabase() {
    return ResponseEntity.status(200).body(civilizationService.findAll());
  }

  @GetMapping("/conquerors")
  public ResponseEntity<?> listTheConquerors() {
    return ResponseEntity.status(200).body(civilizationService.getConquerors());
  }

  @PostMapping("/civilization/{id}")
  public ResponseEntity<?> saveSpecificCivilizationById(@PathVariable("id") int id) {
    civilizationService.saveCivById(id);
    return ResponseEntity.status(200).body("ok, saved");
  }

  @GetMapping("/civilization/{id}")
  public ResponseEntity<Civilization> representCivilizationById(@PathVariable("id") int id) {
    return ResponseEntity.status(200).body(civilizationService.findCivById(id));
  }
}
