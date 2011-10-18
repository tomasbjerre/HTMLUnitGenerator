package compiler.data.flow;


public class State extends compiler.data.State {
	public State(String name) {
		super(name);
	}

	@Override
	public String toString() {
		String result = "";
		if (finds.size() > 0) {
			for (compiler.data.Find find : finds)
				result += find;
		}
		if (forms.size() > 0) {
			for (compiler.data.Form form : forms)
				result += form;
		}
		if (transition != null)
			result += transition;
		return result;
	}
}
