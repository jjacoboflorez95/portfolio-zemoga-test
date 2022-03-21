package co.com.zemoga.portafolio.service;

import co.com.zemoga.portafolio.dto.MessageOutDto;
import co.com.zemoga.portafolio.dto.ProfileInformationInDto;
import co.com.zemoga.portafolio.dto.ProfileInformationOutDto;
import co.com.zemoga.portafolio.util.ElementNotFoundException;

/**
 * Service interface to manage the functions related with the profile information.
 * @author jacoboflorez
 */
public interface ProfileInformationService {

    /**
     * Function declaration to get the profile information of an specific user.
     * @param email Twitter user's email.
     * @return Profile information
     * @author jacoboflorez
     */
    ProfileInformationOutDto getProfileInformation(String email);

    /**
     * Function declaration to update the profile information of an specific user.
     * @param profileInformationInDto Dto with the information to update.
     * @return Confirmation/Error message
     * @author jacoboflorez
     */
    MessageOutDto updateProfileInformation(ProfileInformationInDto profileInformationInDto) throws ElementNotFoundException;
}
