package compiler.data;

import java.util.ArrayList;

public class Find {
    protected Path path = null;
    protected ArrayList<Tag> tags = new ArrayList<Tag>();
    private ArrayList<Text> texts = new ArrayList<Text>();

    public Find(Path path) {
        this.path = path;
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }

    public void addText(Text text) {
        texts.add(text);
    }

    public Path getPath() {
        return path;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public ArrayList<Text> getTexts() {
        return texts;
    }

    @Override
    public String toString() {
        String result = "-Find\n";
        result += "In path:" + path + "\n";
        if (tags.size() > 0) {
            for (Tag tag : tags)
                result += tag + "\n";
            result += "\n";
        }
        return result;
    }
}
