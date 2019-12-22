package by.bsac.pz5.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Factory {
	public ILogger getLogger() {
		if (isFileLoggingEnabled()) {
			return new FileLoggerImpl();
		} else {
			return new ConsoleLoggerImpl();
		}
	}
	
	private boolean isFileLoggingEnabled() {
		Properties p = new Properties();
		
		try {
			InputStream input = new FileInputStream("logger.properties");
			p.load(input);
			String fileLoggingValue = p.getProperty("FileLogging");
			
			if ("true".equalsIgnoreCase(fileLoggingValue)) {
				return true;
			} else {
				return false;
			}
		} catch (IOException e) {
			return false;
		}
	}
}
