package by.bsac.pz5.chainofresponsibility;

public abstract class AbstractHandler {
	protected AbstractHandler nextHandler;
	
	public void setNextHandler(AbstractHandler nextHandler) {
		this.nextHandler = nextHandler;
	}
	
	public boolean handle(SampleContext context) {
		boolean processedChain = process(context);
		
		if (processedChain && nextHandler != null) {
			processedChain = nextHandler.handle(context);
		}
		
		return processedChain;
	}
	
	abstract protected boolean process(SampleContext context);
}
