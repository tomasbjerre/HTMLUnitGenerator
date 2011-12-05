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
Path Website is /html/body/

Url url1 is http://bjurr.se/

Go to url1
Find a with attribute href set to /link/category/blandat and attribute id set to somethingelse
Find a with attribute href set to /link/category/blandat and attribute id set to "something else"
Find a with attribute href set to /link/category/blandat or attribute id set to somethingelse
Find a with attribute href set to /link/category/blandat or attribute id set to "something else"
Find a with attribute href set to /link/category/blandat or attribute id set to somethingelse or attribute id set to somethingelse2
Find a with attribute href set to /link/category/blandat or attribute id set to "something else" or attribute id set to "something else 2"
Find a with attribute href set to /link/category/blandat or attribute id set to somethingelse and attribute id2 set to somethingelse2
Find a with attribute href set to /link/category/blandat or attribute id set to "something else" and attribute id2 set to "something else 2"
*/

@SuppressWarnings("unchecked")
public class FindMultipleAttributesInSameTag extends TestCase {
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


log(System.currentTimeMillis()+") Entering state 1 of 2 0% complete \"start\"");
/**
Url url1 is http://bjurr.se/
Go to url1
*/
page = webClient.getPage("http://bjurr.se/");

step = "State1";
log(System.currentTimeMillis()+") Entering state 2 of 2 50% complete \"State1\"");
/**
Find a with attribute href set to /link/category/blandat and attribute id set to somethingelse
*/
findOrFail("/html/body", "a", "href", "/link/category/blandat", "http://bjurr.se/", 0);
findOrFail("/html/body", "a", "id", "somethingelse", "http://bjurr.se/", 0);
/**
Find a with attribute href set to /link/category/blandat and attribute id set to "something else"
*/
findOrFail("/html/body", "a", "href", "/link/category/blandat", "http://bjurr.se/", 0);
findOrFail("/html/body", "a", "id", "something else", "http://bjurr.se/", 0);
/**
Find a with attribute href set to /link/category/blandat or attribute id set to somethingelse
*/
findOrFail("/html/body", "a", "href", "/link/category/blandat", "http://bjurr.se/", 0);
findOrFail("/html/body", "a", "id", "somethingelse", "http://bjurr.se/", 0);
/**
Find a with attribute href set to /link/category/blandat or attribute id set to "something else"
*/
findOrFail("/html/body", "a", "href", "/link/category/blandat", "http://bjurr.se/", 0);
findOrFail("/html/body", "a", "id", "something else", "http://bjurr.se/", 0);
/**
Find a with attribute href set to /link/category/blandat or attribute id set to somethingelse or attribute id set to somethingelse2
*/
findOrFail("/html/body", "a", "href", "/link/category/blandat", "http://bjurr.se/", 0);
findOrFail("/html/body", "a", "id", "somethingelse", "http://bjurr.se/", 0);
findOrFail("/html/body", "a", "id", "somethingelse2", "http://bjurr.se/", 0);
/**
Find a with attribute href set to /link/category/blandat or attribute id set to "something else" or attribute id set to "something else 2"
*/
findOrFail("/html/body", "a", "href", "/link/category/blandat", "http://bjurr.se/", 0);
findOrFail("/html/body", "a", "id", "something else", "http://bjurr.se/", 0);
findOrFail("/html/body", "a", "id", "something else 2", "http://bjurr.se/", 0);
/**
Find a with attribute href set to /link/category/blandat or attribute id set to somethingelse and attribute id2 set to somethingelse2
*/
findOrFail("/html/body", "a", "href", "/link/category/blandat", "http://bjurr.se/", 0);
findOrFail("/html/body", "a", "id", "somethingelse", "http://bjurr.se/", 0);
findOrFail("/html/body", "a", "id2", "somethingelse2", "http://bjurr.se/", 0);
/**
Find a with attribute href set to /link/category/blandat or attribute id set to "something else" and attribute id2 set to "something else 2"
*/
findOrFail("/html/body", "a", "href", "/link/category/blandat", "http://bjurr.se/", 0);
findOrFail("/html/body", "a", "id", "something else", "http://bjurr.se/", 0);
findOrFail("/html/body", "a", "id2", "something else 2", "http://bjurr.se/", 0);
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

private void findOrFail(String xpath, String tag, String attribute, String value, String currentUrl, int waitAtMost) throws InterruptedException {
 boolean successfull = false;
 long endTime = System.currentTimeMillis() + waitAtMost;
 log("Looking for "+tag+" with attribute "+attribute+" and value "+value+" in "+xpath);
 do {
   webClient.waitForBackgroundJavaScriptStartingBefore(100);
   successfull = find(xpath, tag, attribute, value);
   if (!successfull) {
    log("\n\nDid not find "+tag+" with given attributes, found these tags of same type:");
    logAllTags((List<DomNode>)page.getByXPath(xpath),tag);
   }
 } while (!successfull && (endTime-System.currentTimeMillis()) > 0);
 if (successfull)
   log(" took "+(System.currentTimeMillis() - endTime + waitAtMost) + "ms");
 if (!successfull) {
   log(page.asXml());
   findClosestXpath(xpath);
   fail(step+") Failed finding tag \""+tag+"\" with attribute \""+attribute+"\" and value \""+value+"\" in \""+xpath+"\" at \""+currentUrl+"\"");
 }
}

private void findOrFail(String xpath, String content, String currentUrl, int waitAtMost) throws InterruptedException {
boolean successfull = false;
long endTime = System.currentTimeMillis() + waitAtMost;
log("Looking for "+content+" in "+xpath);
do {
webClient.waitForBackgroundJavaScriptStartingBefore(100);
successfull = find(xpath, content, value);
if (!successfull) {
log("

Did not find "+content);
}
} while (!successfull && (endTime-System.currentTimeMillis()) > 0);
if (successfull)
log(" took "+(System.currentTimeMillis() - endTime + waitAtMost) + "ms");
if (!successfull) {
log(page.asXml());
findClosestXpath(xpath);
}
return successfull;
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

}
