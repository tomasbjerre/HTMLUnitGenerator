package compiler.generator.htmljunit;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import compiler.data.Attribute;
import compiler.data.AttributeValue;
import compiler.data.AttributeValueByNumber;
import compiler.data.AttributeValueString;
import compiler.data.AttributeValueUniqueString;
import compiler.data.Find;
import compiler.data.Flow;
import compiler.data.Form;
import compiler.data.Path;
import compiler.data.State;
import compiler.data.Tag;
import compiler.data.Text;
import compiler.data.Transition;
import compiler.data.Url;
import compiler.generator.Generator;

public class HTMLJunitGenerator extends Generator {
	private final Flow flow;
	private final ArrayList<String> methods = new ArrayList<String>();
	private String result = "";

	private final String methodFind = "private boolean find(HtmlPage page, String xpath, String tag, String attribute, String value) {\n"
			+ " ArrayList<HtmlElement> matchingDivs = (ArrayList<HtmlElement>) page.getByXPath(xpath);\n"
			+ " for (HtmlElement div : matchingDivs) {\n"
			+ "  if (recursiveFind(div.getChildNodes(), tag, attribute, value))\n"
			+ "   return true;\n"
			+ " }\n"
			+ " return false;\n"
			+ "}\n";

	private final String methodFindRecursive = "private boolean recursiveFind(DomNodeList<DomNode> nodeList, String tag,\n"
			+ " String attribute, String value) {\n"
			+ " for (DomNode node : nodeList) {\n"
			+ "  String nodeName = node.getNodeName();\n"
			+ "  if (tag.equals(nodeName)) {\n"
			+ "   Node nodeAttribute = node.getAttributes().getNamedItem(\n"
			+ "     attribute);\n"
			+ "   if (nodeAttribute != null) {"
			+ "    String nodeAttributeValue = nodeAttribute.getNodeValue();\n"
			+ "    if (value.equals(nodeAttributeValue)) {\n"
			+ "     System.out.println(\"Found element \"+tag+\" with attribute \"+attribute+\" and value \"+value+\" at \"+node.getCanonicalXPath());\n"
			+ "     return true;\n"
			+ "    }\n"
			+ "   }\n"
			+ "  }\n"
			+ "  if (recursiveFind(node.getChildNodes(), tag, attribute, value))\n"
			+ "   return true;\n" + " }\n" + " return false;\n" + "}";

	private final String methodFindText = "private boolean find(HtmlPage page, String xpath, String text) {\n"
			+ " ArrayList<HtmlElement> matchingDivs;\n"
			+ " boolean successfull;\n"
			+ " matchingDivs = (ArrayList<HtmlElement>) page.getByXPath(xpath);\n"
			+ " successfull = false;\n"
			+ " for (HtmlElement div : matchingDivs) {\n"
			+ "  String asXml;\n"
			+ "  asXml = div.asXml();\n"
			+ "  System.out.println(asXml);"
			+ "  Pattern selectPattern = Pattern.compile(text,\n"
			+ "          Pattern.CASE_INSENSITIVE);\n"
			+ "  Matcher selectMatcher = selectPattern.matcher(asXml);\n"
			+ "  successfull = selectMatcher.find();\n"
			+ "  if (successfull)\n"
			+ "   return true;\n"
			+ " }\n"
			+ " return false;\n" + "}\n";

	private final String methodFindById = "private HtmlForm getFormById(HtmlPage page, String id) {\n"
			+ " for (HtmlForm form : page.getForms())\n"
			+ "  if (form.getAttributes().getNamedItem(\"id\") != null && form.getAttributes().getNamedItem(\"id\").getNodeValue().equals(id)\n"
			+ "     || form.getAttributes().getNamedItem(\"name\") != null && form.getAttributes().getNamedItem(\"name\").getNodeValue().equals(id)\n"
			+ "     )\n" + "   return form;\n" + " return null;\n" + "}\n";

	private String currentUrl;
	private final String testFileName;

	public HTMLJunitGenerator(Flow flow, String testFileName) {
		this.flow = flow;
		this.testFileName = testFileName;
	}

