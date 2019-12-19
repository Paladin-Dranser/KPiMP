package by.bsac.pz5.factory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLoggerImpl implements ILogger {

	@Override
	public void debug(String msg) {
		try {
			File file = new File("DebugLog.log");
			
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fileWriter = new FileWriter(file.getName(), true);
			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
			bufferWriter.write("DEBUG: " + msg);
			bufferWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void error(String msg) {
		try {
			File file = new File("ErrorLog.log");
			
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fileWriter = new FileWriter(file.getName(), true);
			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
			bufferWriter.write("ERROR: " + msg);
			bufferWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
