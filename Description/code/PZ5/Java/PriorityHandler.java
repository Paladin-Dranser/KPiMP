package by.bsac.pz5.chainofresponsibility;

public class PriorityHandler extends AbstractHandler {
	private int priorityLevel = 10;
	
	@Override
	protected boolean process(SampleContext context) {
		boolean result = context.getPriority() < priorityLevel;
		System.out.println(this.getClass() + ": result = " + result);
		
		return result;
	}
}
