package compiler.data.flow;

public class AttributeValueByNumber extends compiler.data.AttributeValueByNumber {
	public AttributeValueByNumber(String index) {
		super(index);
	}

	@Override
	public String toString() {
		return "option number " + index;
	}
}
