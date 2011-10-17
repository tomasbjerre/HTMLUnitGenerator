package compiler.data.xml;


public class Flow extends compiler.data.Flow {
	@Override
	public String toString() {
		String result = "";
		result += "<paths>\n";
		for (compiler.data.Path path : paths)
			result += path;
		result += "</paths>\n";
		result += "\n";
		result += "<urls>\n";
		for (compiler.data.Url url : urls)
			result += url;
		result += "</urls>\n";
		result += "\n";
		result += "<flow>\n";
		compiler.data.State state = start;
		do {
			result += state;
			if (state.getTransition() != null)
				state = state.getTransition().getTo();
			else
				state = null;
		} while (state != null);
		result += "</flow>\n";
		return result;
	}
}
