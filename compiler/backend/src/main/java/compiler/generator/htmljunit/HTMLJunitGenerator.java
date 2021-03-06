package compiler.generator.htmljunit;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import compiler.data.Attribute;
import compiler.data.AttributeValue;
import compiler.data.AttributeValueByNumber;
import compiler.data.AttributeValueString;
import compiler.data.AttributeValueUniqueString;
import compiler.data.Find;
import compiler.data.Findable;
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

	private final String methodFind = "private boolean find(String xpath, String tag, String attribute, String value) {\n"
			+ " ArrayList<HtmlElement> matchingDivs = (ArrayList<HtmlElement>) page.getByXPath(xpath);\n"
			+ " for (HtmlElement div : matchingDivs) {\n"
			+ " if (recursiveFind(div.getChildNodes(), tag, attribute, value))\n"
			+ " return true;\n"
			+ " }\n"
			+ " return false;\n"
			+ "}\n";

	private final String methodFindRecursive = "private boolean recursiveFind(DomNodeList<DomNode> nodeList, String tag,\n"
			+ " String attribute, String value) {\n"
			+ " for (DomNode node : nodeList) {\n"
			+ " String nodeName = node.getNodeName();\n"
			+ " if (tag.equals(nodeName)) {\n"
			+ " Node nodeAttribute = node.getAttributes().getNamedItem(\n"
			+ " attribute);\n"
			+ " if (nodeAttribute != null) {"
			+ " String nodeAttributeValue = nodeAttribute.getNodeValue();\n"
			+ " if (value.equals(nodeAttributeValue)) {\n"
			+ " log(\"Found element \"+tag+\" with attribute \"+attribute+\" and value \"+value+\" at \"+node.getCanonicalXPath());\n"
			+ " return true;\n"
			+ " }\n"
			+ " }\n"
			+ " }\n"
			+ " if (recursiveFind(node.getChildNodes(), tag, attribute, value))\n"
			+ " return true;\n" + " }\n" + " return false;\n" + "}";

	private final String methodFindById = "private HtmlForm getFormById(String id) {\n"
			+ " for (HtmlForm form : page.getForms())\n"
			+ "  if (form.getAttributes().getNamedItem(\"id\") != null && form.getAttributes().getNamedItem(\"id\").getNodeValue().equals(id)\n"
			+ "     || form.getAttributes().getNamedItem(\"name\") != null && form.getAttributes().getNamedItem(\"name\").getNodeValue().equals(id)\n"
			+ "     )\n" + "   return form;\n" + " return null;\n" + "}\n";

	private final String methodSetAttributeValue = "private void setAttributeValue(HtmlForm form, String attribute, String value) {\n"
			+ " HtmlSelect select;\n"
			+ " HtmlInput input;\n"
			+ " try {\n"
			+ " input = form.getInputByName(attribute);\n"
			+ " input.setValueAttribute(value);\n"
			+ " } catch (ElementNotFoundException e) {\n"
			+ " select = form.getSelectByName(attribute);\n"
			+ " select.setSelectedAttribute(value, true);\n"
			+ " }\n"
			+ "}\n";

	private final String methodLogAllTags = "private void logAllTags(List<DomNode> elements, String tag) {\n"
			+"for (DomNode element : elements) {\n"
			+"if (element.getNodeName().equals(tag)) {\n"
			+"String string = \"Found: \"+tag;\n"
			+"NamedNodeMap attributes = ((HtmlElement)element).getAttributes();\n"
			+"for (int i = 0; i < attributes.getLength(); i++)\n"
			+"string += \" \"+attributes.item(i).getNodeName()+\"=\"+attributes.item(i).getNodeValue();\n"
			+"string += \" at \"+element.getCanonicalXPath();\n"
			+"log(string);\n"
			+"}\n"
			+"else {\n"
			+"logAllTags(element.getChildNodes(),tag);\n"
			+"}\n"
			+"}\n"
			+"}\n";

	private final String methodFindClosestXpath = "private void findClosestXpath(String xpath) {\n"
			+ "if (xpath.startsWith(\"//*\") || xpath.equals(\"/html\"))\n"
			+ "	return;\n"
			+ "log(\"Searching for xpath \"+xpath);\n"
			+ "matchingElement = (ArrayList<HtmlElement>) page.getByXPath(xpath);\n"
			+ "if (page.getByXPath(xpath).size() > 0) {\n"
			+ "	log(\"\\nFound close elements at \"+xpath+\":\");\n"
			+ "	for (HtmlElement element : matchingElement) {\n"
			+ " if (element.asXml().length() > 100)\n"
			+ "  log(element.asXml().substring(0, 100) + \" ...\");\n"
			+ " else\n"
			+ "  log(element.asXml());\n"
			+ "	}\n"
			+ "	return;\n"
			+ "}\n"
			+ "findClosestXpath(xpath.substring(0, xpath.lastIndexOf(\"/\")));\n"
			+ "}\n";

	private final String methodLog = "private void log(String string) {\n"
			+ " System.out.println(string);\n"
			+ "}\n";

	private final String methodFindAndClick = "private void findAndClick(String xpath) throws Exception {\n"
			+ " matchingElement = (ArrayList<HtmlElement>) page.getByXPath(xpath);\n"
			+ " if (matchingElement.size() == 0) {\n"
			+ "  log(page.asXml());\n"
			+ "  findClosestXpath(xpath);\n"
			+ "  fail(\"Faild to find element \" + xpath + \"\");\n"
			+ " }\n"
			+ " page = matchingElement.get(0).click();\n"
			+ "}\n";
	private final String methodCreateString = "private String createString(String start, int length) {\n"
			+ " if (start == null)\n"
			+ "  start = \"\";\n"
			+ " Random generator = new Random(System.currentTimeMillis());\n"
			+ " String candidates = \"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ\";\n"
			+ " for (int i = start.length(); i < length; i++) {\n"
			+ "  start += candidates.charAt(generator.nextInt(candidates.length()));\n"
			+ " }\n"
			+ " return start;\n"
			+ "}\n";

	private final String methodFindContent = "private boolean find(String xpath, String content) {\n"
			+ "ArrayList<HtmlElement> matchingDivs = (ArrayList<HtmlElement>) page.getByXPath(xpath);\n"
			+ "for (HtmlElement div : matchingDivs) {\n"
			+ "if (div.getTextContent().indexOf(content) != -1)\n"
			+ "return true;\n"
			+ "}\n"
			+ "return false;\n"
			+ "}\n";

	private final String methodFindOneMathingElement = "private HtmlElement findOneMathingElement(ArrayList<HtmlElement> elements, String[] attributeNames, String[] attributeValues) {\n"
			+ "for (HtmlElement domNode : elements) {\n"
			+ "for (int i = 0 ; i <attributeNames.length; i++) {\n"
			+ "if (domNode.getAttributes().getNamedItem(attributeNames[i]).equals(attributeValues[i]))\n"
			+ "return domNode;\n"
			+ "}\n"
			+ "}\n"
			+ "return null;\n"
			+ "}\n";

	private final String methodGetElementsByTagName = "private ArrayList<HtmlElement> getElementsByTagName(String xpath, String name) {\n"
			+" ArrayList<HtmlElement> elements = (ArrayList<HtmlElement>) page.getByXPath(xpath);\n"
			+" ArrayList<HtmlElement> result = new ArrayList<HtmlElement>();\n"
			+" for (HtmlElement element : elements)\n"
			+"  if (element.getNodeName().equals(name))\n"
			+"   result.add(element);\n"
			+" return result;\n"
			+"}\n";

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

	private void handle(Find find) {
		result += "/**\n";
		result += find.toString();
		result += "*/\n";
		result += "{\n";
		result += "long endTime = System.currentTimeMillis() + "+find.getWaitAtMost()+";\n";
		result += "do {\n";
		result += "boolean successfull = true;\n";
		result += "webClient.waitForBackgroundJavaScriptStartingBefore(100);\n";
		result += "if (!(";
		boolean isFirstFindable = true;
		for (Findable findable : find.getFindable()) {
			if (!isFirstFindable && findable.isAnd())
				result += " && ";
			else if (!isFirstFindable && !findable.isAnd())
				result += " || ";
			isFirstFindable = false;
			if (findable instanceof Text) {
				Text text = (Text)findable;
				result += "find(\""+find.getPath().getValue()+"\", \""+escapeString(text.getContent())+"\")\n";
			} else if (findable instanceof Tag) {
				Tag tag = (Tag)findable;
				String tagName = tag.getName();
				String getElementsByTagName = "getElementsByTagName(\""+escapeString(find.getPath().getValue())+"\", \""+tagName+"\")";
				Iterator<Attribute> attributesItr = tag.getAttributes().iterator();
				result += "(";
				boolean isFirstAttribute = true;
				while (attributesItr.hasNext()) {
					Attribute attribute = attributesItr.next();
					if (attribute.isAnd()) {
						ArrayList<String> attributeNames = new ArrayList<String>();
						ArrayList<String> attributeValues = new ArrayList<String>();
						attributeNames.add("\""+attribute.getName()+"\"");
						attributeValues.add("\""+attribute.getValue().getValue()+"\"");

						while (attributesItr.hasNext()) {
							attribute = attributesItr.next();
							if (!attribute.isAnd())
								break;
							attributeNames.add(",\""+attribute.getName()+"\"");
							attributeValues.add(",\""+attribute.getValue().getValue()+"\"");
						}
						if (!isFirstAttribute)
							result += " && ";
						result += "findOneMathingElement("+getElementsByTagName+",new String[]{";
						for (String name : attributeNames)
							result += name;
						result += "},new String[]{";
						for (String value : attributeValues)
							result += value;
						result += "}) != null\n";
						isFirstAttribute = false;
					}

					if (!attribute.isAnd()) {
						if (!isFirstAttribute)
							result += " || ";
						result += "findOneMathingElement("+getElementsByTagName+",new String[]{\""+attribute.getName()+"\"},new String[]{\""+attribute.getValue()+"\"}) != null\n";
						isFirstAttribute = false;
					}
				}
				result += ")";
			}
		}
		result += ")) {\n";
		result += "successfull = false;\n";
		result += "}\n";
		result += "} while (!successfull && (endTime-System.currentTimeMillis()) > 0);\n";
		result += "}\n";
	}

	private void handle(Form using) {
		result += "form = getFormById(\"" + using.getName() + "\");\n";
		for (Tag tag : using.getTags())
			for (Attribute attribute : tag.getAttributes()) {
				String name = attribute.getName();
				AttributeValue value = attribute.getValue();
				if (value instanceof AttributeValueString) {
					result += "setAttributeValue(form, \"" + escapeString(name) + "\", \""+value+"\");\n";
				} else if (value instanceof AttributeValueByNumber) {
					AttributeValueByNumber attributeValueByNumber = (AttributeValueByNumber)value;
					result += "select = form.getSelectByName(\"" + escapeString(name) + "\");\n";
					result += "select.setSelectedAttribute(select.getOption(" + attributeValueByNumber.getValue() + "), true);\n";
				} else if (value instanceof AttributeValueUniqueString) {
					addMethod(methodCreateString);
					AttributeValueUniqueString attributeValueUniqueString = (AttributeValueUniqueString)value;
					result += "input = form.getInputByName(\"" + escapeString(name) + "\");\n";
					result += "input.setValueAttribute(createString(\""+attributeValueUniqueString.getValue()+"\", "+attributeValueUniqueString.getLength()+"));\n";
				}
			}

		if (using.getSubmit() != null) {
			handle(using.getSubmit());
		}
	}

	private void handle(Path using) {
		result += "findAndClick(\"" + escapeString(using.getValue()) + "\");\n";
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
		result += "/**\n";
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
		if (transition.getDelay() != null && !transition.getDelay().equals("0"))
			result += "Thread.sleep("+transition.getDelay()+");\n";

		result += "\n";
		result += "step = \"" + to.getName() + "\";\n";
		return to;
	}

	private void handle(Url using) {
		result += "page = webClient.getPage(\"" + getAbsoluteUrl(using.getValue()) + "\");\n";
	}

	@Override
	public String toString() {
		addMethod(methodLog);
		addMethod(methodLogAllTags);
		addMethod(methodFindById);
		addMethod(methodSetAttributeValue);
		addMethod(methodFindClosestXpath);
		addMethod(methodFindAndClick);
		addMethod(methodFindContent);
		addMethod(methodFind);
		addMethod(methodFindRecursive);
		addMethod(methodFindOneMathingElement);
		addMethod(methodGetElementsByTagName);

		result = "package webtest;";
		result += "\n";
		result += "import org.junit.Test;\n";
		result += "\n";
		result += "import org.w3c.dom.Node;\n";
		result += "import com.gargoylesoftware.htmlunit.html.*;\n";
		result += "import com.gargoylesoftware.htmlunit.*;\n";
		result += "import java.util.*;\n";
		result += "import org.w3c.dom.NamedNodeMap;\n";
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
		result += "WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER_8);\n";
		result += "HtmlPage page = null;\n";
		result += "String step = null;\n";
		result += "boolean successfull = false;\n";
		result += "HtmlForm form = null;\n";
		result += "HtmlInput input = null;\n";
		result += "HtmlSelect select = null;\n";
		result += "ArrayList<HtmlElement> matchingElement = null;\n";
		result += "@Test\n";
		result += "public void testHomePage() throws Exception {\n";
		result += "webClient.setCssEnabled(true);\n";
		result += "webClient.setJavaScriptEnabled(true);\n";
		result += "webClient.setThrowExceptionOnFailingStatusCode(false);\n";
		result += "webClient.setThrowExceptionOnScriptError(false);\n";
		result += "webClient.setTimeout(180000);\n";
		result += "webClient.setJavaScriptTimeout(180000);\n";
		if (flow.getProxyHost() != null && !flow.getProxyHost().isEmpty()) {
			result += "Properties systemProperties = System.getProperties();\n";
			result += "systemProperties.setProperty(\"http.proxyHost\",\""+flow.getProxyHost()+"\");\n";
			result += "systemProperties.setProperty(\"http.proxyPort\",\""+flow.getProxyPort()+"\");\n";
			result += "webClient.setProxyConfig(new ProxyConfig(\""+flow.getProxyHost()+"\", "+flow.getProxyPort()+"));\n";
		}
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
			result += "log(System.currentTimeMillis()+\") Entering state "+(stateIndex+1)+" of "+numStates+" "+((int)((float)stateIndex/numStates*100))+"% complete \\\""+state.getName()+"\\\"\");\n";
			stateIndex++;
			state = handle(state);
		} while (state != null);

		result += "webClient.closeAllWindows();\n";
		result += "}\n";
		result += "\n";

		for (String method : methods)
			result += method + "\n";
		result += "\n";

		result += "}\n";

		return result;
	}
}
