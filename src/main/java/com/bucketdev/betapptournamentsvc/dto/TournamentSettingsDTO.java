package com.bucketdev.betapptournamentsvc.dto;

import com.bucketdev.betapptournamentsvc.type.PlayoffStage;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author rodrigo.loyola
 */
@Getter
@Setter
public class TournamentSettingsDTO implements Serializable {

    private long id;
    private long tournamentId;
    private boolean groupRoundTrip;
    private boolean eightFinalsRoundTrip;
    private boolean quarterFinalsRoundTrip;
    private boolean semiFinalsRoundTrip;
    private boolean finalRoundTrip;
    private int groupNumber;
    private int first;
    private PlayoffStage playoffStage;

}
