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

	@Override
	public String toString() {
		return " <path id=\""+name+"\">" + value + "</path>\n";
	}
}
