package testOrders.pageObjects;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;

import testOrders.helper.TestHelper;

public class CustomerCardPage extends TestHelper{
	
	public static String orderNumber = new String();
	public static String autoShipInvoiceNumber = new String();
	
	public CustomerCardPage(){
		
	}

	public CustomerCardPage takeOrderNumber() {
		waitFor(By.id("headerToChange"));
		orderNumber = getText(By.id("headerToChange")).substring(20);
		System.out.println("Order number is " + orderNumber);
		
		return this;
	}

	public shipScriptPage shipOrder() {
		open(shipScriptPage + orderNumber);
		
		return new shipScriptPage();
	}

	public CustomerCardPage isOrderShipped() {
		wait(3);
		waitFor(By.id("commentID"));
		String orderStatus = new String();
		waitFor(By.cssSelector("label[id*='infoSaleStatus']"));
		orderStatus = getText(By.cssSelector("label[id*='infoSaleStatus']"));
		
		if (orderStatus.contains("SHIPPED")){
			System.out.println("Order is shipped");
		}
		else {
			System.out.println("Error! Order status is " + orderStatus);
		}
		
		return this;
	}
	
	public CustomerCardPage takeCustomerCardScreenShoots(){
		Date date = new Date();
		SimpleDateFormat exactDateFormat = new SimpleDateFormat("HH-mm-ss-dd-MM-yyyy");
		wait(3);
		waitFor(By.id("commentID"));
		takeScreenShotInFolder("Order_Info-" + exactDateFormat.format(date), OfferOutlookPage.folderName);
		
		waitFor(By.className("orderinfo_marketing"));
		click(By.className("orderinfo_marketing"));
		wait(4);
		takeScreenShotInFolder("Marketing_Info-" + exactDateFormat.format(date), OfferOutlookPage.folderName);
		
		waitFor(By.className("orderinfo_history"));
		click(By.className("orderinfo_history"));
		wait(4);
		takeScreenShotInFolder("Order_History-" + exactDateFormat.format(date), OfferOutlookPage.folderName);
		
		waitFor(By.className("orderinfo_general"));
		click(By.className("orderinfo_general"));
		wait(4);
		waitFor(By.className("paymentButton"));
		click(By.className("paymentButton"));
		wait(4);
		takeScreenShotInFolder("Advanced_Payments-" + exactDateFormat.format(date), OfferOutlookPage.folderName);
		
		waitFor(By.className("generalinfo_generalpanel"));
		click(By.className("generalinfo_generalpanel"));
		wait(4);
		takeScreenShotInFolder("General_Panel-" + exactDateFormat.format(date), OfferOutlookPage.folderName);
		
		waitFor(By.className("orderinfo_autoship"));
		click(By.className("orderinfo_autoship"));
		wait(4);
		takeScreenShotInFolder("Auto_Ship-" + exactDateFormat.format(date), OfferOutlookPage.folderName);
		
		return this;
	}

	public ViewPackingPage saveViewPackingPage(String path){
		Date date = new Date();
		SimpleDateFormat exactDateFormat = new SimpleDateFormat("HH-mm-ss-dd-MM-yyyy");
		wait(2);
		if(isElementPresent(By.className("shipped"))){
			click(By.className("shipped"));
		}
		else {
			takeScreenShotInFolder("Order_Status-" + exactDateFormat.format(date), path); 
		}
		wait(5);
		try {
			fileMigration("PackingSlip.pdf", path + "/PackingSlip.pdf");
		}
		catch(FileNotFoundException e){
			System.out.println("File not found!");
		}
		return new ViewPackingPage();
	}
	
	public CustomerCardPage takeAutoShipInvoiceNumber() {
		waitFor(By.cssSelector("a[rel='0']"));
		autoShipInvoiceNumber = getText(By.cssSelector("a[rel='0']"));
		click(By.cssSelector("a[rel='0']"));
		System.out.println("Auto ship invoice number is " + autoShipInvoiceNumber);
		return this;
	}

	public CustomerCardPage takeAutoshipScreenShoots() {
		wait(3);
		waitFor(By.id("commentID"));
		takeScreenShotInFolder("Autoship-" + "Order_Info-" + ItemDetailsPage.dateStr, AutoShipCreatingPage.autoShipFolderName);
		
		waitFor(By.className("orderinfo_marketing"));
		click(By.className("orderinfo_marketing"));
		wait(4);
		takeScreenShotInFolder("Autoship-" + "Marketing_Info-" + ItemDetailsPage.dateStr, AutoShipCreatingPage.autoShipFolderName);
		
		waitFor(By.className("orderinfo_history"));
		click(By.className("orderinfo_history"));
		wait(4);
		takeScreenShotInFolder("Autoship-" + "Order_History-" + ItemDetailsPage.dateStr, AutoShipCreatingPage.autoShipFolderName);
		
		waitFor(By.className("orderinfo_general"));
		click(By.className("orderinfo_general"));
		wait(4);
		waitFor(By.className("paymentButton"));
		click(By.className("paymentButton"));
		wait(4);
		takeScreenShotInFolder("Autoship-" + "Advanced_Payments-" + ItemDetailsPage.dateStr, AutoShipCreatingPage.autoShipFolderName);
		
		waitFor(By.className("generalinfo_generalpanel"));
		click(By.className("generalinfo_generalpanel"));
		wait(4);
		takeScreenShotInFolder("Autoship-" + "General_Panel-" + ItemDetailsPage.dateStr, AutoShipCreatingPage.autoShipFolderName);
		
		waitFor(By.className("orderinfo_autoship"));
		click(By.className("orderinfo_autoship"));
		wait(4);
		takeScreenShotInFolder("Autoship-" + "Auto_Ship-" + ItemDetailsPage.dateStr, AutoShipCreatingPage.autoShipFolderName);
		return this;
	}

}
