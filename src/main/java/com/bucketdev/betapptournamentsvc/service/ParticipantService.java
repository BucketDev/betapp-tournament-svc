package com.bucketdev.betapptournamentsvc.service;

import com.bucketdev.betapptournamentsvc.dto.ParticipantDTO;

import java.util.List;

/**
 * @author rodrigo.loyola
 */
public interface ParticipantService {

    List<ParticipantDTO> pendingGroupByTournament(long tournamentId);

}
