package webtest;
import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Test;
import org.w3c.dom.Node;

import com.gargoylesoftware.htmlunit.BrowserVersion;
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
Path mainArea is /html/body/center/table/tbody/tr[3]/td/table
Path linksLink is /html/body/center/table/tbody/tr[2]/th/table/tbody/tr/td[2]/a
Path imagesLink is /html/body/center/table/tbody/tr[2]/th/table/tbody/tr/td[3]/a

Url url1 is http://bjurr.se/

Go to url1 and wait 0 seconds
Click on linksLink and wait 0 seconds
Find a with attribute href set to /link/category/blandat in mainArea
Click on imagesLink and wait 0 seconds
Find a with attribute href set to /image/view/?i=/100213-kkrona-brand/ in mainArea
 */

@SuppressWarnings("unchecked")
public class BjurrTestCorrect extends TestCase {
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


		System.out.println(System.currentTimeMillis()+") Entering state 1 of 4 0% complete \"start\"");
		page = webClient.getPage("http://bjurr.se/");
		webClient.waitForBackgroundJavaScriptStartingBefore(0);

		step = "State1";
		System.out.println(System.currentTimeMillis()+") Entering state 2 of 4 25% complete \"State1\"");
		//Find and click element: /html/body/center/table/tbody/tr[2]/th/table/tbody/tr/td[2]/a
		matchingElement = (ArrayList<HtmlElement>) page.getByXPath("/html/body/center/table/tbody/tr[2]/th/table/tbody/tr/td[2]/a");
		if (matchingElement.size() == 0)
			fail("Faild to find element /html/body/center/table/tbody/tr[2]/th/table/tbody/tr/td[2]/a");
		page = matchingElement.get(0).click();

		webClient.waitForBackgroundJavaScriptStartingBefore(0);

		step = "State2";
		System.out.println(System.currentTimeMillis()+") Entering state 3 of 4 50% complete \"State2\"");
		//Find attributes inside /html/body/center/table/tbody/tr[3]/td/table
		successfull = find(page, "/html/body/center/table/tbody/tr[3]/td/table", "a", "href", "/link/category/blandat");
		if (!successfull) {
			System.out.println(page.asXml());
			fail(step+") Failed finding tag \"a\" with attribute \"href\" and value \"/link/category/blandat\" in \"/html/body/center/table/tbody/tr[3]/td/table\" at \"http://bjurr.se/\"");

		}
		//Find and click element: /html/body/center/table/tbody/tr[2]/th/table/tbody/tr/td[3]/a
		matchingElement = (ArrayList<HtmlElement>) page.getByXPath("/html/body/center/table/tbody/tr[2]/th/table/tbody/tr/td[3]/a");
		if (matchingElement.size() == 0)
			fail("Faild to find element /html/body/center/table/tbody/tr[2]/th/table/tbody/tr/td[3]/a");
		page = matchingElement.get(0).click();

		webClient.waitForBackgroundJavaScriptStartingBefore(0);

		step = "State3";
		System.out.println(System.currentTimeMillis()+") Entering state 4 of 4 75% complete \"State3\"");
		//Find attributes inside /html/body/center/table/tbody/tr[3]/td/table
		successfull = find(page, "/html/body/center/table/tbody/tr[3]/td/table", "a", "href", "/image/view/?i=/100213-kkrona-brand/");
		if (!successfull) {
			System.out.println(page.asXml());
			fail(step+") Failed finding tag \"a\" with attribute \"href\" and value \"/image/view/?i=/100213-kkrona-brand/\" in \"/html/body/center/table/tbody/tr[3]/td/table\" at \"http://bjurr.se/\"");

		}
		webClient.closeAllWindows();
	}

}
