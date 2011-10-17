package compiler.data;

import java.util.ArrayList;
import java.util.List;

public class Flow {
	protected State start;
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
}
