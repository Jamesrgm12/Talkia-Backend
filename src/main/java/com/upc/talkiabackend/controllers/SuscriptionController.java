package com.upc.talkiabackend.controllers;

import com.upc.talkiabackend.dtos.SuscriptionDTO;
import com.upc.talkiabackend.entities.Suscription;
import com.upc.talkiabackend.services.SuscriptionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api")

public class SuscriptionController {

    @Autowired
    private SuscriptionService suscriptionService;

    private final ModelMapper modelMapper = new ModelMapper();

   // @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/suscription")
    public ResponseEntity<?> listSuscription(){
        try {
            List<Suscription> suscriptions = suscriptionService.listSuscriptions();
            List<SuscriptionDTO> suscriptionDTOs = modelMapper.map(suscriptions, List.class);
            return new ResponseEntity<>(suscriptionDTOs, HttpStatus.OK);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
