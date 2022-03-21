# README.MD
Project that manage the data of a portfolio page.

## Content
This project content the backend and frontend part to manage the porfolio page.

## What is my register on the DB
The register that I created to work with was the one with id "114" and email "aloy@gmail.com"

## How to clone
Open a cmd in the location that you want to clone your projects, then type
```bash
git clone <https url of the git project>
```

## Installation
To install the frontend libraries, please open the project "portfolio-frontend", then open a terminal and type
```bash
npm install
```

To ensure the proper function of the backend, please open the project "portfolio-backend", then open a terminal and type
```bash
mvn clean install
```

## How to run the backend
Open the project "portfolio-backend", then located the class "PortafolioApplication" where you can find the main of the project.

The project will start in the port: 8085 (If you want to change the port, you can do it in the "application.properties" file)

You can find the context-path in the "application.properties" file

## How to run the frontend
Open the project "portfolio-frontend", then open a terminal and type 
```bash
npm start
```
Then open your web browser and type the following to see the frontend
```bash
http://localhost:4200
```

## How to consume endpoints on Postman
1. For the get endpoint that recover the profile information, you need to type the url
```bash
http://localhost:8085/zemoga/portfolio/profileinformation/:email
```
2. For the put endpoint that update the profile information, you need to type
```bash
http://localhost:8085/zemoga/portfolio/profileinformation
```
and this is an example of the body that you need to create
```bash
{
"names":"Connor",
"lastNames":"Detroit",
"name":"Connor Detroit",
"workExperience":"The agent sent by Cyberlife for 15 years",
"email":"aloy@gmail.com"
}
```
3. For the get endpoint that recover the twitter user data, you need to type
```bash
http://localhost:8085/zemoga/portfolio/twitter/getdatauser/:username
```
4. For the get endpoint that recover the twitter user's tweets, you need to type
```bash
http://localhost:8085/zemoga/portfolio/twitter/getusertweets/:twitterUserId
```

## Technologies used
* Java
* MySQL
* Git
* Angular
* TypeScript
* HTML
* CSS
* Bootstrap

## Total time to complete the project
* 23 hours
* The part that took me the most time was to find the way to consume and call correctly the twitter api and to tried to create a decent frontend to show all the information.
* For the twitter API: Consume the API on PostMan was easy, then I began to tried to consume it inside my code. First I read that the best way to consume an external api was on the frontend part, but I couldn't manage the header correctly to pass the Bearer Token, so at the end I decided to discard that idea and tried to consume the api on the backend part and it was easier, so I finally could consume the api correctly inside my code.

### Notes
* If you use the endpoint that update the profile information and want to recover the original one, you can type this update sentence
```bash
update zemoga_test_db.portfolio 
set names = 'Aloy', last_names = 'Hoekstra', name = 'Aloy Hoekstra', experience_summary = 'I have been training my hole life, since I was a kid, my caretaker, Rost, taught me how to fight, how to stay one step ahead of machines in order to deal with them. I am very capable to accomplishing differents goals either with a team or alone.'
where email = 'aloy@gmail.com';
```
* In the frontend, I chose and image, then I removed its background, but for some reasons, when I show the image in the web browser, it appears with a white background.
