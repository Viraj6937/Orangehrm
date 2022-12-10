package page_object;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPageObject {

	public WebDriver driver;
	private By user_profile_name = By.cssSelector("div.oxd-topbar-header-userarea > ul > li > span > p");
	private By user_profile_image = By.cssSelector("div.oxd-topbar-header-userarea > ul > li > span > img");
	private By user_account_tab = By.cssSelector("div.oxd-topbar-header-userarea > ul > li > span");
	private By user_account_option_list = By.cssSelector("div.oxd-topbar-header-userarea > ul > li > ul > li");
	private By dashboard_heading = By.cssSelector("div.oxd-topbar-header > div > span > h6");
	private By image_list = By.tagName("img");
	private By link_list = By.tagName("a");
	private By widget_list = By.cssSelector("div.oxd-grid-item.orangehrm-dashboard-widget");
	private By svg_list = By.tagName("svg");
	private By account_window_heading = By.cssSelector("div.oxd-dialog-container-default--inner > div > div > h6");
	private By myactions_widget_list_items = By.cssSelector("div.orangehrm-todo-list-item > p");
	private By quicklaunch_widget_list_items = By.cssSelector("div.orangehrm-dashboard-widget-body > div.oxd-grid-3 > div");
	
	public DashboardPageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement get_user_profile_name_label() {
		return driver.findElement(user_profile_name);
	}
	
	public WebElement get_user_profile_image() {
		return driver.findElement(user_profile_image);
	}
	
	public WebElement get_user_account_tab() {
		return driver.findElement(user_account_tab);
	}
	
	public List<WebElement> get_user_account_list_options(){
		return driver.findElements(user_account_option_list);
	}
	
	public WebElement get_page_heading() {
		return driver.findElement(dashboard_heading);
	}
	
	
	public List<WebElement> get_images(){
		return driver.findElements(image_list);
	}
	
	public List<WebElement> get_links(){
		return driver.findElements(link_list);
	}
	
	public List<WebElement> get_widgets(){
		return driver.findElements(widget_list);
	}
	
	public List<WebElement> get_svg(){
		return driver.findElements(svg_list);
	}
	
	public WebElement get_account_window_heading() {
		return driver.findElement(account_window_heading);
	}
	
	public List<WebElement> get_myactions_widget_list_items(){
		return driver.findElements(myactions_widget_list_items);
	}
	
	public List<WebElement> get_quicklaunch_widget_list_items(){
		return driver.findElements(quicklaunch_widget_list_items);
	}
	
	public void getLogout() {
		this.get_user_account_tab().click();
		List<WebElement> options = this.get_user_account_list_options();
		for(int i=0; i<options.size();i++) {
			String optionLabel = options.get(i).getText();
			if(optionLabel.contains("Logout")) {
	           int rowIndex = options.size();
	           driver.findElement(By.cssSelector("div.oxd-topbar-header-userarea > ul > li > ul > li:nth-Child("+rowIndex+") > a")).click();
			}
		}
	}
}
