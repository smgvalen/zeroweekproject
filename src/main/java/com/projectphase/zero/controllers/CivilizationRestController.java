package com.projectphase.zero.controllers;

import com.projectphase.zero.services.CivilizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CivilizationRestController {

  private CivilizationService civilizationService;

  @Autowired
  public CivilizationRestController(
      CivilizationService civilizationService) {
    this.civilizationService = civilizationService;
  }


  @GetMapping("/civilizations")
  public ResponseEntity<?> getCivilizations() {
    civilizationService.getCivilizations();
    return ResponseEntity.status(HttpStatus.OK).body(civilizationService.findAll());
  }
}
