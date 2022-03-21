import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

/**
 * Author: jacoboflorez
 * Class to manage the consume of the apirest related with the profile information.
 */
@Injectable({
  providedIn: 'root'
})
export class ApirestProfileService {

  constructor(private http: HttpClient) { }

  /**
   * Function that consume the apirest that brings the profile information data.
   * @param email Receive the email of an specific person.
   * @returns Profile information.
   */
   getProfileInformation(email: string): Observable<any> {
    let url: string = "http://localhost:8085/zemoga/portfolio/profileinformation/" + email;
    return this.http.get(url);
  }

  /**
   * Function that consume the apirest that brings the user's tweets.
   * @param usernameId Receive the twitter user's id of an specific person.
   * @returns User's tweets.
   */
  getTwitterUserTweets(username: string): Observable<any>{
    let url: string = "http://localhost:8085/zemoga/portfolio/twitter/getusertweets/" + username;
    return this.http.get(url);
  }
}
