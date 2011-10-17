package compiler.data;

public abstract class Referencable {
	protected String name;

	public Referencable(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