	private void addMethod(String method) {
		if (methods.contains(method))
			return;
		methods.add(method);
	}

	public String escapeString(String string) {
		String newString = "";
		for (int i = 0; i < string.length(); i++)
			if (string.charAt(i) == '"')
				newString += "\\\"";
			else
				newString += string.charAt(i);
		return newString;
	}

	private String getAbsoluteUrl(String url) {
		if (!url.startsWith("http")) {
			try {
				URL myUrl = new URL(currentUrl);
				currentUrl = myUrl.getProtocol() + "://" + myUrl.getHost()
						+ url;
			} catch (MalformedURLException e) {
				System.out
				.println("Unable to determine absolute URL. Did you use a relative URL without first using an absolute URL?");
			}
		} else {
			currentUrl = url;
		}
		return currentUrl;
	}

	private String getCurrentUrl() {
		return currentUrl;
	}

	private void handle(Find find) {
		result += "/*\n";
		result += find.toString();
		result += "*/\n";
		if (!find.getTexts().isEmpty()) {
			addMethod(methodFindText);
			for (Text text : find.getTexts()) {
				result += "successfull = find(page, \""
						+ escapeString(find.getPath().getValue()) + "\", \""
						+ text.getContent() + "\");\n";
				result += "if (!successfull)\n";
				result += " fail(step+\") Failed finding text \\\""
						+ text.getContent() + "\\\" in \\\""
						+ escapeString(find.getPath().getValue())
						+ "\\\" at \\\"" + getCurrentUrl() + "\\\"\");\n\n";
			}
		}

		if (!find.getTags().isEmpty()) {
			addMethod(methodFind);
			addMethod(methodFindRecursive);
			for (Tag tag : find.getTags()) {
				String tagName = tag.getName();
				for (Attribute attribute : tag.getAttributes().values()) {
					result += "successfull = find(page, \""
							+ escapeString(find.getPath().getValue())
							+ "\", \"" + tagName + "\", \""
							+ attribute.getName() + "\", \""
							+ attribute.getValue() + "\");\n";
					result += "if (!successfull) {\n";
					result += " System.out.println(page.asXml());\n";
					result += " fail(step+\") Failed finding tag \\\""
							+ tagName + "\\\" with attribute \\\""
							+ attribute.getName() + "\\\" and value \\\""
							+ attribute.getValue() + "\\\" in \\\""
							+ escapeString(find.getPath().getValue())
							+ "\\\" at \\\"" + getCurrentUrl() + "\\\"\");\n\n";
					result += "}\n";
				}
			}
		}
	}

	private void handle(Form using) {
		addMethod(methodFindById);
		result += "form = getFormById(page,\"" + using.getName() + "\");\n";
		for (Tag tag : using.getTags())
			for (Attribute attribute : tag.getAttributes().values()) {
				String name = attribute.getName();
				AttributeValue value = attribute.getValue();
				if (value instanceof AttributeValueString) {
					result += "try {\n";
					result += " input = form.getInputByName(\"" + escapeString(name) + "\");\n";
					result += " input.setValueAttribute(\""+value+"\");\n";
					result += "} catch (ElementNotFoundException e) {\n";
					result += " select = form.getSelectByName(\"" + escapeString(name) + "\");\n";
					result += " select.setSelectedAttribute(\""+value+"\", true);\n";
					result += "}\n";
				} else if (value instanceof AttributeValueByNumber) {
					AttributeValueByNumber attributeValueByNumber = (AttributeValueByNumber)value;
					result += "select = form.getSelectByName(\"" + escapeString(name) + "\");\n";
					result += "select.setSelectedAttribute(select.getOption(" + attributeValueByNumber.getValue() + "), true);\n";
				} else if (value instanceof AttributeValueUniqueString) {
					AttributeValueUniqueString attributeValueUniqueString = (AttributeValueUniqueString)value;
					result += "input = form.getInputByName(\"" + escapeString(name) + "\");\n";
					result += "input.setValueAttribute(\""+attributeValueUniqueString.getValue()+"\");\n";
				}
			}

		if (using.getSubmit() != null) {
			handle(using.getSubmit());
		}
	}

