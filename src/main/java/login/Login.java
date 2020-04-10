package login;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.logger.LoggerHelper;
import helper.waitHelper.WaitHelper;
import home.Home;
import testBase.DataSource;

public class Login {
	

	public WebDriver driver;
	private WaitHelper waitHelper;

	private static Logger log = LoggerHelper.getLogger(Login.class);
	
	//String site_url = "http://opesmount.in/erp/frontend/web/login";
	//String browser_type = "Chrome";
	
	@FindBy(xpath = "//input[@id='loginform-username']")
	WebElement userName;
	
	@FindBy(xpath = "//input[@id='loginform-password']")
	WebElement password;;
	
	@FindBy(xpath = "//*[@class='login-but']")
	WebElement loginButton;
	
	public Login(WebDriver driver) 
	{
		super();
		this.driver = driver;
		//**** Constructor used to initialize the above WebElements *****//
		//**** this used to passing the objects of the class ****//
		PageFactory.initElements(driver, this);		
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(userName, DataSource.getExplicitWait());
	}
	
	//*********Setter Method*********//
	public void setUserName(String userName) 
	{
		log.info("entering user Name: " + userName);
		//***** this keyword as a reference to the current object ******//
		//***** this keyword can also be used inside Methods to call another Method from same Class. ******//
		//***** this keyword can only be the first statement in Constructor. ******//
		//***** A constructor can have either this or super keyword but not both ******//
		this.userName.sendKeys(userName);
	}

	//*********Setter Method*********//
	public void setPassword(String password)
	{
		log.info("entering password: " + password);
		//***** this keyword as a reference to the current object ******//
		//***** this keyword can also be used inside Methods to call another Method from same Class. ******//
		//***** this keyword can only be the first statement in Constructor. ******//
		//***** A constructor can have either this or super keyword but not both ******//
		this.password.sendKeys(password);
	}
	
	public void clickLogin() {
		log.info("clicking login button");
		loginButton.click();

	}
	
	//**** below method retun to the Home page ************//
	public Home loginToApplication(String userName, String password)
	{
		setUserName(userName);
		setPassword(password);
		clickLogin();
		return new Home(driver);
	}
}
