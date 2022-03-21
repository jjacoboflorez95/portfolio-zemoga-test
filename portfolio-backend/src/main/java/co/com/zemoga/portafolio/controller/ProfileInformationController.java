package co.com.zemoga.portafolio.controller;

import co.com.zemoga.portafolio.dto.MessageOutDto;
import co.com.zemoga.portafolio.dto.ProfileInformationInDto;
import co.com.zemoga.portafolio.dto.ProfileInformationOutDto;
import co.com.zemoga.portafolio.service.ProfileInformationService;
import co.com.zemoga.portafolio.util.ElementNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller to manage the profile information endpoints.
 * @author jacoboflorez
 */
@RestController
@CrossOrigin
@RequestMapping(value="/profileinformation")
public class ProfileInformationController {

    @Autowired
    private ProfileInformationService profileInformationService;

    /**
     * Endpoint to get the profile information of an specific user.
     * @param email Twitter user's email.
     * @return Profile information.
     * @author jacoboflorez
     */
    @GetMapping("/{email}")
    public ResponseEntity<ProfileInformationOutDto> getProfileInformation(@PathVariable String email) {
        return ResponseEntity.ok(profileInformationService.getProfileInformation(email));
    }

    /**
     * Endpoint to update the profile information of an specific user.
     * @param profileInformationInDto Dto with the information to update.
     * @return Successful/Error message
     * @author jacoboflorez
     */
    @PutMapping
    public ResponseEntity<MessageOutDto> updateProfileInformation(@RequestBody ProfileInformationInDto profileInformationInDto) throws ElementNotFoundException {
        return ResponseEntity.ok(profileInformationService.updateProfileInformation(profileInformationInDto));
    }
}
