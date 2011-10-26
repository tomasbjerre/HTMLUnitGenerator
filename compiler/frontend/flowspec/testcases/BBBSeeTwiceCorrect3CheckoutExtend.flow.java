package webtest;
import org.junit.Test;

import org.w3c.dom.Node;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.*;

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
@Test
public void testHomePage() throws Exception {
 WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER_8);
 webClient.setCssEnabled(true);
 webClient.setJavaScriptEnabled(true);
 webClient.setThrowExceptionOnFailingStatusCode(false);
 webClient.setThrowExceptionOnScriptError(false);
 webClient.setTimeout(180000);
 webClient.setJavaScriptTimeout(180000);
 HtmlPage page = null;
 String step = null;
 boolean successfull = false;
 HtmlForm form = null;
 HtmlInput input = null;
 HtmlSelect select = null;
 ArrayList<HtmlElement> matchingElement = null;


System.out.println(System.currentTimeMillis()+") Entering state 1 of 13 0% complete \"start\"");
/*
Url baspaket is http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html
Go to baspaket and wait 2 seconds
*/
page = webClient.getPage("http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html");
webClient.waitForBackgroundJavaScriptStartingBefore(2000);

step = "State1";
System.out.println(System.currentTimeMillis()+") Entering state 2 of 13 7% complete \"State1\"");
/*
Find a with attribute href set to /servlet/orderflow/search/search-flow?Id=tcm:142-23371 in campaignmodule
*/
successfull = find(page, "/html/body/div[2]/div/div[2]/div[2]/div/div[3]", "a", "href", "/servlet/orderflow/search/search-flow?Id=tcm:142-23371");
if (!successfull) {
 System.out.println(page.asXml());
 fail(step+") Failed finding tag \"a\" with attribute \"href\" and value \"/servlet/orderflow/search/search-flow?Id=tcm:142-23371\" in \"/html/body/div[2]/div/div[2]/div[2]/div/div[3]\" at \"http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html\"");

}
/*
Path campaignModuleChoose is /html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/span/a/span
Click on campaignModuleChoose and wait 10 seconds
*/
matchingElement = (ArrayList<HtmlElement>) page.getByXPath("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/span/a/span");
if (matchingElement.size() == 0) {
 fail("Faild to find element /html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/span/a/span");
 System.out.println(page.asXml());
}page = matchingElement.get(0).click();

webClient.waitForBackgroundJavaScriptStartingBefore(10000);

step = "State2";
System.out.println(System.currentTimeMillis()+") Entering state 3 of 13 15% complete \"State2\"");
/*
Find input with attribute id set to _eventId_search in searchpopup
*/
successfull = find(page, "/html/body/div[7]/div/div[9]", "input", "id", "_eventId_search");
if (!successfull) {
 System.out.println(page.asXml());
 fail(step+") Failed finding tag \"input\" with attribute \"id\" and value \"_eventId_search\" in \"/html/body/div[7]/div/div[9]\" at \"http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html\"");

}
/*
Fill in locationForm with _eventId as search and phoneNumber.fullNumber as 0768966787
*/
form = getFormById(page,"locationForm");
try {
 input = form.getInputByName("_eventId");
 input.setValueAttribute("search");
} catch (ElementNotFoundException e) {
 select = form.getSelectByName("_eventId");
 select.setSelectedAttribute("search", true);
}
try {
 input = form.getInputByName("phoneNumber.fullNumber");
 input.setValueAttribute("0768966787");
} catch (ElementNotFoundException e) {
 select = form.getSelectByName("phoneNumber.fullNumber");
 select.setSelectedAttribute("0768966787", true);
}
webClient.waitForBackgroundJavaScriptStartingBefore(0);

step = "State3";
System.out.println(System.currentTimeMillis()+") Entering state 4 of 13 23% complete \"State3\"");
/*
Path _eventId_search is //*[@id="_eventId_search"]
Click on _eventId_search and wait 10 seconds
*/
matchingElement = (ArrayList<HtmlElement>) page.getByXPath("//*[@id=\"_eventId_search\"]");
if (matchingElement.size() == 0) {
 fail("Faild to find element //*[@id=\"_eventId_search\"]");
 System.out.println(page.asXml());
}page = matchingElement.get(0).click();

webClient.waitForBackgroundJavaScriptStartingBefore(10000);

step = "State4";
System.out.println(System.currentTimeMillis()+") Entering state 5 of 13 30% complete \"State4\"");
/*
Find input with attribute id set to _eventId_search in searchpopup
*/
successfull = find(page, "/html/body/div[7]/div/div[9]", "input", "id", "_eventId_search");
if (!successfull) {
 System.out.println(page.asXml());
 fail(step+") Failed finding tag \"input\" with attribute \"id\" and value \"_eventId_search\" in \"/html/body/div[7]/div/div[9]\" at \"http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html\"");

}
/*
Fill in locationForm with address.floor as 3
*/
form = getFormById(page,"locationForm");
try {
 input = form.getInputByName("address.floor");
 input.setValueAttribute("3");
} catch (ElementNotFoundException e) {
 select = form.getSelectByName("address.floor");
 select.setSelectedAttribute("3", true);
}
webClient.waitForBackgroundJavaScriptStartingBefore(0);

