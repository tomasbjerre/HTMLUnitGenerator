package compiler.data;

import java.util.ArrayList;
import java.util.List;

public class State extends Referencable {
	protected List<Find> finds = new ArrayList<Find>();
	protected List<Form> forms = new ArrayList<Form>();

	protected Transition transition = null;

	public State(String name) {
		super(name);
	}

	public void addFind(Find find) {
		finds.add(find);
	}

	public void addForm(Form form) {
		forms.add(form);
	}

	public List<Find> getFinds() {
		return finds;
	}

	public List<Form> getForms() {
		return forms;
	}

	public Transition getTransition() {
		return transition;
	}

	public void setForms(List<Form> forms) {
		this.forms = forms;
	}

	public void setTransition(Transition transition) {
		this.transition = transition;
	}

	@Override
	public String toString() {
		String result = " <state id=\"" + name + "\">\n";
		if (finds.size() > 0) {
			for (Find find : finds)
				result += find;
		}
		if (forms.size() > 0) {
			for (Form form : forms)
				result += form;
		}
		if (transition != null)
			result += transition;
		result += " </state>\n\n";
		return result;
	}
}
