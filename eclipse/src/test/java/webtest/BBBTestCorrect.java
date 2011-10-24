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
 */

@SuppressWarnings("unchecked")
public class BBBTestCorrect extends TestCase {
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