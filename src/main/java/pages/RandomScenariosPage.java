package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.DataUtils;

public class RandomScenariosPage extends BasePage {
	public RandomScenariosPage(WebDriver driver) {
		super(driver);
	}
	UserMenuPage ump;
	
	@FindBy(id = "home_Tab")
	public WebElement homeTab;
	
	@FindBy(xpath = "//h1[@class='currentStatusUserName']")
	public WebElement currentUserContainer;
	
	@FindBy(xpath = "//h1[@class='currentStatusUserName']")
	public WebElement userNameLink;
	
	@FindBy(id = "AllTab_Tab")
	public WebElement allTab;
	
	@FindBy(xpath = "//input[@class='btnImportant']")
	public WebElement customizeMyTab;
	
	@FindBy(id = "duel_select_1")
	public WebElement selectedTabs;
	
	@FindBy(xpath = "//a[@id='duel_select_0_left']/img")
	public WebElement removeBtn;
	
	@FindBy(id = "duel_select_0")
	public WebElement availableTabs;
	
	public void getHomeTab() {
		homeTab.click();		
	}
	public boolean isHomeTabPage(WebDriver driver) throws IOException {
		boolean isHomeTabPage = false;
		String actualTitle = driver.getTitle();
		String expextedTitle = DataUtils.readLoginTestData("homeTabPageTitle");
		if(actualTitle.equals(expextedTitle)) {
			isHomeTabPage = true;
		}
		else {
			isHomeTabPage = false;
		}
		return isHomeTabPage;
	}
	public boolean isUserNameLinkDisplayed(WebDriver driver) {
		boolean isUserNameDisplayed = false;
		UserMenuPage ump = new UserMenuPage(driver);
		String expectedFullName = ump.getUserName(driver);
		
		WebElement h1Element =currentUserContainer; 
        // Locate the anchor tag within the h1 element
        WebElement linkElement = h1Element.findElement(By.tagName("a"));
        // Get the text of the anchor tag
       	String actualFullName = linkElement.getText();
       	
		if (actualFullName.equals(expectedFullName)) {
			isUserNameDisplayed = true;
            System.out.println("The user's first name and last name are displayed as a link: " + actualFullName);
        } else {
        	isUserNameDisplayed = false;
            System.out.println("The displayed link text does not match the expected name. Found: " + actualFullName);
        }
		return isUserNameDisplayed;
	}
	public void getUserNameLink(WebDriver driver) {
		userNameLink.click();		
	}

	public boolean isUserNamePagesSameAsMyProfile(WebDriver driver) throws IOException {
		boolean arePagesSame = false;
		String currentPageTitle = driver.getTitle();
		ump = new UserMenuPage(driver);
		String myProfilePageTitle = "User: "+ump.getUserName(driver)+" ~ Salesforce - Developer Edition";
	
		boolean isSourceSame = currentPageTitle.equals(myProfilePageTitle);
		//Compares the HTML source of the two pages.
		if(isSourceSame) {
			arePagesSame = true;
			logger.info("Both pages are same.");
        } else {
        	arePagesSame = false;
        	logger.info("The pages are different.");
        }
		return arePagesSame;
	}
	public void allTab(WebDriver driver) {
		if(allTab.isDisplayed()) {
			allTab.click();
		}else {
			logger.info("Can not load All tabs.");
		}
	}
	public boolean isAllTabPageLoaded(WebDriver driver) throws IOException {
		boolean isAllTabPage= false;
		String actual = driver.getTitle();
		String expected = DataUtils.readLoginTestData("allTabsPageTitle");
		if(actual.equals(expected)) {
			isAllTabPage = true;
			logger.info("All tabs home Page is displayed");
		}else {
			isAllTabPage= false;
			logger.info("Can not load All tabs home Page.");
		}
		return isAllTabPage;
	}
	public void customizeMyTabBtn(WebDriver driver) {
		customizeMyTab.click();
	}
	public boolean isCustomizeMyTabsPage(WebDriver driver) throws IOException {
		boolean isCustomizeMyTabsPage= false;
		String actual = driver.getTitle();
		String expected = DataUtils.readLoginTestData("customizeMyTabsPageTitle");
		if(actual.equals(expected)) {
			isCustomizeMyTabsPage = true;
			logger.info("'Customize My Tabs' Page is displayed");
		}else {
			isCustomizeMyTabsPage= false;
			logger.info("Can not display 'Customize My Tabs' Page.");
		}
		return isCustomizeMyTabsPage;
	}
	public void removeAnyTab(WebDriver driver) {
		
	}
	
}
