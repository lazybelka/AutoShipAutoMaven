package testOrders.pageObjects;

import testOrders.helper.TestHelper;

public class TablePage extends TestHelper{
	
	public TablePage(){
		
	}
	
	public TestOrdersPage openTestOrdersPage() {
		open(testOrdersPage);
		
		return new TestOrdersPage();
	}
	
	public SKUListPage openSKUListPage(){
		open(skuListPage);
		
		return new SKUListPage();
	}

}
