package com.bucketdev.betapptournamentsvc.endpoint;

import com.bucketdev.betapptournamentsvc.dto.TournamentSettingsDTO;
import com.bucketdev.betapptournamentsvc.service.TournamentSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author rodrigo.loyola
 */
@RestController
@RequestMapping("/tournamentSettings")
public class TournamentSettingsController {

    @Autowired
    private TournamentSettingsService service;

    @GetMapping("/tournament/{uid}")
    public ResponseEntity<TournamentSettingsDTO> findByTournamentUid(@PathVariable String uid) {
        return new ResponseEntity<>(service.findByTournamentUid(uid), HttpStatus.OK);
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<TournamentSettingsDTO> upsert(@RequestBody TournamentSettingsDTO dto) {
        return new ResponseEntity<>(service.upsert(dto), HttpStatus.CREATED);
    }

}
