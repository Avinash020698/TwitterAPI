package TwitterPostMethods;

import org.testng.annotations.Test;

import Config.PropertiesFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;

@Test
public class PostTweet {
	
	public void postTweet() throws Exception {
		
		PropertiesFile propFile= new PropertiesFile();
		
		String consumerKey= propFile.getProperties("consumerKey");
		String consumerSecret= propFile.getProperties("consumerSecret");
		String accessToken= propFile.getProperties("accessToken");
		String tokenSecret= propFile.getProperties("tokenSecret");
		
		Response response=RestAssured.given()
		.auth()
		.oauth(consumerKey, consumerSecret,accessToken,tokenSecret)
		.post("https://api.twitter.com/1.1/statuses/update.json?status=1st Tweet via RestAssured API");
		
		System.out.println(response.getStatusCode());
		
	}

}

