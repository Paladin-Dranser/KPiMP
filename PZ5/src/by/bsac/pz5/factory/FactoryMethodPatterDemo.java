package by.bsac.pz5.factory;

public class FactoryMethodPatterDemo {
	public static void main(String args[]) {
		Factory f = new Factory();
		ILogger msgLogger = f.getLogger();
		
		msgLogger.debug("Sample degub message\n");
		msgLogger.error("Sample error message\n");
	}
}
