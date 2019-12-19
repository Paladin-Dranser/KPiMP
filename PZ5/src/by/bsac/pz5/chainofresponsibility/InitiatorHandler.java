package by.bsac.pz5.chainofresponsibility;

public class InitiatorHandler extends AbstractHandler {
	private String initiator = "boss";
	
	@Override
	protected boolean process(SampleContext context) {
		boolean result = context.getFrom().equalsIgnoreCase(initiator);
		System.out.println(this.getClass() + ": result = " + result);
		
		return result;
	}
}
