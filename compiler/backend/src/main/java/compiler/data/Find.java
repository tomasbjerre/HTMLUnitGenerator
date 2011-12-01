package compiler.data;

import java.util.ArrayList;
import java.util.List;

public class Find {
	protected Path path = null;
	protected List<Findable> findables = new ArrayList<Findable>();
	protected String waitAtMost = "0";

	public Find(Path path) {
		this.path = path;
	}

	public void addFindable(Findable findable) {
		this.findables.add(findable);
	}

	public List<Findable> getFindable() {
		return findables;
	}

	public Path getPath() {
		return path;
	}

	public String getWaitAtMost() {
		return waitAtMost;
	}

	public void setWaitAtMost(String waitAtMost) {
		this.waitAtMost = waitAtMost;
	}
}
