package compiler.data;

import java.util.ArrayList;
import java.util.List;

public class Flow {
	protected State start;
	protected List<Path> paths = new ArrayList<Path>();
	protected List<Url> urls = new ArrayList<Url>();
	private String proxyHost;
	private String proxyPort;

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

	public String getProxyPort() {
		return proxyPort;
	}

	public void setProxyPort(String proxyPort) {
		this.proxyPort = proxyPort;
	}

	public String getProxyHost() {
		return proxyHost;
	}

	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}
}
