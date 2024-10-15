package com.upc.talkiabackend.controllers;

import com.upc.talkiabackend.dtos.LevelDTO;
import com.upc.talkiabackend.entities.Level;
import com.upc.talkiabackend.services.LevelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LevelController {

  @Autowired
  private LevelService levelService;

  private final ModelMapper modelMapper = new ModelMapper();

  @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
  @GetMapping("/levels")
  public ResponseEntity<?> listLevels(){
    try {
      List<Level> levels = levelService.listLevels();
      List<LevelDTO> levelsDTOs = modelMapper.map(levels, List.class);
      return new ResponseEntity<>(levelsDTOs, HttpStatus.OK);
    }
    catch (Exception e){
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
