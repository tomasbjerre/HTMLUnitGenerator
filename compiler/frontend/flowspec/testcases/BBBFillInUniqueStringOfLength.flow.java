package webtest;
import org.junit.Test;

import org.w3c.dom.Node;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.*;
import java.util.*;
import org.w3c.dom.NamedNodeMap;

import java.util.ArrayList;

import junit.framework.TestCase;

/**
// Generated Using HTMLUnitGenerator
Path campaignmodule is /html/body/div[2]/div/div[2]/div[2]/div/div[3]
Path searchpopup is /html/body/div[7]/div/div[9]
Path _eventId_search is //*[@id="_eventId_search"]
Path campaignModuleChoose is /html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/span/a/span
Path bbCampaignModuleChoose is /html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/div[3]/span[4]/a/span
Path searchPopupChooseFoundOffer is /html/body/div[8]/div/div[9]/form[2]/div[2]/div[1]/div/div[2]/a[1]
Path orderCartArea is /html/body/div[2]/div/div/div/div[3]/form/div[2]/div[2]/div[3]
Path website is /html/body
Path checkoutOrder is //*[@id="orderButton"]

Url baspaket is http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html
Url onegbit is http://www.bredbandsbolaget.se/bredband/bredband1000/index.html

Go to baspaket and wait 2 seconds
Find a with attribute href set to /servlet/orderflow/search/search-flow?Id=tcm:142-23371&draggable=false in campaignmodule
Click on campaignModuleChoose and wait 10 seconds
Fill in locationForm with _eventId as search and phoneNumber.fullNumber as unique string of length 20

Click on _eventId_search and wait 10 seconds
Find input with attribute id set to _eventId_search in searchpopup
*/

@SuppressWarnings("unchecked")
public class BBBFillInUniqueStringOfLength extends TestCase {
WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER_8);
HtmlPage page = null;
String step = null;
boolean successfull = false;
HtmlForm form = null;
HtmlInput input = null;
HtmlSelect select = null;
ArrayList<HtmlElement> matchingElement = null;
@Test
public void testHomePage() throws Exception {
webClient.setCssEnabled(true);
webClient.setJavaScriptEnabled(true);
webClient.setThrowExceptionOnFailingStatusCode(false);
webClient.setThrowExceptionOnScriptError(false);
webClient.setTimeout(180000);
webClient.setJavaScriptTimeout(180000);


log(System.currentTimeMillis()+") Entering state 1 of 5 0% complete \"start\"");
/**
Url baspaket is http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html
Go to baspaket and wait 2 seconds
*/
page = webClient.getPage("http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html");
Thread.sleep(2000);

step = "State1";
log(System.currentTimeMillis()+") Entering state 2 of 5 20% complete \"State1\"");
/**
Find a with attribute href set to /servlet/orderflow/search/search-flow?Id=tcm:142-23371&draggable=false in campaignmodule
*/
{
long endTime = System.currentTimeMillis() + 0;
do {
boolean successfull = true;
webClient.waitForBackgroundJavaScriptStartingBefore(100);
if (!((findOneMathingElement(getElementsByTagName("/html/body/div[2]/div/div[2]/div[2]/div/div[3]", "a"),new String[]{"href"},new String[]{"/servlet/orderflow/search/search-flow?Id=tcm:142-23371&draggable=false"}) != null
))) {
successfull = false;
}
} while (!successfull && (endTime-System.currentTimeMillis()) > 0);
}
/**
Path campaignModuleChoose is /html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/span/a/span
Click on campaignModuleChoose and wait 10 seconds
*/
findAndClick("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/span/a/span");
Thread.sleep(10000);

step = "State2";
log(System.currentTimeMillis()+") Entering state 3 of 5 40% complete \"State2\"");
/**
Fill in locationForm with _eventId as search and phoneNumber.fullNumber as unique string of length 20

*/
form = getFormById("locationForm");
setAttributeValue(form, "_eventId", "search");
input = form.getInputByName("phoneNumber.fullNumber");
input.setValueAttribute(createString("", 20));

step = "State3";
log(System.currentTimeMillis()+") Entering state 4 of 5 60% complete \"State3\"");
/**
Path _eventId_search is //*[@id="_eventId_search"]
Click on _eventId_search and wait 10 seconds
*/
findAndClick("//*[@id=\"_eventId_search\"]");
Thread.sleep(10000);

step = "State4";
log(System.currentTimeMillis()+") Entering state 5 of 5 80% complete \"State4\"");
/**
Find input with attribute id set to _eventId_search in searchpopup
*/
{
long endTime = System.currentTimeMillis() + 0;
do {
boolean successfull = true;
webClient.waitForBackgroundJavaScriptStartingBefore(100);
if (!((findOneMathingElement(getElementsByTagName("/html/body/div[7]/div/div[9]", "input"),new String[]{"id"},new String[]{"_eventId_search"}) != null
))) {
successfull = false;
}
} while (!successfull && (endTime-System.currentTimeMillis()) > 0);
}
webClient.closeAllWindows();
}

