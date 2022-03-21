import { Injectable } from '@angular/core';

/**
 * Author: jacoboflorez
 * Class to manage the global data to use all over the project.
 */
@Injectable({
  providedIn: 'root'
})
export class GlobalDataService {

  /**
    * Global variable that will save the twitter user's email.
    */
  email: string;

  constructor() { 
    this.email = "aloy@gmail.com";    
  }

  getEmail(): string {
    return this.email;
  }

  setEmail(email: string) {
    this.email = email;
  }
}
