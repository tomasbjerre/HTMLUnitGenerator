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
Path Website is /html/body
Path _eventId_search is //*[@id="_eventId_search"]
Path BBCampaignModuleChoose is /html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/span/a/span
Path SearchFlowUseAddress is //*[@id="checkboxIHaveNoPhoneLine"]
Path SearchFlowChooseFoundOffer is /html/body/div[8]/div/div[9]/form[2]/div[2]/div[1]/div/div[2]/a[1]
Path OrderCartCheckoutOrder is //*[@id="orderButton"]
Path OrderCartSelectBroadband is //*[@id="broadband-tcmUri"]
Path OrderCartSelectDSL8 is /html/body/div[6]/div/div/div[9]/div/div[2]/div/div[2]/table/tbody/tr/td/table/tbody/tr/td/div/span/input

Url BroadbandLAN100 is http://www.bredbandsbolaget.se/bredband/hastighet/bredband100/index.html
Url BroadbandDSL24 is http://www.bredbandsbolaget.se/bredband/hastighet/bredband24/index.html

Go to BroadbandLAN100
Find a with attribute href set to /servlet/orderflow/search/search-flow?Id=tcm:142-23384&draggable=false in Website or wait at most 200 seconds
Click on BBCampaignModuleChoose
Find input with attribute name set to phoneNumber.fullNumber in Website or wait at most 200 seconds
Fill in locationForm with _eventId as search and phoneNumber.fullNumber as 0768966787

Click on _eventId_search
Find select with attribute name set to address.floor in Website or wait at most 200 seconds
Fill in locationForm with address.floor as option number 1

Click on _eventId_search
Find a with attribute href set to /orderflow/index.html?Id=tcm:142-23381&fromSearch&page=new in Website or wait at most 200 seconds
Click on SearchFlowChooseFoundOffer
Find input with attribute value set to tcm:142-23267 in Website or wait at most 200 seconds
Click on OrderCartSelectBroadband
Find input with attribute value set to tcm:142-23270 in Website or wait at most 200 seconds
Click on OrderCartSelectDSL8 and wait 1 seconds
Find input with attribute value set to tcm:142-23270 in Website or wait at most 200 seconds
Click on OrderCartCheckoutOrder
Find input with attribute id set to firstName in Website or wait at most 200 seconds
*/

