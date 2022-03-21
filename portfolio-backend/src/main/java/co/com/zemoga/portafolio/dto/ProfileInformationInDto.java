package co.com.zemoga.portafolio.dto;

import lombok.Data;

/**
 * Dto to manage the profile information with the information to update.
 * @author jacoboflorez
 */
@Data
public class ProfileInformationInDto {

    private String names;

    private String lastNames;

    private String name;

    private String workExperience;

    private String email;
}
