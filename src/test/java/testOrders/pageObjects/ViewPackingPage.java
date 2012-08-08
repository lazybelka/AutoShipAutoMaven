package testOrders.pageObjects;

import testOrders.helper.TestHelper;

public class ViewPackingPage extends TestHelper{
	
	public ViewPackingPage(){
		
	}

	public ViewPackingPage takeViewPackingPDF() {
	wait(5);
	
    String winHandleBefore = driver.getWindowHandle();
	
    for(String winHandle : driver.getWindowHandles()){
        driver.switchTo().window(winHandle);
    }
	
    try {
		saveFile(getURL(), "ViewPackingPage.pdf");
	} catch (Exception e) {
		System.out.println("Error saving file");
		e.printStackTrace();
	}
	
	driver.close();
	
	driver.switchTo().window(winHandleBefore);
		
	return this;
	}

}
