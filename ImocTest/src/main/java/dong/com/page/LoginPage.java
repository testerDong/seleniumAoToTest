package dong.com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	public String file="resources/imooc.properties";
 
	public WebElement myUserNameElement() {
		return getElement(file, "loginname");
	}
	public WebElement myPasswordElement() {
		return getElement(file, "password");
	}
	public WebElement mySubmitElement() {
		return getElement(file, "loginbutton");
	}
	public WebElement myPhoto() {
		return getElement(file, "myphoto");
	}
	
	public WebElement myUserText() {
		return getElement(file, "usertext");
	}
}
