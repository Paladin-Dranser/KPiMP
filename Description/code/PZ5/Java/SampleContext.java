package by.bsac.pz5.chainofresponsibility;

public class SampleContext {
	public String from;
	public String to;
	public int priority;
	public String msg;
	
	public SampleContext(String from, String to, int priority, String msg) {
		this.from = from;
		this.to = to;
		this.priority = priority;
		this.msg = msg;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
