package compiler.data;

public class Flow {
	private State start;

	public State getStart() {
		return start;
	}

	public void setStart(State state) {
		this.start= state;
	}

	@Override
	public String toString() {
		String result = "-Test Code Generator\n\n";
		result += "Start:\n";
		result += start+"\n";
		return result;
	}
}
