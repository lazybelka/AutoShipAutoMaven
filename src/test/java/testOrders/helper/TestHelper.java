package testOrders.helper;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import testOrders.helper.TestHelper;

import framework.Framework;

public class TestHelper extends Framework{
	
	private final static String LogInPageDefault = "https://devtest.acmgaces.com/access/login.php/";
	private final static String TestOrdersPageDefault = "https://devtest.acmgaces.com/mattmin_zf/testorders?sku=";
	private final static String ItemsPageDefault = "https://devtest.acmgaces.com/mattmin/maintain/items/index.php";
	private final static String CustomerCardPageDefault = "https://devtest.acmgaces.com/mattmin_zf/customercard/";
	private final static String ShipScriptPageDefault = "https://devtest.acmgaces.com/busTestScripts/labelOrder.php?orderId=";
	private final static String UserDefault = "qauser";
	private final static String PasswordDefault = "mnb234jn";
	private final static String UsermailDefault = "lena@greenice.net";
	private final static String PasswordmailDefault = "29011402dr";
	private final static String SendmailDefault = "lena@greenice.net";
	private final static String CardDefault = "4111111111111111";
	protected final static String SkuDefault = "MST-BALM-25ML-30-C";
	private final static String OfferOutlookPageDefault = "https://devtest.acmgaces.com/mattmin_zf/offers/preview/index/itemId/";
	private final static String skuListPageDefault = "https://devtest.acmgaces.com/mattmin/accounting/itemTesting.php?page=reporting"; // file:///C:/Users/ivbar/Desktop/acmg/SKUPage.htm
	private final static String autoShipCreatingPageDefault = "https://devtest.acmgaces.com/busTestScripts/createAutoshipOrder.php?id=";
	
	public static String logInPage = LogInPageDefault;
	public static String testOrdersPage = TestOrdersPageDefault;
	public static String itemsPage = ItemsPageDefault;
	public static String customerCardPage = CustomerCardPageDefault;
	public static String shipScriptPage = ShipScriptPageDefault;
	public static String user = UserDefault;
	public static String password = PasswordDefault;
	public static String usermail = UsermailDefault;
	public static String passwordmail = PasswordmailDefault;
	public static String sendmail = SendmailDefault;
	public static String card = CardDefault;
	public static String offerOutlookPage = OfferOutlookPageDefault;
	public static String skuListPage = skuListPageDefault;
	public static String autoShipCreatingPage = autoShipCreatingPageDefault;
	
	@BeforeTest
	public void getDriver(){
		
		ProfilesIni allProfiles = new ProfilesIni();
		FirefoxProfile profile = allProfiles.getProfile("autoShip_auto");
		
		driver = new FirefoxDriver(profile);
		driver.get(TestHelper.logInPage);
	}
	
	@AfterTest
	public void closeDriver() {
		
	        driver.close();
		
	}

}
