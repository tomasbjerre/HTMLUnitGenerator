package compiler.data;

public class AttributeValueByNumber extends AttributeValue {
	protected String index;

	public AttributeValueByNumber(String index) {
		this.setIndex(index);
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}
}
