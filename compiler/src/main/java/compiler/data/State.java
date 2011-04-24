package compiler.data;

import java.util.ArrayList;

public class State extends Referencable {
    protected ArrayList<Find> finds = new ArrayList<Find>();

    protected Transition transition = null;

    public State(String name) {
        super(name);
    }

    public void addFind(Find find) {
        finds.add(find);
    }

    public ArrayList<Find> getFinds() {
        return finds;
    }

    public Transition getTransition() {
        return transition;
    }

    public void setTransition(Transition transition) {
        this.transition = transition;
    }

    @Override
    public String toString() {
        String result = "-Step \"" + name + "\"\n";
        result += "Finds:\n";
        if (finds.size() > 0) {
            for (Find find : finds)
                result += find + "\n";
        }
        result += transition;
        return result;
    }
}
