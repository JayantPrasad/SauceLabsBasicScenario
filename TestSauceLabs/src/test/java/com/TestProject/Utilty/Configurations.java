package com.TestProject.Utilty;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class Configurations {

	public static String toGetProperty(String value) throws IOException {
		FileReader fr = new FileReader("C:\\Test\\TestSauceLabs\\TestData\\config.properties");
		Properties props = new Properties();
		props.load(fr);
		String reqValue=props.getProperty(value);
		fr.close();
		return reqValue;

	}
}
