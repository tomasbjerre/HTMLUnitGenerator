package compiler.data.flow;


public class Flow extends compiler.data.Flow {
	@Override
	public String toString() {
		String result = "";
		for (compiler.data.Path path : paths)
			result += path;
		result += "\n";
		for (compiler.data.Url url : urls)
			result += url;
		result += "\n";
		compiler.data.State state = start;
		do {
			result += state;
			if (state.getTransition() != null)
				state = state.getTransition().getTo();
			else
				state = null;
		} while (state != null);
		return result;
	}
}
