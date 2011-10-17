package compiler.data;

public abstract class TargetFactory {
	public abstract Attribute getAttribute(String name, String value);
	public abstract Attributes getAttributes();
	public abstract Find getFind(Path path);
	public abstract Flow getFlow();
	public abstract Path getPath(String name, String value);
	public abstract State getState(String name);
	public abstract Tag getTag(String type);
	public abstract Text getText(String content);
	public abstract Transition getTransition(State to, Referencable using, String delay);
}
