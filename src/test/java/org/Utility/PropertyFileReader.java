package org.Utility;

import java.io.IOException;
import java.util.Properties;





public class PropertyFileReader {

	String browser_name;
	String url_name;
	private static PropertyFileReader propertyFileReader_inst;

	private PropertyFileReader() {

	}

	public static PropertyFileReader inst() {
		if (propertyFileReader_inst == null) {
			propertyFileReader_inst = new PropertyFileReader();
		}

		return propertyFileReader_inst;
	}
	
	public void prop_Reader() {
		Properties p= new Properties();
		try {
			p.load(getClass().getResourceAsStream("/propertyfile/GlobalProperties.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		browser_name = p.getProperty("browser");
		url_name = p.getProperty("url");


	}
}
