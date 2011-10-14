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
<paths>
 <path id="campaignmodule">
  /html/body/div[2]/div/div[2]/div[2]/div/div[3]
 </path>
 <path id="searchpopup">
  //*[@id="modalbox-inner"]
 </path>
 <path id="_eventId_search">
  //*[@id="_eventId_search"]
 </path>
 <path id="campaignModuleChoose">
  /html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/span/a/span
 </path>
 <path id="searchPopupChooseFoundOffer">
  /html/body/div[7]/div/div[9]/form[2]/div[2]/div/a[2]/img
 </path>
 <path id="orderCartArea">
  /html/body/div[2]/div/div/div/div[3]/form/div[2]/div[2]/div[3]
 </path>
 <path id="website">
  /html/body
 </path>
 <path id="checkoutOrder">
  /html/body/div[2]/div/div/div/div[3]/form/div[2]/div[2]/div[3]/div[6]/div/input
 </path>
</paths>

<urls>
 <url id="baspaket">
  http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html
 </url>
</urls>

<flow>
 <state id="start">
  <transition to="campaignmodulestate" using="baspaket" delay="2000"/>
 </state>

 <state id="campaignmodulestate">
  <find path="campaignmodule">
    <tag type="a">
     <attribute name="href" value="/servlet/orderflow/search/search-flow?Id=tcm:142-23371"/>
    </tag>
  </find>
  <transition to="searchflow" using="campaignModuleChoose" delay="5000"/>
 </state>

 <state id="searchflow">
  <find path="searchpopup">
    <tag type="input">
     <attribute name="id" value="_eventId_search"/>
    </tag>
  </find>
  <form id="locationForm" submit="_eventId_search">
   <input name="_eventId" value="search"/>
   <input name="phoneNumber.fullNumber" value="0768966787"/>
  </form>
  <transition to="selectfloor" using="locationForm" delay="5000"/>
 </state>

 <state id="selectfloor">
  <find path="searchpopup">
    <tag type="input">
     <attribute name="id" value="_eventId_search"/>
    </tag>
  </find>
  <form id="locationForm" submit="_eventId_search">
   <input name="address.floor" value="3"/>
  </form>
  <transition to="searchresults" using="locationForm" delay="10000"/>
 </state>

 <state id="searchresults">
  <find path="searchpopup">
    <tag type="a">
     <attribute name="href" value="/orderflow/index.html?Id=tcm:142-23381&fromSearch&page=new"/>
    </tag>
  </find>
  <transition to="ordercart" using="searchPopupChooseFoundOffer" delay="10000"/>
 </state>

 <state id="ordercart">
  <find path="orderCartArea">
    <tag type="option">
     <attribute name="value" value="dsl24"/>
    </tag>
  </find>
  <transition to="tvDetails" using="checkoutOrder" delay="10000"/>
 </state>

 <state id="tvDetails">
  <find path="website">
    <tag type="input">
     <attribute name="src" value="/res/img/button/tillbaka.png"/>
    </tag>
  </find>
 </state>

</flow>
*/

