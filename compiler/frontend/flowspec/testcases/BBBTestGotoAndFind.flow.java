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
Path searchpopup is //*[@id="modalbox-inner"]
Path _eventId_search is //*[@id="_eventId_search"]
Path campaignModuleChoose is /html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/span/a/span
Path searchPopupChooseFoundOffer is /html/body/div[7]/div/div[9]/form[2]/div[2]/div/a[2]/img
Path orderCartArea is /html/body/div[2]/div/div/div/div[3]/form/div[2]/div[2]/div[3]
Path website is /html/body
Path checkoutOrder is /html/body/div[2]/div/div/div/div[3]/form/div[2]/div[2]/div[3]/div[6]/div/input

Url baspaket is http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html

Go to baspaket and wait 2 seconds
Find a with attribute href set to /servlet/orderflow/search/search-flow?Id=tcm:142-23371 in campaignmodule
*/

@SuppressWarnings("unchecked")
public class BBBTestGotoAndFind extends TestCase {
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
Url baspaket is http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html
Go to baspaket and wait 2 seconds
*/
page = webClient.getPage("http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html");
Thread.sleep(2000);

step = "State1";
log(System.currentTimeMillis()+") Entering state 2 of 2 50% complete \"State1\"");
/**
Find a with attribute href set to /servlet/orderflow/search/search-flow?Id=tcm:142-23371 in campaignmodule
*/
findOrFail("/html/body/div[2]/div/div[2]/div[2]/div/div[3]", "a", "href", "/servlet/orderflow/search/search-flow?Id=tcm:142-23371", "http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html", 0);
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
    log(" took "+(System.currentTimeMillis() - endTime + waitAtMost*1000) + "ms");
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

}
