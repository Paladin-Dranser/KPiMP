package by.bsac.pz5.chainofresponsibility;

public class ChainPatternDemo {
	private static AbstractHandler getChainOfLoggers() {
		AbstractHandler initiatorHandler = new InitiatorHandler();
		AbstractHandler toHandler = new ToHandler();
		AbstractHandler priorityHandler = new PriorityHandler();
		
		priorityHandler.setNextHandler(initiatorHandler);
		initiatorHandler.setNextHandler(toHandler);
		
		return priorityHandler;
	}
	
	public static void main(String[] args) {
		SampleContext context = new SampleContext("boss", "support", 11, "Fix");
		
		AbstractHandler handlerChain = getChainOfLoggers();
		boolean validContext = handlerChain.handle(context);
		
		if (validContext) {
			System.out.println(context.msg);
		}
	}
}
