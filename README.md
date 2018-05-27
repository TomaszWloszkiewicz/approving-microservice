# approving-microservice
Repository contain simple microservice for approving movies reviews. It is connected with movies-microservice.

**Get review**
* *URL:*
  _/reviews/{id}_

* *Method:*
  `GET`

**Update review**
* *URL:*
  _/movies/{id}_

* *Method:*
  `PUT`
  
* *RequestBody:*
_{
    "reviewContent": "I loved this movie. The visuals were incredible, and the story was creative sci-fi adventure.",
    "rating": 8,
    "userName": "Leonardo",
    "movieId": "5b0a062cbe901315406927ed"
}_

   *Required:* 
   
	`reviewContent=[String]` - Conent must have at least 10 characters up to 250.

	`rating=[Double]` - Rating should be between 1 and 10. 

	`userName=[String]` - Username must have at least 3 characters up to 15.

	`moveId=[String]`

**Delete review**
* *URL:*
  _/movies/{id}_

* *Method:*
  `DELETE`
  
**Get list of reviews**
* *URL:*
  _/movies_

* *Method:*
  `GET`
