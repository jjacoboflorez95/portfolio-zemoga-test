package co.com.zemoga.portafolio.repository;

import co.com.zemoga.portafolio.domain.PortfolioEntity;
import co.com.zemoga.portafolio.dto.ProfileInformationOutDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository to manage the zemoga_test_db.portfolio querys.
 * @author jacoboflorez
 */
@Repository
public interface PortfolioRepository extends JpaRepository<PortfolioEntity, Integer> {

    /**
     * Query to get the profile information.
     * @param email Twitter user's email.
     * @return Profile information
     * @author jacoboflorez
     */
    @Query(value = "select " +
            "p.image_path as imagePath, " +
            "p.names as names, " +
            "p.name as fullName, " +
            "p.experience_summary as workExperience, " +
            "p.twitter_user as twitterUser " +
            "from zemoga_test_db.portfolio p " +
            "where p.email = :email", nativeQuery = true)
    ProfileInformationOutDto findProfileInformation(@Param("email") String email);

    /**
     * Query to get the information by an specific email.
     * @param email Twitter user's email.
     * @return
     * @author jacoboflorez
     */
    PortfolioEntity findByEmail(String email);
}
