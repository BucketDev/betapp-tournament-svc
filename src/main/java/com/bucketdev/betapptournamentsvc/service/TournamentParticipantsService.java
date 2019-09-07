package com.bucketdev.betapptournamentsvc.service;

import com.bucketdev.betapptournamentsvc.dto.TournamentParticipantsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author rodrigo.loyola
 */
public interface TournamentParticipantsService {

    Page<TournamentParticipantsDTO> findByParticipantUid(Pageable page, String uid);

}
