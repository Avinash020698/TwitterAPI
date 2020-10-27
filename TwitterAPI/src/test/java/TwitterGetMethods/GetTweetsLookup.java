package TwitterGetMethods;

import org.testng.annotations.Test;

import Config.PropertiesFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;

@Test
public class GetTweetsLookup {
	
	public void tweetsLookup() throws Exception {
		
		PropertiesFile propFile= new PropertiesFile();

		String consumerKey= propFile.getProperties("consumerKey");
		String consumerSecret= propFile.getProperties("consumerSecret");
		String accessToken= propFile.getProperties("accessToken");
		String tokenSecret= propFile.getProperties("tokenSecret");

		Response response=RestAssured.given()
				.auth()
				.oauth(consumerKey, consumerSecret,accessToken,tokenSecret)
				.get("https://api.twitter.com/1.1/statuses/lookup.json?id=1320991823091822593,1320985462975066132");
		
		System.out.println(response.getBody().jsonPath().prettify());
		
	}

}
