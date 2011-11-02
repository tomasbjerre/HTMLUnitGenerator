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
Path website is /html/body
Path _eventId_search is //*[@id="_eventId_search"]
Path bbCampaignModuleChoose is /html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/span/a/span
Path searchFlowChooseFoundOffer is /html/body/div[8]/div/div[9]/form[2]/div[2]/div[1]/div/div[2]/a[1]
Path ordercartCheckoutOrder is //*[@id="orderButton"]
Path ordercartSelectBroadband is //*[@id="broadband-tcmUri"]
Path orderCartSelectDSL8 is /html/body/div[6]/div/div/div[9]/div/div[2]/div/div[2]/table/tbody/tr/td/table/tbody/tr/td/div/span/input
Path searchFlowUseAddress is //*[@id="checkboxIHaveNoPhoneLine"]

Url broadbandLAN100 is http://www.bredbandsbolaget.se/bredband/hastighet/bredband100/index.html

Go to broadbandLAN100
Find a with attribute href set to /servlet/orderflow/search/search-flow?Id=tcm:142-23384&draggable=false in website or wait at most 20 seconds
Click on bbCampaignModuleChoose
Find input with attribute id set to _eventId_search in website or wait at most 20 seconds
Fill in locationForm with _eventId as search and phoneNumber.fullNumber as 12345678901

Click on _eventId_search
Find input with attribute id set to _eventId_search in website or wait at most 20 seconds
Fill in locationForm with address.street as arklimästaregatan and address.streetNumberAndEntrance as 30 and address.zipCode as 37135

Click on _eventId_search
Find input with attribute id set to _eventId_search in website or wait at most 20 seconds
Fill in locationForm with address.floor as option number 1

Click on _eventId_search
Find a with attribute href set to /orderflow/index.html?Id=tcm:142-23381&fromSearch&page=new in website or wait at most 20 seconds
Click on searchFlowChooseFoundOffer
Find input with attribute value set to tcm:142-23267 in website or wait at most 20 seconds
Click on ordercartSelectBroadband
Find input with attribute value set to tcm:142-23270 in website or wait at most 20 seconds
Click on orderCartSelectDSL8 and wait 1 seconds
Find input with attribute value set to tcm:142-23270 in website or wait at most 20 seconds
Click on ordercartCheckoutOrder
Find input with attribute src set to /res/img/button/tillbaka.png in website or wait at most 20 seconds
*/

