package co.com.zemoga.portafolio;

import co.com.zemoga.portafolio.dto.MessageOutDto;
import co.com.zemoga.portafolio.dto.ProfileInformationInDto;
import co.com.zemoga.portafolio.repository.PortfolioRepository;
import co.com.zemoga.portafolio.service.ProfileInformationServiceImpl;
import co.com.zemoga.portafolio.util.ElementNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@SpringBootTest
class PortafolioApplicationTests {

	@InjectMocks
	ProfileInformationServiceImpl profileInformationService;

	@Mock
	PortfolioRepository portfolioRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void emailNotFound() throws ElementNotFoundException {
		ProfileInformationInDto profileInformationInDto = new ProfileInformationInDto();
		profileInformationInDto.setNames("Connor");
		profileInformationInDto.setLastNames("Detroit");
		profileInformationInDto.setName("Connor Detroit");
		profileInformationInDto.setWorkExperience("The agent sent by Cyberlife for 15 years");

		MessageOutDto messageOutDto = new MessageOutDto();
		messageOutDto.setError(true);
		messageOutDto.setAnswerDescription("No email was sent, which is necessary to perform the update. Please check it.");

		try {
			profileInformationService.updateProfileInformation(profileInformationInDto);
		} catch (ElementNotFoundException e){
			assertThat(e.getMessage()).isEqualTo(messageOutDto.getAnswerDescription());
		} catch (Exception e){
			System.out.println("Error: " + e);
			fail("Unexpected exception");
		}
	}

	@Test
	void registerPortafolioEntityNotFound(){
		ProfileInformationInDto profileInformationInDto = new ProfileInformationInDto();
		profileInformationInDto.setNames("Connor");
		profileInformationInDto.setLastNames("Detroit");
		profileInformationInDto.setName("Connor Detroit");
		profileInformationInDto.setWorkExperience("The agent sent by Cyberlife for 15 years");
		profileInformationInDto.setEmail("aloy@gmail.comm");

		MessageOutDto messageOutDto = new MessageOutDto();
		messageOutDto.setError(true);
		messageOutDto.setAnswerDescription("No user was found with email: " + profileInformationInDto.getEmail());

		try {
			Mockito.when(portfolioRepository.findByEmail(profileInformationInDto.getEmail())).thenReturn(null);
			profileInformationService.updateProfileInformation(profileInformationInDto);
		} catch (ElementNotFoundException e){
			assertThat(e.getMessage()).isEqualTo(messageOutDto.getAnswerDescription());
		} catch (Exception e){
			System.out.println("Error: " + e);
			fail("Unexpected exception");
		}
	}

}
