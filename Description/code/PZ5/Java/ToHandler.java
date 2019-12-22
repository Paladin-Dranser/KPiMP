package by.bsac.pz5.chainofresponsibility;

public class ToHandler extends AbstractHandler {
	private String validTo = "support";
	
	@Override
	protected boolean process(SampleContext context) {
		boolean result = validTo.equalsIgnoreCase(context.getTo());
		System.out.println(this.getClass() + ": result = " + result);
		
		return result;
	}
}
