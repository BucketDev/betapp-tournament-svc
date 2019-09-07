package com.bucketdev.betapptournamentsvc.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author rodrigo.loyola
 */
@Getter
@Setter
public class TournamentParticipantsDTO implements Serializable {

    private long id;
    private String uid;
    private String title;
    private String photoUrl;
    private Date creationDate;
    private long userCreationId;
    private boolean userWinner;
    private long participantsNumber;

}
