package compiler.data.flow;

import compiler.data.Referencable;
import compiler.data.State;

public class Transition extends compiler.data.Transition {
	public Transition(State to, Referencable using, String delay) {
		super(to, using, delay);
	}

	@Override
	public String toString() {
		int delay = 0;
		if (getDelay() != null && !getDelay().equals("0"))
			delay = Integer.parseInt(getDelay())/1000;
		String result = "";
		if (using instanceof Url)
			result += "Go to " + ((Url)using).getName();
		if (using instanceof Path)
			result += "Click on " + ((Path)using).getName();
		if (delay > 0)
			result += " and wait "+ delay + " seconds";
		result += "\n";
		return result;
	}
}
