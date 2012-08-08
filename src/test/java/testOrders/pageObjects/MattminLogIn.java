package testOrders.pageObjects;

import org.openqa.selenium.By;

import testOrders.helper.TestHelper;

public class MattminLogIn extends TestHelper{
	
	public MattminLogIn(){

	}

	public ClickHereToContinuePage logIn(){
		waitFor(By.name("username"));
		fill(By.name("username"), user);
		fill(By.name("password"), password);
		click(By.name("submit"));
		return new ClickHereToContinuePage();
	}

}
