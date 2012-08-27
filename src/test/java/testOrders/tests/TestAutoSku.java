package testOrders.tests;

import java.util.ArrayList;

import org.testng.annotations.Test;

import testOrders.helper.TestHelper;
import testOrders.pageObjects.AutoShipCreatingPage;
import testOrders.pageObjects.ItemDetailsPage;
import testOrders.pageObjects.MattminLogIn;
import testOrders.pageObjects.OfferOutlookPage;
import testOrders.pageObjects.SKUListPage;
import testOrders.pageObjects.TestOrdersPage;

public class TestAutoSku extends TestHelper{
	
	static ArrayList<String> skuList = new ArrayList<String>();
	static ArrayList<String> partnersList = new ArrayList<String>();
	static ArrayList<String> dnisList = new ArrayList<String>();
	
	@Test
	public void AutoSkuTest(){
		new MattminLogIn()
		.logIn()
		.clickHereToContinue()
		.openSKUListPage()
		.takeSKUList(skuList, partnersList, dnisList);
		lab: for (int i=0; i < skuList.size(); i++){
			new SKUListPage()
			.printCurrentTestSet(i+1, skuList.get(i), partnersList.get(i), dnisList.get(i))
			.openItemsPage()
			.inputSKU(skuList.get(i))
			.isAutoShip()
			.openOfferOutlookPage(skuList.get(i))
			.createSKUFolder(skuList.get(i))
			.saveOfferOutlookPage(skuList.get(i))
			.openTestOrdersPage(skuList.get(i))
			.fillTestValues(partnersList.get(i), dnisList.get(i))
			.clickSubmit()
			.waitForInvoiceNumber();
			if (noSuchElementException) {
				new TestOrdersPage()
				.invoiceNumberErrorProcessing();
				continue lab;
			}
			else {
				new TestOrdersPage()
				.takeInvoiceNumberAndCustomerId()
				.openCustomerCardPage()
				.takeOrderNumber()
				.shipOrder()
				.returnToCustomerCardPage()
				.isOrderShipped()
				.takeCustomerCardScreenShoots()
				.returnToCustomerCardPage()
				.saveViewPackingPage(OfferOutlookPage.folderName);
				
				if (ItemDetailsPage.isAuto){
					new AutoShipCreatingPage()
					.createAutoshipFolder(skuList.get(i))
					.openAutoShipCreatingPage();
					if (AutoShipCreatingPage.isAutoshipCreated() ){
						new AutoShipCreatingPage()
						.returnToCustomerCardPage()
						.takeAutoShipInvoiceNumber()
						.takeOrderNumber()
						.shipOrder()
						.returnToNewCustomerCardPage()
						.isOrderShipped()
						.takeAutoshipScreenShoots()
						.returnToNewCustomerCardPage()
						.saveViewPackingPage(AutoShipCreatingPage.autoShipFolderName)
						
						;
					}
				}
				
				else{
					System.out.println("SKU is not isAutoShip");
				}
			}
		}
	}

}
