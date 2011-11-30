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
Path _eventId_search is /html/body

Url url1 is http://bjurr.se/

Go to url1
Fill in locationForm with _eventId as search and phoneNumber.fullNumber as unique string of length 10 starting with My

Click on _eventId_search and wait 10 seconds
Fill in locationForm with _eventId as search and phoneNumber.fullNumber as unique string of length 10 starting with My

Click on _eventId_search and wait 10 seconds
Fill in locationForm with _eventId as search and phoneNumber.fullNumber as unique string of length 10 starting with " My "

Click on _eventId_search and wait 10 seconds
Fill in locationForm with _eventId as search and phoneNumber.fullNumber as unique string of length 10 starting with " M y "

Click on _eventId_search and wait 10 seconds
*/

@SuppressWarnings("unchecked")
public class FillIn extends TestCase {
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


log(System.currentTimeMillis()+") Entering state 1 of 10 0% complete \"start\"");
/**
Url url1 is http://bjurr.se/
Go to url1
*/
page = webClient.getPage("http://bjurr.se/");

step = "State1";
log(System.currentTimeMillis()+") Entering state 2 of 10 10% complete \"State1\"");
/**
Fill in locationForm with _eventId as search and phoneNumber.fullNumber as unique string of length 10 starting with My

*/
form = getFormById("locationForm");
setAttributeValue(form, "_eventId", "search");
input = form.getInputByName("phoneNumber.fullNumber");
input.setValueAttribute(createString("My", 10));

step = "State2";
log(System.currentTimeMillis()+") Entering state 3 of 10 20% complete \"State2\"");
/**
Path _eventId_search is /html/body
Click on _eventId_search and wait 10 seconds
*/
findAndClick("/html/body");
Thread.sleep(10000);

step = "State3";
log(System.currentTimeMillis()+") Entering state 4 of 10 30% complete \"State3\"");
/**
Fill in locationForm with _eventId as search and phoneNumber.fullNumber as unique string of length 10 starting with My

*/
form = getFormById("locationForm");
setAttributeValue(form, "_eventId", "search");
input = form.getInputByName("phoneNumber.fullNumber");
input.setValueAttribute(createString("My", 10));

step = "State4";
log(System.currentTimeMillis()+") Entering state 5 of 10 40% complete \"State4\"");
/**
Path _eventId_search is /html/body
Click on _eventId_search and wait 10 seconds
*/
findAndClick("/html/body");
Thread.sleep(10000);

step = "State5";
log(System.currentTimeMillis()+") Entering state 6 of 10 50% complete \"State5\"");
/**
Fill in locationForm with _eventId as search and phoneNumber.fullNumber as unique string of length 10 starting with " My "

*/
form = getFormById("locationForm");
setAttributeValue(form, "_eventId", "search");
input = form.getInputByName("phoneNumber.fullNumber");
input.setValueAttribute(createString(" My ", 10));

step = "State6";
log(System.currentTimeMillis()+") Entering state 7 of 10 60% complete \"State6\"");
/**
Path _eventId_search is /html/body
Click on _eventId_search and wait 10 seconds
*/
findAndClick("/html/body");
Thread.sleep(10000);

step = "State7";
log(System.currentTimeMillis()+") Entering state 8 of 10 70% complete \"State7\"");
/**
Fill in locationForm with _eventId as search and phoneNumber.fullNumber as unique string of length 10 starting with " M y "

*/
form = getFormById("locationForm");
setAttributeValue(form, "_eventId", "search");
input = form.getInputByName("phoneNumber.fullNumber");
input.setValueAttribute(createString(" M y ", 10));

step = "State8";
log(System.currentTimeMillis()+") Entering state 9 of 10 80% complete \"State8\"");
/**
Path _eventId_search is /html/body
Click on _eventId_search and wait 10 seconds
*/
findAndClick("/html/body");
Thread.sleep(10000);

step = "State9";
log(System.currentTimeMillis()+") Entering state 10 of 10 90% complete \"State9\"");
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

private void findAndClick(String xpath) throws Exception {
 matchingElement = (ArrayList<HtmlElement>) page.getByXPath(xpath);
 if (matchingElement.size() == 0) {
  log(page.asXml());
  findClosestXpath(xpath);
  fail("Faild to find element " + xpath + "");
 }
 page = matchingElement.get(0).click();
}


}
