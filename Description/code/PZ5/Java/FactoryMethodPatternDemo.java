package by.bsac.pz5.factory;

public class FactoryMethodPatternDemo {
	
	public static void main(String args[]) throws InterruptedException {
		Factory f = new Factory();
		ILogger msgLogger = f.getLogger();
		
		for (int i = 0; i < 6; i++) {
			msgLogger.debug("Sample degub message\n");
			Thread.sleep(1000);
		}
		
		msgLogger.error("Sample error message\n");
	}
}