	private void handle(Path using) {
		result += "matchingElement = (ArrayList<HtmlElement>) page.getByXPath(\""
				+ escapeString(using.getValue()) + "\");\n";
		result += "if (matchingElement.size() == 0) {\n";
		result += " fail(\"Faild to find element " + escapeString(using.getValue()) + "\");\n";
		result += " System.out.println(page.asXml());\n";
		result += "}";
		result += "page = matchingElement.get(0).click();\n";
		result += "\n";
	}

	private State handle(State state) {
		State nextState = null;
		for (Find find : state.getFinds())
			handle(find);
		Transition transition = state.getTransition();
		if (transition != null)
			nextState = handle(transition);
		return nextState;
	}

	private State handle(Transition transition) {
		result += "/*\n";
		result += transition.getUsing().toString();
		result += transition.toString();
		result += "*/\n";
		State to = transition.getTo();
		if (transition.getUsing() instanceof Form)
			handle((Form) transition.getUsing());
		if (transition.getUsing() instanceof Path)
			handle((Path) transition.getUsing());
		if (transition.getUsing() instanceof Url)
			handle((Url) transition.getUsing());
		result += "webClient.waitForBackgroundJavaScriptStartingBefore("+transition.getDelay()+");\n";

		result += "\n";
		result += "step = \"" + to.getName() + "\";\n";
		return to;
	}

	private void handle(Url using) {
		result += "page = webClient.getPage(\""
				+ getAbsoluteUrl(using.getValue()) + "\");\n";
	}

	@Override
	public String toString() {
		result = "package webtest;";
		result += "\n";
		result += "import org.junit.Test;\n";
		result += "\n";
		result += "import org.w3c.dom.Node;\n";
		result += "import com.gargoylesoftware.htmlunit.WebClient;\n";
		result += "import com.gargoylesoftware.htmlunit.html.*;\n";
		result += "import com.gargoylesoftware.htmlunit.*;\n";
		result += "\n";
		result += "import java.util.ArrayList;\n";
		result += "\n";
		result += "import junit.framework.TestCase;\n";
		result += "\n";
		result += "/**\n";
		result += "// Generated Using HTMLUnitGenerator\n";
		result += flow.toString();
		result += "*/\n";
		result += "\n";
		result += "@SuppressWarnings(\"unchecked\")\n";
		result += "public class " + testFileName + " extends TestCase {\n";
		result += "@Test\n";
		result += "public void testHomePage() throws Exception {\n";
		result += " WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER_8);\n";
		result += " webClient.setCssEnabled(true);\n";
		result += " webClient.setJavaScriptEnabled(true);\n";
		result += " webClient.setThrowExceptionOnFailingStatusCode(false);\n";
		result += " webClient.setThrowExceptionOnScriptError(false);\n";
		result += " webClient.setTimeout(180000);\n";
		result += " webClient.setJavaScriptTimeout(180000);\n";
		result += " HtmlPage page = null;\n";
		result += " String step = null;\n";
		result += " boolean successfull = false;\n";
		result += " HtmlForm form = null;\n";
		result += " HtmlInput input = null;\n";
		result += " HtmlSelect select = null;\n";
		result += " ArrayList<HtmlElement> matchingElement = null;\n";
		result += "\n";
		result += "\n";

		//Count number of states
		State state = flow.getStart();
		long numStates = 0;
		do {
			numStates++;
			if (state.getTransition() != null)
				state = state.getTransition().getTo();
			else
				state = null;
		} while (state != null);

		//Traverse all states
		long stateIndex = 0;
		state = flow.getStart();
		do {
			result += "System.out.println(System.currentTimeMillis()+\") Entering state "+(stateIndex+1)+" of "+numStates+" "+((int)((float)stateIndex/numStates*100))+"% complete \\\""+state.getName()+"\\\"\");\n";
			stateIndex++;
			state = handle(state);
		} while (state != null);

		result += " webClient.closeAllWindows();\n";
		result += "}\n";
		result += "\n";

		for (String method : methods)
			result += method + "\n";
		result += "\n";

		result += "}\n";

		return result;
	}
}
