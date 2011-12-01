package compiler.data;

public class Text extends Findable {
	private final String content;

	public Text(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
}
