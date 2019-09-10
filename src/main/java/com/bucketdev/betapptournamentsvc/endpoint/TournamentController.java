package com.bucketdev.betapptournamentsvc.endpoint;

import com.bucketdev.betapptournamentsvc.dto.TournamentDTO;
import com.bucketdev.betapptournamentsvc.dto.UserDTO;
import com.bucketdev.betapptournamentsvc.proxy.UserControllerProxy;
import com.bucketdev.betapptournamentsvc.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @author rodrigo.loyola
 */
@RestController
@RequestMapping("/tournaments")
public class TournamentController {

    @Autowired
    private UserControllerProxy userControllerProxy;

    @Autowired
    private TournamentService service;

    @GetMapping("/users/{name}")
    public Set<UserDTO> users(@PathVariable String name) {
        return userControllerProxy.findByDisplayName(name).getBody();
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<TournamentDTO> upsert(@RequestBody TournamentDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    @PostMapping("/{id}/participants")
    public ResponseEntity<UserDTO> addParticipant(@PathVariable long id, @RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(service.addParticipant(id, userDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/photo")
    public ResponseEntity<TournamentDTO> updatePhotoUrl(@PathVariable long id, @RequestBody TournamentDTO dto) {
        return new ResponseEntity<>(service.updatePhotoUrl(id, dto), HttpStatus.OK);
    }

    @PutMapping("/stage")
    public ResponseEntity<TournamentDTO> updateTournamentStage(@RequestBody TournamentDTO dto) {
        return new ResponseEntity<>(service.updateTournamentStage(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{uid}")
    public ResponseEntity deleteTournament(@PathVariable String uid) {
        service.deleteTournament(uid);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
