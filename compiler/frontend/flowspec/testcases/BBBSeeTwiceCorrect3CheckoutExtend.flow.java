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

Go to baspaket and wait 2 seconds
Find a with attribute href set to /servlet/orderflow/search/search-flow?Id=tcm:142-23371 in campaignmodule
Click on campaignModuleChoose and wait 10 seconds
Find input with attribute id set to _eventId_search in searchpopup
Fill in locationForm with _eventId as search and phoneNumber.fullNumber as 0768966787

Click on _eventId_search and wait 10 seconds
Find input with attribute id set to _eventId_search in searchpopup
Fill in locationForm with address.floor as 3

Click on _eventId_search and wait 10 seconds
Find a with attribute href set to /orderflow/index.html?Id=tcm:142-23381&fromSearch&page=new in searchpopup
Click on searchPopupChooseFoundOffer and wait 10 seconds
Find option with attribute value set to dsl24 in orderCartArea
Click on checkoutOrder and wait 10 seconds
Find input with attribute src set to /res/img/button/tillbaka.png in website
Click on searchPopupChooseFoundOffer and wait 10 seconds
Find option with attribute value set to dsl24 in orderCartArea
Click on checkoutOrder and wait 10 seconds
Find input with attribute src set to /res/img/button/tillbaka.png in website
Click on searchPopupChooseFoundOffer and wait 10 seconds
Find option with attribute value set to dsl24 in orderCartArea
Click on checkoutOrder and wait 10 seconds
Find input with attribute src set to /res/img/button/tillbaka.png in website
*/

