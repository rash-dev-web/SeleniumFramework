package com.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestLog {

	File file;
	FileInputStream fis;
	Properties pro;
	public void logFile(){
		file=new File("C:\\Users\\Rasheed\\workspace\\framework\\src\\main\\java\\com\\qa\\config\\Log4j.properties");
		try {
			fis=new FileInputStream(file);
			pro.load(fis);
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
	}
}
