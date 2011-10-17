
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
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
// Generated Using HTMLUnitGenerator
<paths>
 <path id="mainArea">
  /html/body/center/table/tbody/tr[3]/td/table
 </path>
 <path id="linksLink">
  /html/body/center/table/tbody/tr[2]/th/table/tbody/tr/td[2]/a
 </path>
 <path id="imagesLink">
  /html/body/center/table/tbody/tr[2]/th/table/tbody/tr/td[3]/a
 </path>
</paths>

<urls>
 <url id="url1">
  http://bjurr.se/
 </url>
</urls>

<flow>
 <state id="start">
  <transition to="startPage" using="url1" delay="0"/>
 </state>

 <state id="startPage">
  <transition to="links" using="linksLink" delay="0"/>
 </state>

 <state id="links">
  <find path="mainArea">
    <tag type="a">
     <attribute name="href" value="/link/category/blandat"/>
    </tag>
  </find>
  <transition to="images" using="imagesLink" delay="0"/>
 </state>

 <state id="images">
  <find path="mainArea">
    <tag type="a">
     <attribute name="href" value="/image/view/?i=/080112 Fiske/"/>
    </tag>
  </find>
 </state>

</flow>
 */

@SuppressWarnings("unchecked")
public class BjurrTest extends TestCase {
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
		HtmlPage page = null;
		String step = null;
		boolean successfull = false;
		ArrayList<HtmlElement> matchingElement = null;


		System.out.println(System.currentTimeMillis()+") Entering state 1 of 4 0% complete \"start\"");
		page = webClient.getPage("http://bjurr.se/");
		webClient.waitForBackgroundJavaScriptStartingBefore(0);

		step = "startPage";
		System.out.println(System.currentTimeMillis()+") Entering state 2 of 4 25% complete \"startPage\"");
		//Find and click element: /html/body/center/table/tbody/tr[2]/th/table/tbody/tr/td[2]/a
		matchingElement = (ArrayList<HtmlElement>) page.getByXPath("/html/body/center/table/tbody/tr[2]/th/table/tbody/tr/td[2]/a");
		if (matchingElement.size() == 0)
			fail("Faild to find element /html/body/center/table/tbody/tr[2]/th/table/tbody/tr/td[2]/a");
		page = matchingElement.get(0).click();

		webClient.waitForBackgroundJavaScriptStartingBefore(0);

		step = "links";
		System.out.println(System.currentTimeMillis()+") Entering state 3 of 4 50% complete \"links\"");
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

		step = "images";
		System.out.println(System.currentTimeMillis()+") Entering state 4 of 4 75% complete \"images\"");
		//Find attributes inside /html/body/center/table/tbody/tr[3]/td/table
		successfull = find(page, "/html/body/center/table/tbody/tr[3]/td/table", "a", "href", "/image/view/?i=/080112 Fiske/");
		if (!successfull) {
			System.out.println(page.asXml());
			fail(step+") Failed finding tag \"a\" with attribute \"href\" and value \"/image/view/?i=/080112 Fiske/\" in \"/html/body/center/table/tbody/tr[3]/td/table\" at \"http://bjurr.se/\"");

		}
		webClient.closeAllWindows();
	}

}
