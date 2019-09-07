package com.bucketdev.betapptournamentsvc.service.impl;

import com.bucketdev.betapptournamentsvc.domain.TournamentParticipants;
import com.bucketdev.betapptournamentsvc.dto.TournamentParticipantsDTO;
import com.bucketdev.betapptournamentsvc.repository.TournamentParticipantsRepository;
import com.bucketdev.betapptournamentsvc.service.TournamentParticipantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author rodrigo.loyola
 */
@Service
public class TournamentParticipantsServiceImpl implements TournamentParticipantsService {

    @Autowired
    private TournamentParticipantsRepository repository;

    @Override
    public Page<TournamentParticipantsDTO> findByParticipantUid(Pageable page, String uid) {
        return repository.findByParticipantUid(page, uid).map(TournamentParticipants::toDTO);
    }
}
