package compiler.data;

public class Path extends Referencable {
	protected String value = "";

	public Path(String name, String value) {
		super(name);
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