step = "State5";
System.out.println(System.currentTimeMillis()+") Entering state 6 of 13 38% complete \"State5\"");
/*
Path _eventId_search is //*[@id="_eventId_search"]
Click on _eventId_search and wait 10 seconds
*/
matchingElement = (ArrayList<HtmlElement>) page.getByXPath("//*[@id=\"_eventId_search\"]");
if (matchingElement.size() == 0) {
 fail("Faild to find element //*[@id=\"_eventId_search\"]");
 System.out.println(page.asXml());
}page = matchingElement.get(0).click();

webClient.waitForBackgroundJavaScriptStartingBefore(10000);

step = "State6";
System.out.println(System.currentTimeMillis()+") Entering state 7 of 13 46% complete \"State6\"");
/*
Find a with attribute href set to /orderflow/index.html?Id=tcm:142-23381&fromSearch&page=new in searchpopup
*/
successfull = find(page, "/html/body/div[7]/div/div[9]", "a", "href", "/orderflow/index.html?Id=tcm:142-23381&fromSearch&page=new");
if (!successfull) {
 System.out.println(page.asXml());
 fail(step+") Failed finding tag \"a\" with attribute \"href\" and value \"/orderflow/index.html?Id=tcm:142-23381&fromSearch&page=new\" in \"/html/body/div[7]/div/div[9]\" at \"http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html\"");

}
/*
Path searchPopupChooseFoundOffer is /html/body/div[8]/div/div[9]/form[2]/div[2]/div[1]/div/div[2]/a[1]
Click on searchPopupChooseFoundOffer and wait 10 seconds
*/
matchingElement = (ArrayList<HtmlElement>) page.getByXPath("/html/body/div[8]/div/div[9]/form[2]/div[2]/div[1]/div/div[2]/a[1]");
if (matchingElement.size() == 0) {
 fail("Faild to find element /html/body/div[8]/div/div[9]/form[2]/div[2]/div[1]/div/div[2]/a[1]");
 System.out.println(page.asXml());
}page = matchingElement.get(0).click();

webClient.waitForBackgroundJavaScriptStartingBefore(10000);

step = "State7";
System.out.println(System.currentTimeMillis()+") Entering state 8 of 13 53% complete \"State7\"");
/*
Find option with attribute value set to dsl24 in orderCartArea
*/
successfull = find(page, "/html/body/div[2]/div/div/div/div[3]/form/div[2]/div[2]/div[3]", "option", "value", "dsl24");
if (!successfull) {
 System.out.println(page.asXml());
 fail(step+") Failed finding tag \"option\" with attribute \"value\" and value \"dsl24\" in \"/html/body/div[2]/div/div/div/div[3]/form/div[2]/div[2]/div[3]\" at \"http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html\"");

}
/*
Path checkoutOrder is //*[@id="orderButton"]
Click on checkoutOrder and wait 10 seconds
*/
matchingElement = (ArrayList<HtmlElement>) page.getByXPath("//*[@id=\"orderButton\"]");
if (matchingElement.size() == 0) {
 fail("Faild to find element //*[@id=\"orderButton\"]");
 System.out.println(page.asXml());
}page = matchingElement.get(0).click();

webClient.waitForBackgroundJavaScriptStartingBefore(10000);

step = "State8";
System.out.println(System.currentTimeMillis()+") Entering state 9 of 13 61% complete \"State8\"");
/*
Find input with attribute src set to /res/img/button/tillbaka.png in website
*/
successfull = find(page, "/html/body", "input", "src", "/res/img/button/tillbaka.png");
if (!successfull) {
 System.out.println(page.asXml());
 fail(step+") Failed finding tag \"input\" with attribute \"src\" and value \"/res/img/button/tillbaka.png\" in \"/html/body\" at \"http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html\"");

}
/*
Path searchPopupChooseFoundOffer is /html/body/div[8]/div/div[9]/form[2]/div[2]/div[1]/div/div[2]/a[1]
Click on searchPopupChooseFoundOffer and wait 10 seconds
*/
matchingElement = (ArrayList<HtmlElement>) page.getByXPath("/html/body/div[8]/div/div[9]/form[2]/div[2]/div[1]/div/div[2]/a[1]");
if (matchingElement.size() == 0) {
 fail("Faild to find element /html/body/div[8]/div/div[9]/form[2]/div[2]/div[1]/div/div[2]/a[1]");
 System.out.println(page.asXml());
}page = matchingElement.get(0).click();

webClient.waitForBackgroundJavaScriptStartingBefore(10000);

