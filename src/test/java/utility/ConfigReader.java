package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	
	
	public String readConfigFile(String value) throws IOException
	{
		Properties properties = new Properties();
		String file = "config.properties"; 
		InputStream inputstream = getClass().getClassLoader().getResourceAsStream(file); 
		properties.load(inputstream); 
		
		String v= properties.getProperty(value);
		
		System.out.println(v);
		
return v;
		
		
	}
	
	public String readConfig(String valuetoread) throws IOException
	{
String path = System.getProperty("user.dir")+"\\src\\test\\java\\configs\\config.properties";
		
		FileInputStream fis = new FileInputStream(path);
		
		Properties prop = new Properties();
		
		prop.load(fis);
		
		String value = prop.getProperty(valuetoread);
		
		System.out.println(value);
		
		return value;
	}
	
	public static void main(String[] args) throws IOException {
		
		String path = System.getProperty("user.dir")+"//src//test//resources//Config.properties";
		
		FileInputStream fis = new FileInputStream(path);
		
		Properties prop = new Properties();
		
		prop.load(fis);
		
		String value = prop.getProperty("testsiteurl");
		
		System.out.println(value);
		
		
		
	}

}
