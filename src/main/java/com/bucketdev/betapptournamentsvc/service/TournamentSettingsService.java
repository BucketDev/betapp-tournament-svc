package com.bucketdev.betapptournamentsvc.service;

import com.bucketdev.betapptournamentsvc.domain.TournamentSettings;
import com.bucketdev.betapptournamentsvc.dto.TournamentSettingsDTO;

/**
 * @author rodrigo.loyola
 */
public interface TournamentSettingsService {

    TournamentSettingsDTO findByTournamentUid(String uid);
    TournamentSettingsDTO upsert(TournamentSettingsDTO dto);
    // void generateFinalsGroups(TournamentSettings tournamentSettings);

}
