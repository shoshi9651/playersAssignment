# Players-Intuit-Assignment


<b>Introduction:</b><br/>
welcome to my players Application :)   
this application load data from csv resource file after the initialization of bean properties by @PostConstruct annotation & provides 2 endpoints .

<br/>
 <b>Project's technologies:<br/></b>
•	Java 17 <br/>
•	Maven 3.6.0 <br/>
•	Spring Boot, Spring web, Spring Data Jpa, 
Spring data rest<br/>
•	Mockito<br/>
•	Junit <br/>
•	H2database<br/>
•	opencsv<br/>

<br/>
<b>To run the application: </b><br/>
  Run Application (or <b>mvnw spring-boot:run</b> from the terminal) <br/>
  Run PlayersApplicationTests for run testing (or <b>mvn test</b> from the terminal)<br/>
 <br/>
<b>Player rest controller implements api :</b>

1.	getAllPlayer
	<br/> <b> Get:</b> http://localhost:8080/api/players
 <br/><b> response: (Status 200.ok) </b>
  ```
  [{"playerID":"aardsda01","birthYear":"1981","birthMonth":"12","birthDay":"27","birthCountry":"USA","birthState":"CO","birthCity":"Denver","deathYear":"","deathMonth":"","deathDay":"","deathCountry":"","deathState":"","deathCity":"","nameFirst":"David","nameLast":"Aardsma","nameGiven":"David Allan","weight":"215","height":"75","bats":"R","throwsType":"R","debut":"2004-04-06","finalGame":"2015-08-23","retroID":"aardd001","bbrefID":"aardsda01"},{"playerID":"aaronha01","birthYear":"1934","birthMonth":"2","birthDay":"5","birthCountry":"USA","birthState":"AL","birthCity":"Mobile","deathYear":"","deathMonth":"","deathDay":"","deathCountry":"","deathState":"","deathCity":"","nameFirst":"Hank","nameLast":"Aaron","nameGiven":"Henry Louis","weight":"180","height":"72","bats":"R","throwsType":"R","debut":"1954-04-13","finalGame":"1976-10-03","retroID":"aaroh101","bbrefID":"aaronha01"}, 
   -- and all players .. 
```
2.getPlayerById  
	<br/> <b> Get:</b> http://localhost:8080/api/players/aardsda01
 <br/><b> exist player -  response: (Status 200.ok) </b>
  ``` {"playerID":"aardsda01","birthYear":"1981","birthMonth":"12","birthDay":"27","birthCountry":"USA","birthState":"CO","birthCity":"Denver","deathYear":"",
  "deathMonth":"","deathDay":"","deathCountry":"","deathState":"","deathCity":"","nameFirst":"David","nameLast":"Aardsma","nameGiven":"David Allan","weight":"215","height":"75","bats":"R","throwsType":"R","debut":"2004-04-06","finalGame":"2015-08-23","retroID":"aardd001","bbrefID":"aardsda01"}
  ```
  <br/><b>not exist player -  Response: (Status 400.Not Found) </b>
<br/>
<br/>
3.getAllPlayer (By page and size per page)
	<br/> <b> Get:</b> http://localhost:8080/api/players?page=5&size=3
 <br/><b> correct -  response: (Status 200.ok) </b>
  ```[{"playerID":"abbotgl01","birthYear":"1951","birthMonth":"2","birthDay":"16","birthCountry":"USA","birthState":"AR","birthCity":"Little Rock","deathYear":"","deathMonth":"","deathDay":"","deathCountry":"","deathState":"","deathCity":"","nameFirst":"Glenn","nameLast":"Abbott","nameGiven":"William Glenn","weight":"200","height":"78","bats":"R","throwsType":"R","debut":"1973-07-29","finalGame":"1984-08-08","retroID":"abbog001","bbrefID":"abbotgl01"},{"playerID":"abbotje01","birthYear":"1972","birthMonth":"8","birthDay":"17","birthCountry":"USA","birthState":"GA","birthCity":"Atlanta","deathYear":"","deathMonth":"","deathDay":"","deathCountry":"","deathState":"","deathCity":"","nameFirst":"Jeff","nameLast":"Abbott","nameGiven":"Jeffrey William","weight":"190","height":"74","bats":"R","throwsType":"L","debut":"1997-06-10","finalGame":"2001-09-29","retroID":"abboj002","bbrefID":"abbotje01"},{"playerID":"abbotji01","birthYear":"1967","birthMonth":"9","birthDay":"19","birthCountry":"USA","birthState":"MI","birthCity":"Flint","deathYear":"","deathMonth":"","deathDay":"","deathCountry":"","deathState":"","deathCity":"","nameFirst":"Jim","nameLast":"Abbott","nameGiven":"James Anthony","weight":"200","height":"75","bats":"L","throwsType":"L","debut":"1989-04-08","finalGame":"1999-07-21","retroID":"abboj001","bbrefID":"abbotji01"}]```
  <br/><b>wrong page or size (not more than 0) -  Response: (Status 400.Not Found) </b>

<b>What's Next? </b><br/>
• Change db to Sql db like My Sql .<br/>
• Add Swagger for all endpoints.<br/>
