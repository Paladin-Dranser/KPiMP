package by.bsac.pz5.factory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLoggerImpl implements ILogger {
	private static int count = 0;
	private static StringBuilder bufferString = new StringBuilder("");

	@Override
	public void debug(String msg) {
		try {
			if (count < 5) {
				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				String strDate = formatter.format(date);
				
				bufferString.append("[" + strDate + "] DEBUG: " + String.valueOf(count) + msg);
				
				count++;
			} else {
				File file = new File("DebugLog.log");
				
				if (!file.exists()) {
					file.createNewFile();
				}
				
				FileWriter fileWriter = new FileWriter(file.getName(), true);
				BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
				bufferWriter.write(bufferString.toString());
				bufferWriter.close();
				count = 0;
				bufferString = new StringBuilder("");
			}
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
