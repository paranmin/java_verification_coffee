package kr.or.dgit.java_verification_coffee.jdbc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {
	private static final LoadProperties instance = new LoadProperties();
	private Properties properties;
	
	public static LoadProperties getInstance() {
		return instance;
	}

	private LoadProperties() {
		properties = new Properties();
		configAsProperties();
	}

	private void configAsProperties() {
		ClassLoader context = Thread.currentThread().getContextClassLoader();
		
		InputStream inputStream = context.getResourceAsStream("application.properties");
		try {
			properties.load(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Properties getProperties() {
		return properties;
	}
}
