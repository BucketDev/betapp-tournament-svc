package com.bucketdev.betapptournamentsvc.repository;

import com.bucketdev.betapptournamentsvc.domain.TournamentParticipants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author rodrigo.loyola
 */
@Repository
public interface TournamentParticipantsRepository extends JpaRepository<TournamentParticipants, Long> {

    @Query("SELECT tp FROM TournamentParticipants tp JOIN tp.participants p WHERE :uid IN p.uid")
    Page<TournamentParticipants> findByParticipantUid(Pageable page, @Param("uid") String uid);

}
