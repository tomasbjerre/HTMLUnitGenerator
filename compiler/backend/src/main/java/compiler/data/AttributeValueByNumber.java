package compiler.data;

public class AttributeValueByNumber extends AttributeValue {
	protected String index;

	public AttributeValueByNumber(String index) {
		this.setIndex(index);
	}

	@Override
	public String getValue() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}
}
