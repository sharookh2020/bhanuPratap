package login;

import org.testng.annotations.Test;

import home.Home;
import testBase.DataSource;
import testBase.TestBase;

import org.testng.annotations.DataProvider;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;

public class LoginTest extends TestBase {
 
Login login;
Home home;
	
  @DataProvider(name="testData")
  public Object[][] testData(){
		String[][] data = getExcelData("Excel.xlsx", "Sheet1");
		return data;
	}
  
  
  @BeforeClass
  public void beforeClass() {
	  getApplicationURL(DataSource.OR.getProperty("url"));
		login = new Login(driver);
  }
  
  @Test(dataProvider = "testData")
  public void loginTest(String userName, String password, String runMode) {
	  if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("Run mode for this set of data is marked N");
		}
		Home homePage = login.loginToApplication(userName, password);
		homePage.logout();
		System.out.println("implicite wait is: "+System.getProperty("implicitWait"));
  }

}
