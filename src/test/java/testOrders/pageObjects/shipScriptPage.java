package testOrders.pageObjects;

import testOrders.helper.TestHelper;

import testOrders.pageObjects.TestOrdersPage;

public class shipScriptPage extends TestHelper{
	
	public shipScriptPage(){
		
	}

	public CustomerCardPage returnToCustomerCardPage() {
		wait(10);
		open(customerCardPage + "order/" + TestOrdersPage.invoiceNumber);
		
		return new CustomerCardPage();
	}
	
	public CustomerCardPage returnToNewCustomerCardPage() {
		wait(10);
		open(customerCardPage + "order/" + CustomerCardPage.autoShipInvoiceNumber);
		
		return new CustomerCardPage();
	}

}
