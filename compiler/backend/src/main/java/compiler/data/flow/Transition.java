package compiler.data.flow;

import compiler.data.Referencable;
import compiler.data.State;

public class Transition extends compiler.data.Transition {
	public Transition(State to, Referencable using, String delay) {
		super(to, using, delay);
	}

	@Override
	public String toString() {
		int delay = Integer.parseInt(getDelay())/1000;
		if (using instanceof Url)
			return "Go to " + ((Url)using).getValue() + " and wait "+ delay + " seconds\n";
		if (using instanceof Path)
			return "Click " + ((Path)using).getValue() + " and wait "+ delay + " seconds\n";
		return "";
	}
}
