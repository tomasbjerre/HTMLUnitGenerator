package compiler.data;

public class Transition {
	protected State to;
	protected Referencable using;

	public Transition(State to, Referencable using) {
		super();
		this.to = to;
		this.using = using;
	}

	public State getTo() {
		return to;
	}

	public Referencable getUsing() {
		return using;
	}

	@Override
	public String toString() {
		String result = "-Transition\n";
		result += "To:" + to + "\n";
		result += "Using:" + using + "\n";
		return result;
	}
}
