package co.com.zemoga.portafolio.service;

import co.com.zemoga.portafolio.domain.PortfolioEntity;
import co.com.zemoga.portafolio.dto.MessageOutDto;
import co.com.zemoga.portafolio.dto.ProfileInformationInDto;
import co.com.zemoga.portafolio.dto.ProfileInformationOutDto;
import co.com.zemoga.portafolio.repository.PortfolioRepository;
import co.com.zemoga.portafolio.util.ElementNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service to manage the functions related with the profile information.
 * @author jacoboflorez
 */
@Slf4j
@Service
public class ProfileInformationServiceImpl implements ProfileInformationService{

    @Autowired
    PortfolioRepository portfolioRepository;

    /**
     * Function to get the profile information of an specific user.
     * @param email Twitter user's email.
     * @return Profile information
     * @author jacoboflorez
     */
    public ProfileInformationOutDto getProfileInformation(String email){
        log.info("Function to get the profile information - Email sent: " + email);
        return portfolioRepository.findProfileInformation(email);
    }

    /**
     * Function to update the profile information of an specific user.
     * @param profileInformationInDto Dto with the information to update.
     * @return Confirmation/Error message
     * @author jacoboflorez
     */
    public MessageOutDto updateProfileInformation(ProfileInformationInDto profileInformationInDto) throws ElementNotFoundException {
        log.info("Function to update the user's information.");
        MessageOutDto messageOutDto = new MessageOutDto();

        if(profileInformationInDto.getEmail() == null || profileInformationInDto.getEmail().trim().isEmpty()) {
            log.info("Log Error: No email was sent to perform the update.");
            throw new ElementNotFoundException("No email was sent, which is necessary to perform the update. Please check it.");
        }

        PortfolioEntity portfolioEntity = portfolioRepository.findByEmail(profileInformationInDto.getEmail());

        if(portfolioEntity == null){
            log.info("Log Error: No user was found with the email provided");
            throw new ElementNotFoundException("No user was found with email: " + profileInformationInDto.getEmail());
        }

        portfolioEntity.setNames(profileInformationInDto.getNames());
        portfolioEntity.setLastNames(profileInformationInDto.getLastNames());
        portfolioEntity.setName(profileInformationInDto.getName());
        portfolioEntity.setExperienceSummary(profileInformationInDto.getWorkExperience());
        portfolioRepository.save(portfolioEntity);

        log.info("User's information with email: " + profileInformationInDto.getEmail() + ", has been updated successfully.");
        messageOutDto.setError(false);
        messageOutDto.setAnswerDescription("User's information with email: " + profileInformationInDto.getEmail() + ", has been updated successfully.");
        return messageOutDto;
    }
}
