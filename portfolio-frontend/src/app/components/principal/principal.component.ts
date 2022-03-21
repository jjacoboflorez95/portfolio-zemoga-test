import { Component, OnInit } from '@angular/core';
import { ProfileInformation } from 'src/app/models/profile-information.model';
import { TweetsUser } from 'src/app/models/tweets-user.model';
import { TwitterUserDataFinal } from 'src/app/models/twitter-user-data-final.model';
import { ApirestProfileService } from 'src/app/services/apirest-profile.service';
import { GlobalDataService } from 'src/app/services/global-data.service';

/**
 * Author: jacoboflorez
 * Class to manage the different function of the profile information.
 */
@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.css']
})
export class PrincipalComponent implements OnInit {

  /**
    * Global variable that will save the profile information.
    */
  profileInformation!: ProfileInformation;

  /**
    * Global variable that will save the twitter user data.
    */
  twitterUserData!: TwitterUserDataFinal;

  /**
    * Global variable that will save the user's tweets.
    */
  tweetsUser!: TweetsUser;

  constructor(protected apirestProfileService: ApirestProfileService, protected globalDataService: GlobalDataService) { }

  ngOnInit(): void {
    this.getProfileInformation(this.globalDataService.email);
    this.getTwitterUserTweets(this.globalDataService.username);
  }

  /**
   * Function that call the apirest service in charge of getting the profile information.
   */
  getProfileInformation(email: string) {
    console.log("Function getProfileInformation()");
    this.apirestProfileService.getProfileInformation(email)
      .subscribe(
        (data) => { // Success          
          if (data.length != 0) {
            this.profileInformation = data;
            console.log("profileInformation:", this.profileInformation);
          } else {
            console.log("Profile information empty. Please check it.");
          }
        },
        (error) => {
          console.log("Error susbscribe getProfileInformation");
          console.error(error);
        }
      );
  }

  /**
   * Function that call the apirest service in charge of getting the user's tweets.
   */
  getTwitterUserTweets(username: string) {
    console.log("Function getTwitterUserTweets()");      
    this.apirestProfileService.getTwitterUserTweets(username)
      .subscribe(
        (data) => { // Success
          if (data.length != 0) {
            this.tweetsUser = data;
            console.log("tweetsUser: ", this.tweetsUser);
          } else {
            console.log("Twitter user not found. Please check it.");
          }
        },
        (error) => {
          console.log("Error susbscribe getTwitterUserData");
          console.error(error);
        }
      );
  }
}
