package compiler.data.flow;

import compiler.data.Attribute;
import compiler.data.Attributes;
import compiler.data.Find;
import compiler.data.Flow;
import compiler.data.Path;
import compiler.data.Referencable;
import compiler.data.State;
import compiler.data.Tag;
import compiler.data.Text;
import compiler.data.Transition;

public class TargetFactory extends compiler.data.TargetFactory {
	@Override
	public Attribute getAttribute(String name, String value) {
		return new compiler.data.flow.Attribute(name, value);
	}

	@Override
	public Attributes getAttributes() {
		return new compiler.data.flow.Attributes();
	}

	@Override
	public Find getFind(Path path) {
		return new compiler.data.flow.Find(path);
	}

	@Override
	public Flow getFlow() {
		return new compiler.data.flow.Flow();
	}

	@Override
	public Path getPath(String name, String value) {
		return new compiler.data.flow.Path(name, value);
	}

	@Override
	public State getState(String name) {
		return new compiler.data.flow.State(name);
	}

	@Override
	public Tag getTag(String type) {
		return new compiler.data.flow.Tag(type);
	}

	@Override
	public Text getText(String content) {
		return new compiler.data.flow.Text(content);
	}

	@Override
	public Transition getTransition(State to, Referencable using, String delay) {
		return new compiler.data.flow.Transition(to, using, delay);
	}
}
