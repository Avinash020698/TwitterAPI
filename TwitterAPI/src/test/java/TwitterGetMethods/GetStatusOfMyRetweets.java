package TwitterGetMethods;

import org.testng.annotations.Test;

import Config.PropertiesFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;

@Test
public class GetStatusOfMyRetweets {
	
	public void myRetweets() throws Exception {
		
		PropertiesFile propFile= new PropertiesFile();

		String consumerKey= propFile.getProperties("consumerKey");
		String consumerSecret= propFile.getProperties("consumerSecret");
		String accessToken= propFile.getProperties("accessToken");
		String tokenSecret= propFile.getProperties("tokenSecret");

		Response response=RestAssured.given()
				.auth()
				.oauth(consumerKey, consumerSecret,accessToken,tokenSecret)
				.get("https://api.twitter.com/1.1/statuses/retweets_of_me.json?count=5");
		
		System.out.println(response.getBody().jsonPath().prettify());
		
	}

}
