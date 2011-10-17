package compiler.data;

public class Transition {
	protected State to;
	protected Referencable using;
	protected String delay;

	public Transition(State to, Referencable using, String delay) {
		super();
		this.to = to;
		this.using = using;
		this.delay = delay;
	}

	public String getDelay() {
		return delay;
	}

	public State getTo() {
		return to;
	}

	public Referencable getUsing() {
		return using;
	}
}