@SuppressWarnings("unchecked")
public class TestToPersonalDetailsWithDSL8FailAtPhoneSearchUseAddress extends TestCase {
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


log(System.currentTimeMillis()+") Entering state 1 of 13 0% complete \"start\"");
/**
Url broadbandLAN100 is http://www.bredbandsbolaget.se/bredband/hastighet/bredband100/index.html
Go to broadbandLAN100
*/
page = webClient.getPage("http://www.bredbandsbolaget.se/bredband/hastighet/bredband100/index.html");

step = "State1";
log(System.currentTimeMillis()+") Entering state 2 of 13 7% complete \"State1\"");
/**
Find a with attribute href set to /servlet/orderflow/search/search-flow?Id=tcm:142-23384&draggable=false in website or wait at most 20 seconds
*/
findOrFail("/html/body", "a", "href", "/servlet/orderflow/search/search-flow?Id=tcm:142-23384&draggable=false", "http://www.bredbandsbolaget.se/bredband/hastighet/bredband100/index.html", 20000);
/**
Path bbCampaignModuleChoose is /html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/span/a/span
Click on bbCampaignModuleChoose
*/
findAndClick("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/span/a/span");

step = "State2";
log(System.currentTimeMillis()+") Entering state 3 of 13 15% complete \"State2\"");
/**
Find input with attribute id set to _eventId_search in website or wait at most 20 seconds
*/
findOrFail("/html/body", "input", "id", "_eventId_search", "http://www.bredbandsbolaget.se/bredband/hastighet/bredband100/index.html", 20000);
/**
Fill in locationForm with _eventId as search and phoneNumber.fullNumber as 12345678901

*/
form = getFormById("locationForm");
setAttributeValue(form, "_eventId", "search");
setAttributeValue(form, "phoneNumber.fullNumber", "12345678901");

step = "State3";
log(System.currentTimeMillis()+") Entering state 4 of 13 23% complete \"State3\"");
/**
Path _eventId_search is //*[@id="_eventId_search"]
Click on _eventId_search
*/
findAndClick("//*[@id=\"_eventId_search\"]");

step = "State4";
log(System.currentTimeMillis()+") Entering state 5 of 13 30% complete \"State4\"");
/**
Find input with attribute id set to _eventId_search in website or wait at most 20 seconds
*/
findOrFail("/html/body", "input", "id", "_eventId_search", "http://www.bredbandsbolaget.se/bredband/hastighet/bredband100/index.html", 20000);
/**
Fill in locationForm with address.street as arklimästaregatan and address.streetNumberAndEntrance as 30 and address.zipCode as 37135

*/
form = getFormById("locationForm");
setAttributeValue(form, "address.street", "arklimästaregatan");
setAttributeValue(form, "address.streetNumberAndEntrance", "30");
setAttributeValue(form, "address.zipCode", "37135");

step = "State5";
log(System.currentTimeMillis()+") Entering state 6 of 13 38% complete \"State5\"");
/**
Path _eventId_search is //*[@id="_eventId_search"]
Click on _eventId_search
*/
findAndClick("//*[@id=\"_eventId_search\"]");

step = "State6";
log(System.currentTimeMillis()+") Entering state 7 of 13 46% complete \"State6\"");
/**
Find input with attribute id set to _eventId_search in website or wait at most 20 seconds
*/
findOrFail("/html/body", "input", "id", "_eventId_search", "http://www.bredbandsbolaget.se/bredband/hastighet/bredband100/index.html", 20000);
/**
Fill in locationForm with address.floor as option number 1

*/
form = getFormById("locationForm");
select = form.getSelectByName("address.floor");
select.setSelectedAttribute(select.getOption(1), true);

step = "State7";
log(System.currentTimeMillis()+") Entering state 8 of 13 53% complete \"State7\"");
/**
Path _eventId_search is //*[@id="_eventId_search"]
Click on _eventId_search
*/
findAndClick("//*[@id=\"_eventId_search\"]");

step = "State8";
log(System.currentTimeMillis()+") Entering state 9 of 13 61% complete \"State8\"");
/**
Find a with attribute href set to /orderflow/index.html?Id=tcm:142-23381&fromSearch&page=new in website or wait at most 20 seconds
*/
findOrFail("/html/body", "a", "href", "/orderflow/index.html?Id=tcm:142-23381&fromSearch&page=new", "http://www.bredbandsbolaget.se/bredband/hastighet/bredband100/index.html", 20000);
/**
Path searchFlowChooseFoundOffer is /html/body/div[8]/div/div[9]/form[2]/div[2]/div[1]/div/div[2]/a[1]
Click on searchFlowChooseFoundOffer
*/
findAndClick("/html/body/div[8]/div/div[9]/form[2]/div[2]/div[1]/div/div[2]/a[1]");

step = "State9";
log(System.currentTimeMillis()+") Entering state 10 of 13 69% complete \"State9\"");
/**
Find input with attribute value set to tcm:142-23267 in website or wait at most 20 seconds
*/
findOrFail("/html/body", "input", "value", "tcm:142-23267", "http://www.bredbandsbolaget.se/bredband/hastighet/bredband100/index.html", 20000);
/**
Path ordercartSelectBroadband is //*[@id="broadband-tcmUri"]
Click on ordercartSelectBroadband
*/
findAndClick("//*[@id=\"broadband-tcmUri\"]");

step = "State10";
log(System.currentTimeMillis()+") Entering state 11 of 13 76% complete \"State10\"");
/**
Find input with attribute value set to tcm:142-23270 in website or wait at most 20 seconds
*/
findOrFail("/html/body", "input", "value", "tcm:142-23270", "http://www.bredbandsbolaget.se/bredband/hastighet/bredband100/index.html", 20000);
/**
Path orderCartSelectDSL8 is /html/body/div[6]/div/div/div[9]/div/div[2]/div/div[2]/table/tbody/tr/td/table/tbody/tr/td/div/span/input
Click on orderCartSelectDSL8 and wait 1 seconds
*/
findAndClick("/html/body/div[6]/div/div/div[9]/div/div[2]/div/div[2]/table/tbody/tr/td/table/tbody/tr/td/div/span/input");
Thread.sleep(1000);

step = "State11";
log(System.currentTimeMillis()+") Entering state 12 of 13 84% complete \"State11\"");
/**
Find input with attribute value set to tcm:142-23270 in website or wait at most 20 seconds
*/
findOrFail("/html/body", "input", "value", "tcm:142-23270", "http://www.bredbandsbolaget.se/bredband/hastighet/bredband100/index.html", 20000);
/**
Path ordercartCheckoutOrder is //*[@id="orderButton"]
Click on ordercartCheckoutOrder
*/
findAndClick("//*[@id=\"orderButton\"]");

step = "State12";
log(System.currentTimeMillis()+") Entering state 13 of 13 92% complete \"State12\"");
/**
Find input with attribute src set to /res/img/button/tillbaka.png in website or wait at most 20 seconds
*/
findOrFail("/html/body", "input", "src", "/res/img/button/tillbaka.png", "http://www.bredbandsbolaget.se/bredband/hastighet/bredband100/index.html", 20000);
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