@SuppressWarnings("unchecked")
public class TestToPersonalDetailsViaSearchResultWithDSL8UsingPhoneNumber extends TestCase {
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


log(System.currentTimeMillis()+") Entering state 1 of 11 0% complete \"start\"");
/**
Url BroadbandLAN100 is http://www.bredbandsbolaget.se/bredband/hastighet/bredband100/index.html
Go to BroadbandLAN100
*/
page = webClient.getPage("http://www.bredbandsbolaget.se/bredband/hastighet/bredband100/index.html");

step = "State1";
log(System.currentTimeMillis()+") Entering state 2 of 11 9% complete \"State1\"");
/**
Find a with attribute href set to /servlet/orderflow/search/search-flow?Id=tcm:142-23384&draggable=false in Website or wait at most 200 seconds
*/
findOrFail("/html/body", "a", "href", "/servlet/orderflow/search/search-flow?Id=tcm:142-23384&draggable=false", "http://www.bredbandsbolaget.se/bredband/hastighet/bredband100/index.html", 200000);
/**
Path BBCampaignModuleChoose is /html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/span/a/span
Click on BBCampaignModuleChoose
*/
findAndClick("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/span/a/span");

step = "State2";
log(System.currentTimeMillis()+") Entering state 3 of 11 18% complete \"State2\"");
/**
Find input with attribute name set to phoneNumber.fullNumber in Website or wait at most 200 seconds
*/
findOrFail("/html/body", "input", "name", "phoneNumber.fullNumber", "http://www.bredbandsbolaget.se/bredband/hastighet/bredband100/index.html", 200000);
/**
Fill in locationForm with _eventId as search and phoneNumber.fullNumber as 0768966787

*/
form = getFormById("locationForm");
setAttributeValue(form, "_eventId", "search");
setAttributeValue(form, "phoneNumber.fullNumber", "0768966787");

step = "State3";
log(System.currentTimeMillis()+") Entering state 4 of 11 27% complete \"State3\"");
/**
Path _eventId_search is //*[@id="_eventId_search"]
Click on _eventId_search
*/
findAndClick("//*[@id=\"_eventId_search\"]");

step = "State4";
log(System.currentTimeMillis()+") Entering state 5 of 11 36% complete \"State4\"");
/**
Find select with attribute name set to address.floor in Website or wait at most 200 seconds
*/
findOrFail("/html/body", "select", "name", "address.floor", "http://www.bredbandsbolaget.se/bredband/hastighet/bredband100/index.html", 200000);
/**
Fill in locationForm with address.floor as option number 1

*/
form = getFormById("locationForm");
select = form.getSelectByName("address.floor");
select.setSelectedAttribute(select.getOption(1), true);

step = "State5";
log(System.currentTimeMillis()+") Entering state 6 of 11 45% complete \"State5\"");
/**
Path _eventId_search is //*[@id="_eventId_search"]
Click on _eventId_search
*/
findAndClick("//*[@id=\"_eventId_search\"]");

step = "State6";
log(System.currentTimeMillis()+") Entering state 7 of 11 54% complete \"State6\"");
/**
Find a with attribute href set to /orderflow/index.html?Id=tcm:142-23381&fromSearch&page=new in Website or wait at most 200 seconds
*/
findOrFail("/html/body", "a", "href", "/orderflow/index.html?Id=tcm:142-23381&fromSearch&page=new", "http://www.bredbandsbolaget.se/bredband/hastighet/bredband100/index.html", 200000);
/**
Path SearchFlowChooseFoundOffer is /html/body/div[8]/div/div[9]/form[2]/div[2]/div[1]/div/div[2]/a[1]
Click on SearchFlowChooseFoundOffer
*/
findAndClick("/html/body/div[8]/div/div[9]/form[2]/div[2]/div[1]/div/div[2]/a[1]");

step = "State7";
log(System.currentTimeMillis()+") Entering state 8 of 11 63% complete \"State7\"");
/**
Find input with attribute value set to tcm:142-23267 in Website or wait at most 200 seconds
*/
findOrFail("/html/body", "input", "value", "tcm:142-23267", "http://www.bredbandsbolaget.se/bredband/hastighet/bredband100/index.html", 200000);
/**
Path OrderCartSelectBroadband is //*[@id="broadband-tcmUri"]
Click on OrderCartSelectBroadband
*/
findAndClick("//*[@id=\"broadband-tcmUri\"]");

step = "State8";
log(System.currentTimeMillis()+") Entering state 9 of 11 72% complete \"State8\"");
/**
Find input with attribute value set to tcm:142-23270 in Website or wait at most 200 seconds
*/
findOrFail("/html/body", "input", "value", "tcm:142-23270", "http://www.bredbandsbolaget.se/bredband/hastighet/bredband100/index.html", 200000);
/**
Path OrderCartSelectDSL8 is /html/body/div[6]/div/div/div[9]/div/div[2]/div/div[2]/table/tbody/tr/td/table/tbody/tr/td/div/span/input
Click on OrderCartSelectDSL8 and wait 1 seconds
*/
findAndClick("/html/body/div[6]/div/div/div[9]/div/div[2]/div/div[2]/table/tbody/tr/td/table/tbody/tr/td/div/span/input");
Thread.sleep(1000);

step = "State9";
log(System.currentTimeMillis()+") Entering state 10 of 11 81% complete \"State9\"");
/**
Find input with attribute value set to tcm:142-23270 in Website or wait at most 200 seconds
*/
findOrFail("/html/body", "input", "value", "tcm:142-23270", "http://www.bredbandsbolaget.se/bredband/hastighet/bredband100/index.html", 200000);
/**
Path OrderCartCheckoutOrder is //*[@id="orderButton"]
Click on OrderCartCheckoutOrder
*/
findAndClick("//*[@id=\"orderButton\"]");

step = "State10";
log(System.currentTimeMillis()+") Entering state 11 of 11 90% complete \"State10\"");
/**
Find input with attribute id set to firstName in Website or wait at most 200 seconds
*/
findOrFail("/html/body", "input", "id", "firstName", "http://www.bredbandsbolaget.se/bredband/hastighet/bredband100/index.html", 200000);
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
