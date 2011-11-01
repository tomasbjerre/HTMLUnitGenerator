package webtest;
import org.junit.Test;

import org.w3c.dom.Node;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.*;
import java.util.*;

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

Go to onegbit
Find a with attribute href set to /servlet/orderflow/search/search-flow?Id=tcm:142-32724&draggable=false in website or wait at most 20 seconds
Click on bbCampaignModuleChoose
Find input with attribute id set to _eventId_search in website or wait at most 20 seconds
Fill in locationForm with _eventId as search and phoneNumber.fullNumber as 0768966787

Click on _eventId_search
Find input with attribute id set to _eventId_search in website or wait at most 20 seconds
Fill in locationForm with address.floor as option number 1

Click on _eventId_search
Find a with attribute href set to /orderflow/index.html?Id=tcm:142-23381&fromSearch&page=new in website or wait at most 20 seconds
Click on searchPopupChooseFoundOffer
Find input with attribute value set to tcm:142-23267 in website or wait at most 20 seconds
Click on checkoutOrder
Find input with attribute src set to /res/img/button/tillbaka.png in website or wait at most 20 seconds
*/

@SuppressWarnings("unchecked")
public class TestFromSearchResultsToPersonaldetailsDSL24 extends TestCase {
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


log(System.currentTimeMillis()+") Entering state 1 of 9 0% complete \"start\"");
/**
Url onegbit is http://www.bredbandsbolaget.se/bredband/bredband1000/index.html
Go to onegbit
*/
page = webClient.getPage("http://www.bredbandsbolaget.se/bredband/bredband1000/index.html");

step = "State1";
log(System.currentTimeMillis()+") Entering state 2 of 9 11% complete \"State1\"");
/**
Find a with attribute href set to /servlet/orderflow/search/search-flow?Id=tcm:142-32724&draggable=false in website or wait at most 20 seconds
*/
findOrFail("/html/body", "a", "href", "/servlet/orderflow/search/search-flow?Id=tcm:142-32724&draggable=false", "http://www.bredbandsbolaget.se/bredband/bredband1000/index.html", 20000);
/**
Path bbCampaignModuleChoose is /html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/div[3]/span[4]/a/span
Click on bbCampaignModuleChoose
*/
findAndClick("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/div[3]/span[4]/a/span");

step = "State2";
log(System.currentTimeMillis()+") Entering state 3 of 9 22% complete \"State2\"");
/**
Find input with attribute id set to _eventId_search in website or wait at most 20 seconds
*/
findOrFail("/html/body", "input", "id", "_eventId_search", "http://www.bredbandsbolaget.se/bredband/bredband1000/index.html", 20000);
/**
Fill in locationForm with _eventId as search and phoneNumber.fullNumber as 0768966787

*/
form = getFormById("locationForm");
setAttributeValue(form, "_eventId", "search");
setAttributeValue(form, "phoneNumber.fullNumber", "0768966787");

step = "State3";
log(System.currentTimeMillis()+") Entering state 4 of 9 33% complete \"State3\"");
/**
Path _eventId_search is //*[@id="_eventId_search"]
Click on _eventId_search
*/
findAndClick("//*[@id=\"_eventId_search\"]");

step = "State4";
log(System.currentTimeMillis()+") Entering state 5 of 9 44% complete \"State4\"");
/**
Find input with attribute id set to _eventId_search in website or wait at most 20 seconds
*/
findOrFail("/html/body", "input", "id", "_eventId_search", "http://www.bredbandsbolaget.se/bredband/bredband1000/index.html", 20000);
/**
Fill in locationForm with address.floor as option number 1

*/
form = getFormById("locationForm");
select = form.getSelectByName("address.floor");
select.setSelectedAttribute(select.getOption(1), true);

step = "State5";
log(System.currentTimeMillis()+") Entering state 6 of 9 55% complete \"State5\"");
/**
Path _eventId_search is //*[@id="_eventId_search"]
Click on _eventId_search
*/
findAndClick("//*[@id=\"_eventId_search\"]");

step = "State6";
log(System.currentTimeMillis()+") Entering state 7 of 9 66% complete \"State6\"");
/**
Find a with attribute href set to /orderflow/index.html?Id=tcm:142-23381&fromSearch&page=new in website or wait at most 20 seconds
*/
findOrFail("/html/body", "a", "href", "/orderflow/index.html?Id=tcm:142-23381&fromSearch&page=new", "http://www.bredbandsbolaget.se/bredband/bredband1000/index.html", 20000);
/**
Path searchPopupChooseFoundOffer is /html/body/div[8]/div/div[9]/form[2]/div[2]/div[1]/div/div[2]/a[1]
Click on searchPopupChooseFoundOffer
*/
findAndClick("/html/body/div[8]/div/div[9]/form[2]/div[2]/div[1]/div/div[2]/a[1]");

step = "State7";
log(System.currentTimeMillis()+") Entering state 8 of 9 77% complete \"State7\"");
/**
Find input with attribute value set to tcm:142-23267 in website or wait at most 20 seconds
*/
findOrFail("/html/body", "input", "value", "tcm:142-23267", "http://www.bredbandsbolaget.se/bredband/bredband1000/index.html", 20000);
/**
Path checkoutOrder is //*[@id="orderButton"]
Click on checkoutOrder
*/
findAndClick("//*[@id=\"orderButton\"]");

step = "State8";
log(System.currentTimeMillis()+") Entering state 9 of 9 88% complete \"State8\"");
/**
Find input with attribute src set to /res/img/button/tillbaka.png in website or wait at most 20 seconds
*/
findOrFail("/html/body", "input", "src", "/res/img/button/tillbaka.png", "http://www.bredbandsbolaget.se/bredband/bredband1000/index.html", 20000);
webClient.closeAllWindows();
}

private void log(String string) {
 System.out.println(string);
}

private void findOrFail(String xpath, String tag, String attribute, String value, String currentUrl, int waitAtMost) throws InterruptedException {
 boolean successfull = false;
 long endTime = System.currentTimeMillis() + waitAtMost;
 log("Looking for "+tag+" with attribute "+attribute+" and value "+value+" in "+xpath);
 while (!successfull && (endTime-System.currentTimeMillis()) > 0) {
   webClient.waitForBackgroundJavaScriptStartingBefore(100);
   successfull = find(xpath, tag, attribute, value);
   if (!successfull)
    System.out.print(".");
   }
   if (successfull)
    log(" took "+(System.currentTimeMillis() - endTime + waitAtMost) + "ms");
   if (!successfull) {
    log(page.asXml());
    findClosestXpath(xpath);
    fail(step+") Failed finding tag \""+tag+"\" with attribute \""+attribute+"\" and value \""+value+"\" in \""+xpath+"\" at \""+currentUrl+"\"");
   }
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
   if (nodeAttribute != null) {    String nodeAttributeValue = nodeAttribute.getNodeValue();
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
private void findAndClick(String xpath) throws Exception {
 matchingElement = (ArrayList<HtmlElement>) page.getByXPath(xpath);
 if (matchingElement.size() == 0) {
  log(page.asXml());
  findClosestXpath(xpath);
  fail("Faild to find element " + xpath + "");
 }
 page = matchingElement.get(0).click();
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


}