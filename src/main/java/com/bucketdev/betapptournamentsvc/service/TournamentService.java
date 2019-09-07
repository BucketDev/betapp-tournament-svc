package com.bucketdev.betapptournamentsvc.service;

import com.bucketdev.betapptournamentsvc.dto.TournamentDTO;
import com.bucketdev.betapptournamentsvc.dto.UserDTO;

public interface TournamentService {

    TournamentDTO save(TournamentDTO dto);
    UserDTO addParticipant(long id, UserDTO userDTO);
    TournamentDTO updatePhotoUrl(long id, TournamentDTO dto);
    TournamentDTO updateTournamentStage(TournamentDTO dto);
    void deleteTournament(String uid);
}
