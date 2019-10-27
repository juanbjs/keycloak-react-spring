package com.juanzarate.keycloakSpringMiddleware.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

  @GetMapping(path = "/hello")
  public ResponseEntity<String> getAuthorizedUserName() {
    return ResponseEntity.ok("Hello Wolrd");
  }
}
