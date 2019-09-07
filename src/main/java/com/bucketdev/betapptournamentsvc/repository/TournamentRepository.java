package com.bucketdev.betapptournamentsvc.repository;

import com.bucketdev.betapptournamentsvc.domain.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author rodrigo.loyola
 */
@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {

    Tournament findByUid(String uid);

}