@SuppressWarnings("unchecked")
public class BBBSeeTwiceCorrect3CheckoutExtend extends TestCase {
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
Url baspaket is http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html
Go to baspaket and wait 2 seconds
*/
page = webClient.getPage("http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html");
Thread.sleep(2000);

step = "State1";
log(System.currentTimeMillis()+") Entering state 2 of 13 7% complete \"State1\"");
/**
Find a with attribute href set to /servlet/orderflow/search/search-flow?Id=tcm:142-23371 in campaignmodule
*/
findOrFail("/html/body/div[2]/div/div[2]/div[2]/div/div[3]", "a", "href", "/servlet/orderflow/search/search-flow?Id=tcm:142-23371", "http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html", 0);
/**
Path campaignModuleChoose is /html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/span/a/span
Click on campaignModuleChoose and wait 10 seconds
*/
findAndClick("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/span/a/span");
Thread.sleep(10000);

step = "State2";
log(System.currentTimeMillis()+") Entering state 3 of 13 15% complete \"State2\"");
/**
Find input with attribute id set to _eventId_search in searchpopup
*/
findOrFail("/html/body/div[7]/div/div[9]", "input", "id", "_eventId_search", "http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html", 0);
/**
Fill in locationForm with _eventId as search and phoneNumber.fullNumber as 0768966787

*/
form = getFormById("locationForm");
setAttributeValue(form, "_eventId", "search");
setAttributeValue(form, "phoneNumber.fullNumber", "0768966787");

step = "State3";
log(System.currentTimeMillis()+") Entering state 4 of 13 23% complete \"State3\"");
/**
Path _eventId_search is //*[@id="_eventId_search"]
Click on _eventId_search and wait 10 seconds
*/
findAndClick("//*[@id=\"_eventId_search\"]");
Thread.sleep(10000);

step = "State4";
log(System.currentTimeMillis()+") Entering state 5 of 13 30% complete \"State4\"");
/**
Find input with attribute id set to _eventId_search in searchpopup
*/
findOrFail("/html/body/div[7]/div/div[9]", "input", "id", "_eventId_search", "http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html", 0);
/**
Fill in locationForm with address.floor as 3

*/
form = getFormById("locationForm");
setAttributeValue(form, "address.floor", "3");

step = "State5";
log(System.currentTimeMillis()+") Entering state 6 of 13 38% complete \"State5\"");
/**
Path _eventId_search is //*[@id="_eventId_search"]
Click on _eventId_search and wait 10 seconds
*/
findAndClick("//*[@id=\"_eventId_search\"]");
Thread.sleep(10000);

step = "State6";
log(System.currentTimeMillis()+") Entering state 7 of 13 46% complete \"State6\"");
/**
Find a with attribute href set to /orderflow/index.html?Id=tcm:142-23381&fromSearch&page=new in searchpopup
*/
findOrFail("/html/body/div[7]/div/div[9]", "a", "href", "/orderflow/index.html?Id=tcm:142-23381&fromSearch&page=new", "http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html", 0);
/**
Path searchPopupChooseFoundOffer is /html/body/div[8]/div/div[9]/form[2]/div[2]/div[1]/div/div[2]/a[1]
Click on searchPopupChooseFoundOffer and wait 10 seconds
*/
findAndClick("/html/body/div[8]/div/div[9]/form[2]/div[2]/div[1]/div/div[2]/a[1]");
Thread.sleep(10000);

step = "State7";
log(System.currentTimeMillis()+") Entering state 8 of 13 53% complete \"State7\"");
/**
Find option with attribute value set to dsl24 in orderCartArea
*/
findOrFail("/html/body/div[2]/div/div/div/div[3]/form/div[2]/div[2]/div[3]", "option", "value", "dsl24", "http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html", 0);
/**
Path checkoutOrder is //*[@id="orderButton"]
Click on checkoutOrder and wait 10 seconds
*/
findAndClick("//*[@id=\"orderButton\"]");
Thread.sleep(10000);

step = "State8";
log(System.currentTimeMillis()+") Entering state 9 of 13 61% complete \"State8\"");
/**
Find input with attribute src set to /res/img/button/tillbaka.png in website
*/
findOrFail("/html/body", "input", "src", "/res/img/button/tillbaka.png", "http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html", 0);
/**
Path searchPopupChooseFoundOffer is /html/body/div[8]/div/div[9]/form[2]/div[2]/div[1]/div/div[2]/a[1]
Click on searchPopupChooseFoundOffer and wait 10 seconds
*/
findAndClick("/html/body/div[8]/div/div[9]/form[2]/div[2]/div[1]/div/div[2]/a[1]");
Thread.sleep(10000);

step = "State9";
log(System.currentTimeMillis()+") Entering state 10 of 13 69% complete \"State9\"");
/**
Find option with attribute value set to dsl24 in orderCartArea
*/
findOrFail("/html/body/div[2]/div/div/div/div[3]/form/div[2]/div[2]/div[3]", "option", "value", "dsl24", "http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html", 0);
/**
Path checkoutOrder is //*[@id="orderButton"]
Click on checkoutOrder and wait 10 seconds
*/
findAndClick("//*[@id=\"orderButton\"]");
Thread.sleep(10000);

step = "State10";
log(System.currentTimeMillis()+") Entering state 11 of 13 76% complete \"State10\"");
/**
Find input with attribute src set to /res/img/button/tillbaka.png in website
*/
findOrFail("/html/body", "input", "src", "/res/img/button/tillbaka.png", "http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html", 0);
/**
Path searchPopupChooseFoundOffer is /html/body/div[8]/div/div[9]/form[2]/div[2]/div[1]/div/div[2]/a[1]
Click on searchPopupChooseFoundOffer and wait 10 seconds
*/
findAndClick("/html/body/div[8]/div/div[9]/form[2]/div[2]/div[1]/div/div[2]/a[1]");
Thread.sleep(10000);

step = "State11";
log(System.currentTimeMillis()+") Entering state 12 of 13 84% complete \"State11\"");
/**
Find option with attribute value set to dsl24 in orderCartArea
*/
findOrFail("/html/body/div[2]/div/div/div/div[3]/form/div[2]/div[2]/div[3]", "option", "value", "dsl24", "http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html", 0);
/**
Path checkoutOrder is //*[@id="orderButton"]
Click on checkoutOrder and wait 10 seconds
*/
findAndClick("//*[@id=\"orderButton\"]");
Thread.sleep(10000);

step = "State12";
log(System.currentTimeMillis()+") Entering state 13 of 13 92% complete \"State12\"");
/**
Find input with attribute src set to /res/img/button/tillbaka.png in website
*/
findOrFail("/html/body", "input", "src", "/res/img/button/tillbaka.png", "http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html", 0);
webClient.closeAllWindows();
}

private void log(String string) {
 System.out.println(string);
}

private void findOrFail(String xpath, String tag, String attribute, String value, String currentUrl, int waitAtMost) throws InterruptedException {
 boolean successfull = false;
 long endTime = System.currentTimeMillis() + waitAtMost*1000;
 log("Looking for "+tag+" with attribute "+attribute+" and value "+value+" in "+xpath);
 while (!successfull || (endTime-System.currentTimeMillis()) > 0) {
   successfull = find(xpath, tag, attribute, value);
   if (!successfull)
    System.out.print(".");
    webClient.waitForBackgroundJavaScriptStartingBefore(100);
   }
   if (successfull)
    log(" took "+(System.currentTimeMillis() - endTime - waitAtMost*1000) + "ms");
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
