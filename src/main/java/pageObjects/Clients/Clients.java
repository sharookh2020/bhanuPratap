package pageObjects.Clients;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.logger.LoggerHelper;
import helper.waitHelper.WaitHelper;
import testBase.DataSource;

public class Clients {
	
	
	WebDriver driver;
	private WaitHelper waitHelper;
	
	private static Logger log = LoggerHelper.getLogger(Clients.class);
	
	@FindBy(xpath = "//a[contains(@href,'/erp/frontend/web/clients') and @title='Clients']")
	WebElement client_top_menutab;
	
	@FindBy(xpath = "//a[contains(@href,'/erp/frontend/web/client/create')]")
	WebElement createclient_leftmenu;
	
	@FindBy(xpath = "//h1[contains(text(),'Create Client')]")
	WebElement client_headername;
	
	@FindBy(xpath = "//input[@id='client-client_name']")
	WebElement client_clientname;
	
	@FindBy(xpath = "//textarea[@id='client-client_address']")
	WebElement client_clientAddress;
	
	@FindBy(xpath = "//input[@id='client-postcode']")
	WebElement client_postcode;
	
	@FindBy(xpath = "//input[@id='client-state']")
	WebElement client_state;
	
	@FindBy(xpath = "//input[@id='client-phone']")
	WebElement client_phone;
	
	@FindBy(xpath = "//input[@id='client-email']")
	WebElement client_email;
	
	@FindBy(xpath = "//input[@id='client-status']")
	WebElement client_status;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement client_savebutton;
	
	@FindBy(xpath = "//a[contains(text(),'Update')]")
	WebElement client_update;
	
	
	public Clients(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(client_top_menutab, DataSource.getExplicitWait());
		waitHelper.waitForElement(createclient_leftmenu, DataSource.getExplicitWait());
//		waitHelper.waitForElement(client_headername, DataSource.getExplicitWait());
//		waitHelper.waitForElement(client_clientname, DataSource.getExplicitWait());
//		waitHelper.waitForElement(client_status, DataSource.getExplicitWait());
//		waitHelper.waitForElement(client_savebutton, DataSource.getExplicitWait());
		
	}
	
	public void clickClientMenu()
	{
		waitHelper.waitForElement(client_top_menutab, DataSource.getExplicitWait());
		log.info("Clicking on Client Menu Tab");
		client_top_menutab.click();
	}
	public void clickOnClientLeftMenuTab()
	{
		waitHelper.waitForElement(createclient_leftmenu, DataSource.getExplicitWait());
		log.info("Clicking on Client Left Menu Tab");
		createclient_leftmenu.click();
	}
	public void enterClientName(String client_clientname)
	{
		waitHelper.waitForElement(this.client_clientname, DataSource.getExplicitWait());
		log.info("Enter Client name as : "+client_clientname);
		this.client_clientname.sendKeys(client_clientname);
	}
	public void enterClientAddress(String client_clientAddress)
	{
		waitHelper.waitForElement(this.client_clientAddress, DataSource.getExplicitWait());
		log.info("Enter Client address as : "+client_clientAddress);
		this.client_clientAddress.sendKeys(client_clientAddress);
	}
	public void enterClientPostCode(String client_postcode)
	{
		waitHelper.waitForElement(this.client_postcode, DataSource.getExplicitWait());
		log.info("Enter Client pincode as : "+client_postcode);
		this.client_postcode.sendKeys(client_postcode);
	}
	public void enterClientState(String client_state)
	{
		waitHelper.waitForElement(this.client_state, DataSource.getExplicitWait());
		log.info("Enter Client state as : "+client_state);
		this.client_state.sendKeys(client_state);
	}
	public void enterClientPhone(String client_phone)
	{
		waitHelper.waitForElement(this.client_phone, DataSource.getExplicitWait());
		log.info("Enter Client phone as : "+client_phone);
		this.client_phone.sendKeys(client_phone);
	}
	public void enterClientEmail(String client_email)
	{
		waitHelper.waitForElement(this.client_email, DataSource.getExplicitWait());
		log.info("Enter Client email as : "+client_email);
		this.client_email.sendKeys(client_email);
	}
	public void clickOnStatus(String client_status)
	{
		waitHelper.waitForElement(this.client_status, DataSource.getExplicitWait());
		log.info("Clicking on Status radio button");
		this.client_status.click();		

	}
	public void clickOnClientSave_Button() throws InterruptedException
	{
		waitHelper.waitForElement(client_savebutton, DataSource.getExplicitWait());
		log.info("Clicking on Client Save Button");
		client_savebutton.click();
		//Thread.sleep(1000);
	}
	
	
	/**
	 * This Method will create Client
	 * @param client_clientname
	 * @param client_clientAddress
	 * @param client_postcode
	 * @param client_state
	 * @param client_phone
	 * @param client_email
	 * @param client_status
	 * @throws InterruptedException 
	 */
	public void createClients(String client_clientname, String client_clientAddress, String client_postcode, String client_state, String client_phone, String client_email, String client_status) throws InterruptedException
	{
		clickClientMenu();
		clickOnClientLeftMenuTab();
		enterClientName(client_clientname);
		enterClientAddress(client_clientAddress);
		enterClientPostCode(client_postcode);
		enterClientState(client_state);
		enterClientPhone(client_phone);
		enterClientEmail(client_email);
		clickOnStatus(client_status);
		clickOnClientSave_Button();
				
	}
	
	

}
