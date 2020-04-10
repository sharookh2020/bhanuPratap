package clients;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import home.Home;
import login.Login;
import pageObjects.Clients.Clients;
import testBase.DataSource;
import testBase.TestBase;

public class CreatesClients extends TestBase {
	
	Login login;
	Home home;

	
//	  @DataProvider(name = "testData")
//	  public Object[][] testData(){
//			String[][] data = getExcelData("Excel.xlsx", "ClientsData");
//			return data;
//		}
	
	@DataProvider(name = "testData")
	  public Object[][] testData(){
//			String[][] data = getExcelData("Excel.xlsx", "ClientsData");
			Object[][] data = getExcelData("Excel.xlsx","masterData","clientCreation");
			return data;
		}
	
	
	@BeforeClass
	public void beforeClass()
	{
		getApplicationURL(DataSource.OR.getProperty("url"));
		login = new Login(driver);
	}
	
	@Test(dataProvider = "testData")
	public void testCreateClient(String userName,String password, String client_clientname, String client_clientAddress, String client_postcode, String client_state, String client_phone, String client_email, String client_status, String runMode) throws InterruptedException
	{
		if(runMode.equalsIgnoreCase("no"))
		{
			throw new SkipException("Run mode for this set of data is marked N");
		}
		
		home = login.loginToApplication(userName, password);
		Clients client = home.navigateToClients();
		client.createClients(client_clientname, client_clientAddress, client_postcode, client_state, client_phone, client_email, client_status);
		Thread.sleep(1000);
		home.logout();
	}
	
}
