package testOrders.pageObjects;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;

import testOrders.helper.TestHelper;

public class OfferOutlookPage extends TestHelper{
	
	public static String folderName = new String();
	
	public OfferOutlookPage(){
		
	}
	
	public OfferOutlookPage saveOfferOutlookPage(String SKU){
		waitFor(By.linkText("save page as PDF"));
		click(By.linkText("save page as PDF"));
		wait(10);
		try {
			fileMigration(SKU + ".pdf", folderName + "/" + SKU + ".pdf");
		}
		catch(FileNotFoundException e){
			System.out.println("File not found!");
		}
		
		return this;
	}
	
	public TestOrdersPage openTestOrdersPage(String SKU) {
		open(testOrdersPage + SKU);
		
		return new TestOrdersPage();
	}
	
	public OfferOutlookPage createSKUFolder(String SKU) {
		Date date = new Date();
		SimpleDateFormat exactDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		folderName = "TestResults/" + exactDateFormat.format(date) + "_" + SKU;
		File createdFolder = new File(folderName);
		createdFolder.mkdirs();
		
		return this;
	}

}
