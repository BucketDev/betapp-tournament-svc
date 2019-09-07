package com.bucketdev.betapptournamentsvc.service.impl;

import com.bucketdev.betapptournamentsvc.dto.ParticipantDTO;
import com.bucketdev.betapptournamentsvc.repository.ParticipantRepository;
import com.bucketdev.betapptournamentsvc.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rodrigo.loyola
 */
@Service
public class ParticipantServiceImpl implements ParticipantService {

    @Autowired
    private ParticipantRepository repository;

    @Override
    public List<ParticipantDTO> pendingGroupByTournament(long tournamentId) {
        return new ArrayList<>();
        // return repository.pendingForGroupByTournament(tournamentId).stream().map(Participant::toDTO).collect(Collectors.toList());
    }

}
