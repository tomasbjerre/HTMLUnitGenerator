package compiler.data;

public class Url extends Referencable {
	protected String value = "";

	public Url(String name, String value) {
		super(name);
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}
}
