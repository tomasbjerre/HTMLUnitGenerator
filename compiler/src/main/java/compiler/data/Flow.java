package compiler.data;

import java.util.ArrayList;
import java.util.List;

public class Flow {
	private State start;
	protected List<Path> paths = new ArrayList<Path>();
	protected List<Url> urls = new ArrayList<Url>();

	public void addPath(Path path) {
		paths.add(path);
	}

	public void addUrl(Url url) {
		urls.add(url);
	}

	public List<Path> getPaths() {
		return paths;
	}

	public State getStart() {
		return start;
	}

	public List<Url> getUrls() {
		return urls;
	}

	public void setPaths(List<Path> paths) {
		this.paths = paths;
	}

	public void setStart(State state) {
		this.start= state;
	}

	public void setUrls(List<Url> urls) {
		this.urls = urls;
	}

	@Override
	public String toString() {
		String result = "";
		result += "<paths>\n";
		for (Path path : paths)
			result += path;
		result += "</paths>\n";
		result += "\n";
		result += "<urls>\n";
		for (Url url : urls)
			result += url;
		result += "</urls>\n";
		result += "\n";
		result += "<flow>\n";
		State state = start;
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
