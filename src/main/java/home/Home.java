package home;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.logger.LoggerHelper;
import helper.waitHelper.WaitHelper;
import login.Login;
import pageObjects.Clients.Clients;
import testBase.DataSource;

public class Home {
	
	private static Logger log = LoggerHelper.getLogger(Home.class);
	private WebDriver driver;
	private WaitHelper waitHelper;
	
	
	@FindBy(xpath="//h1[contains(text(),'ERP | Dashboard')]")
//    WebElement vtigerHomePageLogo;
    WebElement dashboard_header;

	@FindBy(xpath="/html/body/div/header/nav/div/ul/li[6]/a")
	WebElement profile;
	
	@FindBy(xpath="//li[6][contains(@class, 'dropdown open')]")
	WebElement profile_link;
	
	@FindBy(xpath="//a[contains(@href,'/erp/frontend/web/logout') and @class='logout-btn']")
	WebElement signOut;
	
	@FindBy(xpath = "//a[contains(@href,'/erp/frontend/web/clients') and @title='Clients']")
	WebElement client_top_menutab;
	
	
	public Home(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(dashboard_header, DataSource.getExplicitWait());
	}
	
	public Login logout() {
		log.info("performing mouse over...");
		profile_Click();
		waitHelper.waitForElement(profile_link, DataSource.getExplicitWait());
        Actions action = new Actions(driver);
        action.moveToElement(profile_link).build().perform();
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		waitHelper.waitForElement(signOut, DataSource.getExplicitWait());
		signOut.click();
		log.info("clicked on signout...");
		return new Login(driver);
	}
	
	public void profile_Click()
	{
		waitHelper.waitForElement(profile, DataSource.getExplicitWait());
		log.info("Click profile link");
		profile.click();
	}
	
	/**
	 * 
	 * @return {@link Leads}
	 */
	public Clients navigateToClients(){
		waitHelper.waitForElement(client_top_menutab, DataSource.getExplicitWait());
		log.info("navigating to Clients");
//		client.click();
		client_top_menutab.click();
		return new Clients(driver);
	}

	

}