step = "State9";
System.out.println(System.currentTimeMillis()+") Entering state 10 of 13 69% complete \"State9\"");
/*
Find option with attribute value set to dsl24 in orderCartArea
*/
successfull = find(page, "/html/body/div[2]/div/div/div/div[3]/form/div[2]/div[2]/div[3]", "option", "value", "dsl24");
if (!successfull) {
 System.out.println(page.asXml());
 fail(step+") Failed finding tag \"option\" with attribute \"value\" and value \"dsl24\" in \"/html/body/div[2]/div/div/div/div[3]/form/div[2]/div[2]/div[3]\" at \"http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html\"");

}
/*
Path checkoutOrder is //*[@id="orderButton"]
Click on checkoutOrder and wait 10 seconds
*/
matchingElement = (ArrayList<HtmlElement>) page.getByXPath("//*[@id=\"orderButton\"]");
if (matchingElement.size() == 0) {
 fail("Faild to find element //*[@id=\"orderButton\"]");
 System.out.println(page.asXml());
}page = matchingElement.get(0).click();

webClient.waitForBackgroundJavaScriptStartingBefore(10000);

step = "State10";
System.out.println(System.currentTimeMillis()+") Entering state 11 of 13 76% complete \"State10\"");
/*
Find input with attribute src set to /res/img/button/tillbaka.png in website
*/
successfull = find(page, "/html/body", "input", "src", "/res/img/button/tillbaka.png");
if (!successfull) {
 System.out.println(page.asXml());
 fail(step+") Failed finding tag \"input\" with attribute \"src\" and value \"/res/img/button/tillbaka.png\" in \"/html/body\" at \"http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html\"");

}
/*
Path searchPopupChooseFoundOffer is /html/body/div[8]/div/div[9]/form[2]/div[2]/div[1]/div/div[2]/a[1]
Click on searchPopupChooseFoundOffer and wait 10 seconds
*/
matchingElement = (ArrayList<HtmlElement>) page.getByXPath("/html/body/div[8]/div/div[9]/form[2]/div[2]/div[1]/div/div[2]/a[1]");
if (matchingElement.size() == 0) {
 fail("Faild to find element /html/body/div[8]/div/div[9]/form[2]/div[2]/div[1]/div/div[2]/a[1]");
 System.out.println(page.asXml());
}page = matchingElement.get(0).click();

webClient.waitForBackgroundJavaScriptStartingBefore(10000);

step = "State11";
System.out.println(System.currentTimeMillis()+") Entering state 12 of 13 84% complete \"State11\"");
/*
Find option with attribute value set to dsl24 in orderCartArea
*/
successfull = find(page, "/html/body/div[2]/div/div/div/div[3]/form/div[2]/div[2]/div[3]", "option", "value", "dsl24");
if (!successfull) {
 System.out.println(page.asXml());
 fail(step+") Failed finding tag \"option\" with attribute \"value\" and value \"dsl24\" in \"/html/body/div[2]/div/div/div/div[3]/form/div[2]/div[2]/div[3]\" at \"http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html\"");

}
/*
Path checkoutOrder is //*[@id="orderButton"]
Click on checkoutOrder and wait 10 seconds
*/
matchingElement = (ArrayList<HtmlElement>) page.getByXPath("//*[@id=\"orderButton\"]");
if (matchingElement.size() == 0) {
 fail("Faild to find element //*[@id=\"orderButton\"]");
 System.out.println(page.asXml());
}page = matchingElement.get(0).click();

webClient.waitForBackgroundJavaScriptStartingBefore(10000);

step = "State12";
System.out.println(System.currentTimeMillis()+") Entering state 13 of 13 92% complete \"State12\"");
/*
Find input with attribute src set to /res/img/button/tillbaka.png in website
*/
successfull = find(page, "/html/body", "input", "src", "/res/img/button/tillbaka.png");
if (!successfull) {
 System.out.println(page.asXml());
 fail(step+") Failed finding tag \"input\" with attribute \"src\" and value \"/res/img/button/tillbaka.png\" in \"/html/body\" at \"http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html\"");

}
 webClient.closeAllWindows();
}

private boolean find(HtmlPage page, String xpath, String tag, String attribute, String value) {
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
     System.out.println("Found element "+tag+" with attribute "+attribute+" and value "+value+" at "+node.getCanonicalXPath());
     return true;
    }
   }
  }
  if (recursiveFind(node.getChildNodes(), tag, attribute, value))
   return true;
 }
 return false;
}
private HtmlForm getFormById(HtmlPage page, String id) {
 for (HtmlForm form : page.getForms())
  if (form.getAttributes().getNamedItem("id") != null && form.getAttributes().getNamedItem("id").getNodeValue().equals(id)
     || form.getAttributes().getNamedItem("name") != null && form.getAttributes().getNamedItem("name").getNodeValue().equals(id)
     )
   return form;
 return null;
}


}
