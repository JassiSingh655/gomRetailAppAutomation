package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigFileReader {
	
	private File file;
	private FileInputStream fis;
	private Properties properties;
	private String filePath = "./config/config.properties";

	/**
	 * This method is used to load properties
	 * @throws Exception
	 */
	public void loadProperties() throws Exception {
		file = new File(filePath);
		fis = new FileInputStream(file);
		properties = new Properties();
		properties.load(fis);
	}

	/**
	 * This method is used to get the value from properties file based on key
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public String getKey(String key) {
		try {
			loadProperties();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}

}
