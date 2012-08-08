package testOrders.pageObjects;

import java.util.ArrayList;

import org.openqa.selenium.By;

import testOrders.helper.TestHelper;

public class SKUListPage extends TestHelper{
	
	public SKUListPage(){
		
	}

	public SKUListPage takeSKUList(ArrayList<String> skuList, ArrayList<String> partnersList, ArrayList<String> dnisList) {
		String tempItemsString = new String();
		String[] tempAllCollectionsList;
		String[] tempOneCollectionList;
		waitFor(By.tagName("p"));
		tempItemsString = getText(By.tagName("p"));
		tempAllCollectionsList = tempItemsString.split("; ");
		for (int i=0; i < tempAllCollectionsList.length; i ++){
			tempOneCollectionList = tempAllCollectionsList[i].split(",");
			skuList.add(tempOneCollectionList[0]);
			partnersList.add(tempOneCollectionList[1]);
			dnisList.add(tempOneCollectionList[2]);
		}
		
		return this;
	}
	
	public SKUListPage printCurrentTestSet(int testNumber, String SKU, String partner, String dnis){
		System.out.println(testNumber + ". SKU: " + SKU + "; Partner: " + partner + "; Dnis: " + dnis);
		
		return this;
	}
	
	public ItemDetailsPage openItemsPage(){
		open(itemsPage);
		
		return new ItemDetailsPage();
	}

}
