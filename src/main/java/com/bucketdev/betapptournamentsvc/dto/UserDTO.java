package com.bucketdev.betapptournamentsvc.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author rodrigo.loyola
 */
@Data
public class UserDTO implements Serializable {

    private long id;
    private String uid;
    private String displayName;
    private String photoUrl;

}
