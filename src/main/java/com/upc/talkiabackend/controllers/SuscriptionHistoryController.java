package com.upc.talkiabackend.controllers;

import com.upc.talkiabackend.services.SuscriptionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SuscriptionHistoryController {
    @Autowired
    private SuscriptionHistoryService suscriptionHistoryService;

   // @PreAuthorize("hasRole('USER')")
    @PostMapping("/suscriptionHistory/{user_id}/{sus_id}/{paymentType_id}")
    public ResponseEntity<?> insertInManyToManyTable(@PathVariable int user_id, @PathVariable int sus_id, @PathVariable int paymentType_id){
        try {
            String responseMessage = suscriptionHistoryService.insertInManyToManyTable(user_id, sus_id, paymentType_id);
            return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
