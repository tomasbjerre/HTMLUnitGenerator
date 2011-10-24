package compiler.data;

public class AttributeValueString extends AttributeValue {
	private String content;

	public AttributeValueString(String content) {
		this.setContent(content);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return content;
	}
}
