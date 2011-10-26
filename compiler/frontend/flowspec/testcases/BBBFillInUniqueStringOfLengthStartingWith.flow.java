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
Find a with attribute href set to /servlet/orderflow/search/search-flow?Id=tcm:142-23371&draggable=false in campaignmodule
Click on campaignModuleChoose and wait 10 seconds
Fill in locationForm with _eventId as search and phoneNumber.fullNumber as unique string of length 6 starting with My
Click on _eventId_search and wait 10 seconds
Find input with attribute id set to _eventId_search in searchpopup
*/

@SuppressWarnings("unchecked")
public class BBBFillInUniqueStringOfLengthStartingWith extends TestCase {
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


System.out.println(System.currentTimeMillis()+") Entering state 1 of 5 0% complete \"start\"");
/*
Url baspaket is http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html
Go to baspaket and wait 2 seconds
*/
page = webClient.getPage("http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html");
webClient.waitForBackgroundJavaScriptStartingBefore(2000);

step = "State1";
System.out.println(System.currentTimeMillis()+") Entering state 2 of 5 20% complete \"State1\"");
/*
Find a with attribute href set to /servlet/orderflow/search/search-flow?Id=tcm:142-23371&draggable=false in campaignmodule
*/
successfull = find(page, "/html/body/div[2]/div/div[2]/div[2]/div/div[3]", "a", "href", "/servlet/orderflow/search/search-flow?Id=tcm:142-23371&draggable=false");
if (!successfull) {
 System.out.println(page.asXml());
 fail(step+") Failed finding tag \"a\" with attribute \"href\" and value \"/servlet/orderflow/search/search-flow?Id=tcm:142-23371&draggable=false\" in \"/html/body/div[2]/div/div[2]/div[2]/div/div[3]\" at \"http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html\"");

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
System.out.println(System.currentTimeMillis()+") Entering state 3 of 5 40% complete \"State2\"");
/*
Fill in locationForm with _eventId as search and phoneNumber.fullNumber as unique string of length 6 starting with My
*/
form = getFormById(page,"locationForm");
try {
 input = form.getInputByName("_eventId");
 input.setValueAttribute("search");
} catch (ElementNotFoundException e) {
 select = form.getSelectByName("_eventId");
 select.setSelectedAttribute("search", true);
}
input = form.getInputByName("phoneNumber.fullNumber");
input.setValueAttribute("MylCkZ");
webClient.waitForBackgroundJavaScriptStartingBefore(0);

step = "State3";
System.out.println(System.currentTimeMillis()+") Entering state 4 of 5 60% complete \"State3\"");
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
System.out.println(System.currentTimeMillis()+") Entering state 5 of 5 80% complete \"State4\"");
/*
Find input with attribute id set to _eventId_search in searchpopup
*/
successfull = find(page, "/html/body/div[7]/div/div[9]", "input", "id", "_eventId_search");
if (!successfull) {
 System.out.println(page.asXml());
 fail(step+") Failed finding tag \"input\" with attribute \"id\" and value \"_eventId_search\" in \"/html/body/div[7]/div/div[9]\" at \"http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html\"");

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
