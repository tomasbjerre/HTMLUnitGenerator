package compiler.data.flow;

public class Path extends compiler.data.Path {
	public Path(String name, String value) {
		super(name, value);
	}

	@Override
	public String toString() {
		return "Path " + name + " is " + value + "\n";
	}
}