private void log(String string) {
 System.out.println(string);
}

private void logAllTags(List<DomNode> elements, String tag) {
for (DomNode element : elements) {
if (element.getNodeName().equals(tag)) {
String string = "Found: "+tag;
NamedNodeMap attributes = ((HtmlElement)element).getAttributes();
for (int i = 0; i < attributes.getLength(); i++)
string += " "+attributes.item(i).getNodeName()+"="+attributes.item(i).getNodeValue();
string += " at "+element.getCanonicalXPath();
log(string);
}
else {
logAllTags(element.getChildNodes(),tag);
}
}
}

private HtmlForm getFormById(String id) {
 for (HtmlForm form : page.getForms())
  if (form.getAttributes().getNamedItem("id") != null && form.getAttributes().getNamedItem("id").getNodeValue().equals(id)
     || form.getAttributes().getNamedItem("name") != null && form.getAttributes().getNamedItem("name").getNodeValue().equals(id)
     )
   return form;
 return null;
}

private void setAttributeValue(HtmlForm form, String attribute, String value) {
 HtmlSelect select;
 HtmlInput input;
 try {
 input = form.getInputByName(attribute);
 input.setValueAttribute(value);
 } catch (ElementNotFoundException e) {
 select = form.getSelectByName(attribute);
 select.setSelectedAttribute(value, true);
 }
}

private void findClosestXpath(String xpath) {
if (xpath.startsWith("//*") || xpath.equals("/html"))
	return;
log("Searching for xpath "+xpath);
matchingElement = (ArrayList<HtmlElement>) page.getByXPath(xpath);
if (page.getByXPath(xpath).size() > 0) {
	log("\nFound close elements at "+xpath+":");
	for (HtmlElement element : matchingElement) {
 if (element.asXml().length() > 100)
  log(element.asXml().substring(0, 100) + " ...");
 else
  log(element.asXml());
	}
	return;
}
findClosestXpath(xpath.substring(0, xpath.lastIndexOf("/")));
}

private void findAndClick(String xpath) throws Exception {
 matchingElement = (ArrayList<HtmlElement>) page.getByXPath(xpath);
 if (matchingElement.size() == 0) {
  log(page.asXml());
  findClosestXpath(xpath);
  fail("Faild to find element " + xpath + "");
 }
 page = matchingElement.get(0).click();
}

private boolean find(String xpath, String content) {
ArrayList<HtmlElement> matchingDivs = (ArrayList<HtmlElement>) page.getByXPath(xpath);
for (HtmlElement div : matchingDivs) {
if (div.getTextContent().indexOf(content) != -1)
return true;
}
return false;
}

private boolean find(String xpath, String tag, String attribute, String value) {
 ArrayList<HtmlElement> matchingDivs = (ArrayList<HtmlElement>) page.getByXPath(xpath);
 for (HtmlElement div : matchingDivs) {
 if (recursiveFind(div.getChildNodes(), tag, attribute, value))
 return true;
 }
 return false;
}

private boolean recursiveFind(DomNodeList<DomNode> nodeList, String tag,
 String attribute, String value) {
 for (DomNode node : nodeList) {
 String nodeName = node.getNodeName();
 if (tag.equals(nodeName)) {
 Node nodeAttribute = node.getAttributes().getNamedItem(
 attribute);
 if (nodeAttribute != null) { String nodeAttributeValue = nodeAttribute.getNodeValue();
 if (value.equals(nodeAttributeValue)) {
 log("Found element "+tag+" with attribute "+attribute+" and value "+value+" at "+node.getCanonicalXPath());
 return true;
 }
 }
 }
 if (recursiveFind(node.getChildNodes(), tag, attribute, value))
 return true;
 }
 return false;
}
private HtmlElement findOneMathingElement(ArrayList<HtmlElement> elements, String[] attributeNames, String[] attributeValues) {
for (HtmlElement domNode : elements) {
for (int i = 0 ; i <attributeNames.length; i++) {
if (domNode.getAttributes().getNamedItem(attributeNames[i]).equals(attributeValues[i]))
return domNode;
}
}
return null;
}

private ArrayList<HtmlElement> getElementsByTagName(String xpath, String name) {
 ArrayList<HtmlElement> elements = (ArrayList<HtmlElement>) page.getByXPath(xpath);
 ArrayList<HtmlElement> result = new ArrayList<HtmlElement>();
 for (HtmlElement element : elements)
  if (element.getNodeName().equals(name))
   result.add(element);
 return result;
}

private String createString(String start, int length) {
 if (start == null)
  start = "";
 Random generator = new Random(System.currentTimeMillis());
 String candidates = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
 for (int i = start.length(); i < length; i++) {
  start += candidates.charAt(generator.nextInt(candidates.length()));
 }
 return start;
}


}
