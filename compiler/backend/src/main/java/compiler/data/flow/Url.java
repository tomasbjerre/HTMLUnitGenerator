package compiler.data.flow;

public class Url extends compiler.data.Url {
	public Url(String name, String value) {
		super(name, value);
	}

	@Override
	public String toString() {
		return "Url " + name + " is " + value + "\n";
	}
}
