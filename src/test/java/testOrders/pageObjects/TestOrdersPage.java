package testOrders.pageObjects;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;

import testOrders.helper.TestHelper;

public class TestOrdersPage extends TestHelper{
	
	public TestOrdersPage(){
		
	}
	
	public static String invoiceNumber = new String();
	public static String customerId = new String();

	public TestOrdersPage fillTestValues(String partner, String dnis) {
		waitFor(By.id("ship_firstname"));
		fill(By.id("patternName"), "test");
		fill(By.id("cardNumber"),card);
		fill(By.id("cardCCV"),"111");
		
		String tempPartner = new String();
		int divCounter = 1;
		click(By.id("partner_id"));
		
		while (isElementPresent(By.xpath("//div[7]/div/div[" + divCounter + "]"))) {
			tempPartner = getText(By.xpath("//div[7]/div/div[" + divCounter + "]"));
			if (tempPartner.equals(partner)) {
				click(By.xpath("//div[7]/div/div[" + divCounter + "]"));
				break;
			}
			else {
				divCounter ++;
			}
		}
		
		wait(5);
		
		String tempDnis = new String();
		click(By.id("dnis"));
		
		// look for Div number of combo 'Dnis'
		tempDnis = getText(By.id("dnis"));
		int externalDivCounter = 8;
		while (!(isElementPresent(By.xpath("//div[" + externalDivCounter + "]/div/div[1]")))){
			externalDivCounter ++;
		}
		
		while(!(tempDnis.equals(getText(By.xpath("//div[" + externalDivCounter + "]/div/div[1]"))))){
			externalDivCounter ++;
		}
		//
		
		divCounter = 1;
		while (isElementPresent(By.xpath("//div[" + externalDivCounter + "]/div/div[" + divCounter + "]"))) {
			tempDnis = getText(By.xpath("//div[" + externalDivCounter + "]/div/div[" + divCounter + "]"));
			if (tempDnis.equals(dnis)) {
				click(By.xpath("//div[" + externalDivCounter + "]/div/div[" + divCounter + "]"));
				break;
			}
			else {
				divCounter ++;
			}
				
		}
		
		wait(5);
		
	return this;
		
	}
	
	public TestOrdersPage waitForInvoiceNumber(){
		waitFor(By.cssSelector("a[href*='https://devtest.acmgaces.com/mattmin_zf/customercard/order/']"));
		
		return this;
	}
	
	public TestOrdersPage invoiceNumberErrorProcessing() {
		Date date = new Date();
		SimpleDateFormat exactDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		takeScreenShotInFolder("Error_invoice_number-" + exactDateFormat.format(date), OfferOutlookPage.folderName);
		System.out.println("Getting invoice number error! Look at screenshot in SKU folder");
		
		return this;
	}

	public TestOrdersPage takeInvoiceNumberAndCustomerId() {
		waitFor(By.cssSelector("a[href*='https://devtest.acmgaces.com/mattmin_zf/customercard/order/']"));
		wait(2);
		customerId = getText(By.cssSelector("a[id='testCustomerId']"));
		System.out.println("Customer ID is " + customerId);
		invoiceNumber = getText(By.cssSelector("a[id='testInvoiceNumber']"));
		System.out.println("Invoice number is " + invoiceNumber);
		
		return this;
		
	}
	
	public TestOrdersPage clickSubmit(){
		waitFor(By.id("butsubmit"));
		click(By.id("butsubmit"));
		
		return this;
	}
	
	public CustomerCardPage openCustomerCardPage(){
		open(customerCardPage + "order/" + invoiceNumber);
		
		return new CustomerCardPage();
	}

}