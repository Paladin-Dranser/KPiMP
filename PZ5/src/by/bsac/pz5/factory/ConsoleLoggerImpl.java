package by.bsac.pz5.factory;

public class ConsoleLoggerImpl implements ILogger {
	
	ConsoleLoggerImpl() {}

	@Override
	public void debug(String msg) {
		System.out.println("DEBU:" + msg);
	}

	@Override
	public void error(String msg) {
			System.err.println("ERROR: " + msg);
	}

}