@SuppressWarnings("unchecked")
public class BBBTest extends TestCase {
@Test
public void testHomePage() throws Exception {
 WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER_8);
 webClient.setCssEnabled(true);
 webClient.setJavaScriptEnabled(true);
 webClient.setThrowExceptionOnFailingStatusCode(false);
 webClient.setThrowExceptionOnScriptError(false);
 HtmlPage page = null;
 String step = null;
 boolean successfull = false;
 HtmlForm form = null;
 HtmlInput input = null;
 HtmlSelect select = null;
 ArrayList<HtmlElement> matchingElement = null;


System.out.println(System.currentTimeMillis()+") Entering state 1 of 7 0% complete \"start\"");
page = webClient.getPage("http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html");
webClient.waitForBackgroundJavaScriptStartingBefore(2000);

step = "campaignmodulestate";
System.out.println(System.currentTimeMillis()+") Entering state 2 of 7 14% complete \"campaignmodulestate\"");
//Find attributes inside /html/body/div[2]/div/div[2]/div[2]/div/div[3]
successfull = find(page, "/html/body/div[2]/div/div[2]/div[2]/div/div[3]", "a", "href", "/servlet/orderflow/search/search-flow?Id=tcm:142-23371");
if (!successfull) {
 System.out.println(page.asXml());
 fail(step+") Failed finding tag \"a\" with attribute \"href\" and value \"/servlet/orderflow/search/search-flow?Id=tcm:142-23371\" in \"/html/body/div[2]/div/div[2]/div[2]/div/div[3]\" at \"http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html\"");

}
//Find and click element: /html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/span/a/span
matchingElement = (ArrayList<HtmlElement>) page.getByXPath("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/span/a/span");
if (matchingElement.size() == 0)
  fail("Faild to find element /html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/span/a/span");
page = matchingElement.get(0).click();

webClient.waitForBackgroundJavaScriptStartingBefore(5000);

step = "searchflow";
System.out.println(System.currentTimeMillis()+") Entering state 3 of 7 28% complete \"searchflow\"");
//Find attributes inside //*[@id="modalbox-inner"]
successfull = find(page, "//*[@id=\"modalbox-inner\"]", "input", "id", "_eventId_search");
if (!successfull) {
 System.out.println(page.asXml());
 fail(step+") Failed finding tag \"input\" with attribute \"id\" and value \"_eventId_search\" in \"//*[@id=\"modalbox-inner\"]\" at \"http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html\"");

}
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
//Submit form, by clicking //*[@id="_eventId_search"]
//Find and click element: //*[@id="_eventId_search"]
matchingElement = (ArrayList<HtmlElement>) page.getByXPath("//*[@id=\"_eventId_search\"]");
if (matchingElement.size() == 0)
  fail("Faild to find element //*[@id=\"_eventId_search\"]");
page = matchingElement.get(0).click();

webClient.waitForBackgroundJavaScriptStartingBefore(5000);

step = "selectfloor";
System.out.println(System.currentTimeMillis()+") Entering state 4 of 7 42% complete \"selectfloor\"");
//Find attributes inside //*[@id="modalbox-inner"]
successfull = find(page, "//*[@id=\"modalbox-inner\"]", "input", "id", "_eventId_search");
if (!successfull) {
 System.out.println(page.asXml());
 fail(step+") Failed finding tag \"input\" with attribute \"id\" and value \"_eventId_search\" in \"//*[@id=\"modalbox-inner\"]\" at \"http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html\"");

}
form = getFormById(page,"locationForm");
try {
 input = form.getInputByName("address.floor");
 input.setValueAttribute("3");
} catch (ElementNotFoundException e) {
 select = form.getSelectByName("address.floor");
 select.setSelectedAttribute("3", true);
}
//Submit form, by clicking //*[@id="_eventId_search"]
//Find and click element: //*[@id="_eventId_search"]
matchingElement = (ArrayList<HtmlElement>) page.getByXPath("//*[@id=\"_eventId_search\"]");
if (matchingElement.size() == 0)
  fail("Faild to find element //*[@id=\"_eventId_search\"]");
page = matchingElement.get(0).click();

webClient.waitForBackgroundJavaScriptStartingBefore(10000);

step = "searchresults";
System.out.println(System.currentTimeMillis()+") Entering state 5 of 7 57% complete \"searchresults\"");
//Find attributes inside //*[@id="modalbox-inner"]
successfull = find(page, "//*[@id=\"modalbox-inner\"]", "a", "href", "/orderflow/index.html?Id=tcm:142-23381&fromSearch&page=new");
if (!successfull) {
 System.out.println(page.asXml());
 fail(step+") Failed finding tag \"a\" with attribute \"href\" and value \"/orderflow/index.html?Id=tcm:142-23381&fromSearch&page=new\" in \"//*[@id=\"modalbox-inner\"]\" at \"http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html\"");

}
//Find and click element: /html/body/div[7]/div/div[9]/form[2]/div[2]/div/a[2]/img
matchingElement = (ArrayList<HtmlElement>) page.getByXPath("/html/body/div[7]/div/div[9]/form[2]/div[2]/div/a[2]/img");
if (matchingElement.size() == 0)
  fail("Faild to find element /html/body/div[7]/div/div[9]/form[2]/div[2]/div/a[2]/img");
page = matchingElement.get(0).click();

webClient.waitForBackgroundJavaScriptStartingBefore(10000);

step = "ordercart";
System.out.println(System.currentTimeMillis()+") Entering state 6 of 7 71% complete \"ordercart\"");
//Find attributes inside /html/body/div[2]/div/div/div/div[3]/form/div[2]/div[2]/div[3]
successfull = find(page, "/html/body/div[2]/div/div/div/div[3]/form/div[2]/div[2]/div[3]", "option", "value", "dsl24");
if (!successfull) {
 System.out.println(page.asXml());
 fail(step+") Failed finding tag \"option\" with attribute \"value\" and value \"dsl24\" in \"/html/body/div[2]/div/div/div/div[3]/form/div[2]/div[2]/div[3]\" at \"http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html\"");

}
//Find and click element: /html/body/div[2]/div/div/div/div[3]/form/div[2]/div[2]/div[3]/div[6]/div/input
matchingElement = (ArrayList<HtmlElement>) page.getByXPath("/html/body/div[2]/div/div/div/div[3]/form/div[2]/div[2]/div[3]/div[6]/div/input");
if (matchingElement.size() == 0)
  fail("Faild to find element /html/body/div[2]/div/div/div/div[3]/form/div[2]/div[2]/div[3]/div[6]/div/input");
page = matchingElement.get(0).click();

webClient.waitForBackgroundJavaScriptStartingBefore(10000);

step = "tvDetails";
System.out.println(System.currentTimeMillis()+") Entering state 7 of 7 85% complete \"tvDetails\"");
//Find attributes inside /html/body
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