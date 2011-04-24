package compiler.data;


public class Tag {
    protected String type = "";
    protected Attributes attributes = new Attributes();

    public Tag(String type) {
        this.type = type;
    }

    public void addAttribute(Attribute attribute) {
        attributes.put(attribute.getName(), attribute);
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public String getName() {
        return type;
    }

    @Override
    public String toString() {
        String result = "-Tag\n";
        result += "Name:" + type + "\n";
        if (attributes.size() > 0) {
            for (String attribute : attributes.keySet()) {
                Attribute value = attributes.get(attribute);
                result += attribute + " = " + value + "\n";
            }
        }
        return result;
    }
}
