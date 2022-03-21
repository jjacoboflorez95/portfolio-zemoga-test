package co.com.zemoga.portafolio.controller;

import co.com.zemoga.portafolio.dto.TwitterUserDataFinalDto;
import co.com.zemoga.portafolio.dto.TweetsUserDto;
import co.com.zemoga.portafolio.util.Constants;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

/**
 * Controller to manage the twitter endpoints.
 * @author jacoboflorez
 */
@RestController
@CrossOrigin
@RequestMapping(value="/twitter")
public class TwitterController {

    /**
     * Endpoint to consume the twitter apirest that brings the twitter user data.
     * @param username Twitter username of an specific person.
     * @return Twitter user data.
     * @author jacoboflorez
     */
    @GetMapping("/getdatauser/{username}")
    public ResponseEntity<TwitterUserDataFinalDto> getDataUserTwitter(@PathVariable String username) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + Constants.BEARER_TOKEN);

        HttpEntity<String> request = new HttpEntity<>(headers);

        String url = "https://api.twitter.com/2/users/by/username/" + username;
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<TwitterUserDataFinalDto> data = restTemplate.exchange(url, HttpMethod.GET, request, TwitterUserDataFinalDto.class);
        return ResponseEntity.ok(Objects.requireNonNull(data.getBody()));
    }

    /**
     * Endpoint to consume the twitter apirest that brings the user's tweets.
     * @param username Twitter username of an specific person.
     * @return User's tweets.
     */
    @GetMapping("/getusertweets/{username}")
    public ResponseEntity<TweetsUserDto> getUserTweetsTwitter(@PathVariable String username) {
        ResponseEntity<TwitterUserDataFinalDto> twitterUserDataFinalDto = this.getDataUserTwitter(username);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + Constants.BEARER_TOKEN);

        HttpEntity<String> request = new HttpEntity<>(headers);

        String url = "https://api.twitter.com/2/users/ " + twitterUserDataFinalDto.getBody().getData().getId() + "/tweets";
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<TweetsUserDto> data = restTemplate.exchange(url, HttpMethod.GET, request, TweetsUserDto.class);
        return ResponseEntity.ok(Objects.requireNonNull(data.getBody()));
    }
}
