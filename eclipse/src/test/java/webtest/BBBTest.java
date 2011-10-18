package webtest;
import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Test;
import org.w3c.dom.Node;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;

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
  <transition to="State1" using="baspaket" delay="2000"/>
 </state>

 <state id="State1">
  <find path="campaignmodule">
    <tag type="a">
     <attribute name="href" value="/servlet/orderflow/search/search-flow?Id=tcm:142-23371"/>
    </tag>
  </find>
  <transition to="State2" using="campaignModuleChoose" delay="10000"/>
 </state>

 <state id="State2">
  <find path="searchpopup">
    <tag type="input">
     <attribute name="id" value="_eventId_search"/>
    </tag>
  </find>
  <form id="locationForm" submit="_eventId_search">
   <input name="_eventId" value="search"/>
   <input name="phoneNumber.fullNumber" value="0768966787"/>
  </form>
  <transition to="State3" using="locationForm" delay="10000"/>
 </state>

 <state id="State3">
  <transition to="State4" using="_eventId_search" delay="10000"/>
 </state>

 <state id="State4">
  <find path="searchpopup">
    <tag type="input">
     <attribute name="id" value="_eventId_search"/>
    </tag>
  </find>
  <form id="locationForm" submit="_eventId_search">
   <input name="address.floor" value="3"/>
  </form>
  <transition to="State5" using="locationForm" delay="10000"/>
 </state>

 <state id="State5">
  <transition to="State6" using="_eventId_search" delay="10000"/>
 </state>

 <state id="State6">
  <find path="searchpopup">
    <tag type="a">
     <attribute name="href" value="/orderflow/index.html?Id=tcm:142-23381&fromSearch&page=new"/>
    </tag>
  </find>
  <transition to="State7" using="searchPopupChooseFoundOffer" delay="10000"/>
 </state>

 <state id="State7">
  <find path="orderCartArea">
    <tag type="option">
     <attribute name="value" value="dsl24"/>
    </tag>
  </find>
  <transition to="State8" using="checkoutOrder" delay="10000"/>
 </state>

 <state id="State8">
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
	private boolean find(HtmlPage page, String xpath, String tag, String attribute, String value) {
		ArrayList<HtmlElement> matchingDivs = (ArrayList<HtmlElement>) page.getByXPath(xpath);
		for (HtmlElement div : matchingDivs) {
			if (recursiveFind(div.getChildNodes(), tag, attribute, value))
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


		System.out.println(System.currentTimeMillis()+") Entering state 1 of 9 0% complete \"start\"");
		page = webClient.getPage("http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html");
		webClient.waitForBackgroundJavaScriptStartingBefore(2000);

		step = "State1";
		System.out.println(System.currentTimeMillis()+") Entering state 2 of 9 11% complete \"State1\"");
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

		webClient.waitForBackgroundJavaScriptStartingBefore(10000);

		step = "State2";
		System.out.println(System.currentTimeMillis()+") Entering state 3 of 9 22% complete \"State2\"");
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

		webClient.waitForBackgroundJavaScriptStartingBefore(10000);

		step = "State3";
		System.out.println(System.currentTimeMillis()+") Entering state 4 of 9 33% complete \"State3\"");
		//Find and click element: //*[@id="_eventId_search"]
		matchingElement = (ArrayList<HtmlElement>) page.getByXPath("//*[@id=\"_eventId_search\"]");
		if (matchingElement.size() == 0)
			fail("Faild to find element //*[@id=\"_eventId_search\"]");
		page = matchingElement.get(0).click();

		webClient.waitForBackgroundJavaScriptStartingBefore(10000);

		step = "State4";
		System.out.println(System.currentTimeMillis()+") Entering state 5 of 9 44% complete \"State4\"");
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

		step = "State5";
		System.out.println(System.currentTimeMillis()+") Entering state 6 of 9 55% complete \"State5\"");
		//Find and click element: //*[@id="_eventId_search"]
		matchingElement = (ArrayList<HtmlElement>) page.getByXPath("//*[@id=\"_eventId_search\"]");
		if (matchingElement.size() == 0)
			fail("Faild to find element //*[@id=\"_eventId_search\"]");
		page = matchingElement.get(0).click();

		webClient.waitForBackgroundJavaScriptStartingBefore(10000);

		step = "State6";
		System.out.println(System.currentTimeMillis()+") Entering state 7 of 9 66% complete \"State6\"");
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

		step = "State7";
		System.out.println(System.currentTimeMillis()+") Entering state 8 of 9 77% complete \"State7\"");
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

		step = "State8";
		System.out.println(System.currentTimeMillis()+") Entering state 9 of 9 88% complete \"State8\"");
		//Find attributes inside /html/body
		successfull = find(page, "/html/body", "input", "src", "/res/img/button/tillbaka.png");
		if (!successfull) {
			System.out.println(page.asXml());
			fail(step+") Failed finding tag \"input\" with attribute \"src\" and value \"/res/img/button/tillbaka.png\" in \"/html/body\" at \"http://www.bredbandsbolaget.se/tv/kanalpaket/baspaket.html\"");

		}
		webClient.closeAllWindows();
	}


}
