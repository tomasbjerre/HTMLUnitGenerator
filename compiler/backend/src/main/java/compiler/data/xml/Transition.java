package compiler.data.xml;

import compiler.data.Referencable;
import compiler.data.State;

public class Transition extends compiler.data.Transition {
	public Transition(State to, Referencable using, String delay) {
		super(to, using, delay);
	}

	@Override
	public String toString() {
		String result = "  <transition";
		result += " to=\""+to.getName()+"\"";
		result += " using=\""+using.getName()+"\"";
		result += " delay=\""+delay+"\"";
		result += "/>\n";
		return result;
	}
}
