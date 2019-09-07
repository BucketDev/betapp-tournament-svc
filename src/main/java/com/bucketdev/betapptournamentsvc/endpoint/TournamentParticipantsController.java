package com.bucketdev.betapptournamentsvc.endpoint;

import com.bucketdev.betapptournamentsvc.dto.TournamentParticipantsDTO;
import com.bucketdev.betapptournamentsvc.service.TournamentParticipantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author rodrigo.loyola
 */
@RestController
@RequestMapping("/tournamentParticipants")
public class TournamentParticipantsController {

    @Autowired
    private TournamentParticipantsService service;

    @GetMapping("/participant/{uid}")
    public ResponseEntity<Page<TournamentParticipantsDTO>>
        findByParticipantUid(@PathVariable String uid,
                             @RequestParam(value = "page", defaultValue = "0") int page) {
        return new ResponseEntity<>(service.findByParticipantUid(PageRequest.of(page, 6), uid), HttpStatus.OK);
    }

}
