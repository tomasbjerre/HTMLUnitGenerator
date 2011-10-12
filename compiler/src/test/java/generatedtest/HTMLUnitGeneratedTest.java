package generatedtest;
import org.junit.Test;

import org.w3c.dom.Node;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import java.util.regex.*;

import java.util.ArrayList;

import junit.framework.TestCase;

public class HTMLUnitGeneratedTest extends TestCase {

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
 ArrayList<HtmlElement> matchingElement = null;


page = webClient.getPage("http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html");
webClient.waitForBackgroundJavaScriptStartingBefore(2000);

step = "campaignmodulestate";
//Find attributes inside /html/body/div[2]/div/div[2]/div[2]/div/div[3]
successfull = find(page, "/html/body/div[2]/div/div[2]/div[2]/div/div[3]", "a", "href", "/servlet/orderflow/search/search-flow?Id=tcm:142-23371");
if (!successfull)
 fail(step+") Failed finding tag \"a\" with attribute \"href\" and value \"/servlet/orderflow/search/search-flow?Id=tcm:142-23371\" in \"/html/body/div[2]/div/div[2]/div[2]/div/div[3]\" at \"http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html\"");

//Find and click element: /html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/span/a/span
matchingElement = (ArrayList<HtmlElement>) page.getByXPath("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/span/a/span");
if (matchingElement.size() == 0)
  fail("Faild to find element /html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/span/a/span");
matchingElement.get(0).click();
webClient.waitForBackgroundJavaScriptStartingBefore(2000);


step = "searchflow";
//Find attributes inside //*[@id="modalbox-inner"]
successfull = find(page, "//*[@id=\"modalbox-inner\"]", "input", "id", "_eventId_search");
if (!successfull)
 fail(step+") Failed finding tag \"input\" with attribute \"id\" and value \"_eventId_search\" in \"//*[@id=\"modalbox-inner\"]\" at \"http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html\"");

form = getFormById(page,"locationForm");
input = form.getInputByName("_eventId");
input.setValueAttribute("search");

input = form.getInputByName("phoneNumber.fullNumber");
input.setValueAttribute("0768966787");

//Submit form, by clicking //*[@id="_eventId_search"]
//Find and click element: //*[@id="_eventId_search"]
matchingElement = (ArrayList<HtmlElement>) page.getByXPath("//*[@id=\"_eventId_search\"]");
if (matchingElement.size() == 0)
  fail("Faild to find element //*[@id=\"_eventId_search\"]");
matchingElement.get(0).click();
webClient.waitForBackgroundJavaScriptStartingBefore(2000);


step = "searching";
//Find attributes inside //*[@id="modalbox-inner"]
successfull = find(page, "//*[@id=\"modalbox-inner\"]", "input", "id", "_eventId_search");
if (!successfull)
 fail(step+") Failed finding tag \"input\" with attribute \"id\" and value \"_eventId_search\" in \"//*[@id=\"modalbox-inner\"]\" at \"http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html\"");

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
