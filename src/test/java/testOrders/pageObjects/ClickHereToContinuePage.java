package testOrders.pageObjects;

import org.openqa.selenium.By;

import testOrders.helper.TestHelper;

public class ClickHereToContinuePage extends TestHelper{
	
	public ClickHereToContinuePage(){
		
	}
	
	public TablePage clickHereToContinue() {
		waitFor(By.linkText("Click here to continue"));
		click(By.linkText("Click here to continue"));
		
		return new TablePage();
	}
	
	public ClickHereToContinuePage testDownload(){
		open("https://inttest5.acmgaces.com/access/login.php/");
		wait(3);
		waitFor(By.name("username"));
		fill(By.name("username"), user);
		fill(By.name("password"), password);
		click(By.name("submit"));
		wait(3);
		open("https://inttest5.acmgaces.com/mattmin_zf/offers/preview/getpdf/itemId/7951");
		wait(3);
		
		return this;
	}

}
