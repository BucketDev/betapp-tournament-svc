package com.bucketdev.betapptournamentsvc.service.impl;

import com.bucketdev.betapptournamentsvc.domain.Tournament;
import com.bucketdev.betapptournamentsvc.domain.TournamentSettings;
import com.bucketdev.betapptournamentsvc.dto.TournamentSettingsDTO;
import com.bucketdev.betapptournamentsvc.exception.tournament.TournamentNotFoundException;
import com.bucketdev.betapptournamentsvc.repository.TournamentRepository;
import com.bucketdev.betapptournamentsvc.repository.TournamentSettingsRepository;
import com.bucketdev.betapptournamentsvc.service.TournamentSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * @author rodrigo.loyola
 */
@Service
public class TournamentSettingsServiceImpl implements TournamentSettingsService {

    @Autowired
    private TournamentSettingsRepository repository;

    @Autowired
    private TournamentRepository tournamentRepository;

    /*@Autowired
    private GroupRepository groupRepository;*/

    @Override
    public TournamentSettingsDTO findByTournamentUid(String uid) {
        TournamentSettings tournamentSettings = repository.findByTournamentUid(uid);
        return tournamentSettings == null ? null : tournamentSettings.toDTO();
    }

    @Transactional
    @Override
    public TournamentSettingsDTO upsert(TournamentSettingsDTO dto) {
        Optional<Tournament> optionalTournament = tournamentRepository.findById(dto.getTournamentId());
        if (!optionalTournament.isPresent())
            throw new TournamentNotFoundException("id: " + dto.getTournamentId());
        Tournament tournament = optionalTournament.get();

        TournamentSettings tournamentSettings = repository.findByTournamentUid(tournament.getUid());
        if (tournamentSettings == null) {
            tournamentSettings = new TournamentSettings();
        }
        tournamentSettings.setTournament(tournament);
        tournamentSettings.setValuesFromDTO(dto);

        /*groupRepository.deleteByTournamentUid(tournament.getUid());
        int groupName = 65;

        if (tournament.isTournamentGroups()) {
            for (int i = 0; i < tournamentSettings.getGroupNumber(); i++) {
                Group group = new Group((char) groupName++);
                group.setTournament(tournament);
                groupRepository.save(group);
            }
        }
        generateFinalsGroups(tournamentSettings);*/

        return repository.save(tournamentSettings).toDTO();
    }

    /*@Override
    public void generateFinalsGroups(TournamentSettings tournamentSettings) {
        Tournament tournament = tournamentSettings.getTournament();
        switch (tournamentSettings.getPlayoffStage()) {
            case EIGHTH_FINALS:
                saveFinalsGroups(tournament, PlayoffStage.EIGHTH_FINALS, 8);
                saveFinalsGroups(tournament, PlayoffStage.QUARTER_FINALS, 4);
                saveFinalsGroups(tournament, PlayoffStage.SEMIFINALS, 2);
                saveFinalsGroups(tournament, PlayoffStage.FINALS, 1);
                break;
            case QUARTER_FINALS:
                saveFinalsGroups(tournament, PlayoffStage.QUARTER_FINALS, 4);
                saveFinalsGroups(tournament, PlayoffStage.SEMIFINALS, 2);
                saveFinalsGroups(tournament, PlayoffStage.FINALS, 1);
                break;
            case SEMIFINALS:
                saveFinalsGroups(tournament, PlayoffStage.SEMIFINALS, 2);
                saveFinalsGroups(tournament, PlayoffStage.FINALS, 1);
                break;
            case FINALS:
                saveFinalsGroups(tournament, PlayoffStage.FINALS, 1);
                break;
        }
    }

    private void saveFinalsGroups(Tournament tournament, PlayoffStage playoffStage, int groupsNumber) {
        int groupName = 65;
        for (int i = 0; i < groupsNumber; i++) {
            Group group = new Group((char) groupName++);
            group.setTournament(tournament);
            group.setPlayoffStage(playoffStage);
            groupRepository.save(group);
        }
    }*/
}
