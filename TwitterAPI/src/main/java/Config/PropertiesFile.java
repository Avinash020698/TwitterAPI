package Config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesFile {
	
     String projectPath;

	public  String getProperties(String value) throws Exception {
		
		Properties prop= new Properties();
		projectPath = System.getProperty("user.dir");
		InputStream input= new FileInputStream(projectPath +"/src/test/resources/Config/Tokens&Keys.properties");
		prop.load(input);
		String propValue = prop.getProperty(value);
		return propValue;
		
	}
	
}
