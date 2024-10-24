package com.upc.talkiabackend.controllers;

import com.upc.talkiabackend.dtos.queries.HistoryByObjectDTO;
import com.upc.talkiabackend.dtos.queries.ShowContentHistoryDTO;
import com.upc.talkiabackend.dtos.queries.ShowHistorialContentDTO;
import com.upc.talkiabackend.services.SuscriptionHistoryService;
import com.upc.talkiabackend.services.UserContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserContentController {

    @Autowired
    private SuscriptionHistoryService suscriptionHistoryService;
    @Autowired
    private UserContentService userContentService;

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/user_content/{contentId}/{userId}")
    public ResponseEntity<?> InsertUserContent(@PathVariable(name = "contentId") Integer contentId,
                                               @PathVariable(name = "userId") Integer userId) {
        try {
            userContentService.insertUserContent(contentId, userId);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/user_content/listar")
    public ResponseEntity<?> listUserContent() {
        try {
            List<ShowHistorialContentDTO> contentDTOs = userContentService.listUserContent();
            return new ResponseEntity<>(contentDTOs, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/content_history_by_user/{userId}")
    public ResponseEntity<?> ListUserContentByUser(@PathVariable int userId) {
        try {
            List<ShowContentHistoryDTO> contentDTOs = userContentService.ListUserContentByUser(userId);
            return new ResponseEntity<>(contentDTOs, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/suscriptionHistoryByUser/{userId}")
    public ResponseEntity<?> listHistoryByUser(@PathVariable int userId){
        try {
            List<HistoryByObjectDTO> historyDTOs = suscriptionHistoryService.listHistoryByUser(userId);
            return new ResponseEntity<>(historyDTOs, HttpStatus.OK);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
