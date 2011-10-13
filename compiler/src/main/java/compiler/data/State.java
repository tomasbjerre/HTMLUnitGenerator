package compiler.data;

import java.util.ArrayList;
import java.util.List;

public class State extends Referencable {
	protected List<Find> finds = new ArrayList<Find>();

	protected Transition transition = null;

	public State(String name) {
		super(name);
	}

	public void addFind(Find find) {
		finds.add(find);
	}

	public List<Find> getFinds() {
		return finds;
	}

	public Transition getTransition() {
		return transition;
	}

	public void setTransition(Transition transition) {
		this.transition = transition;
	}

	@Override
	public String toString() {
		String result = " <state id=\"" + name + "\">\n";
		if (finds.size() > 0) {
			for (Find find : finds)
				result += find;
		}
		if (transition != null)
			result += transition;
		result += " </state>\n\n";
		return result;
	}
}
