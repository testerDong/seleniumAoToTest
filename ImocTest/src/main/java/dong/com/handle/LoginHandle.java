package dong.com.handle;
/** 

* @Description: 
* @param:
* @return:
* @author: zhangdongdong

* @Date: 2019年11月7日 下午4:13:11
 

*/

import org.openqa.selenium.WebDriver;
import dong.com.page.LoginPage;

public class LoginHandle {
	public WebDriver driver;
	public LoginPage loginPage;
	public LoginHandle(WebDriver driver) {
		loginPage =new LoginPage(driver);
	}
/**
 * 
 *@description 登录页面输入手机号
 *@param username
 *2019年11月8日下午3:42:56
 */
	public void sendUserName(String username) {
		loginPage.myUserNameElement().sendKeys(username);
		
	}
	
	/**
	 * 
	 *@description 登录页面输入密码 
	 *@param password
	 *2019年11月8日下午3:43:21
	 */
	public void sendPassword(String password) {
		loginPage.myPasswordElement().sendKeys(password);
	
	}
	/**
	 * 
	 *@description 点击登录按钮 
	 *2019年11月8日下午3:43:42
	 */
	public void clickSubmit() {
		loginPage.mySubmitElement().click();
	}
	
	/**
	 * 
	 *@description 获取登录成功页面的用户名 
	 *@return
	 *2019年11月8日下午3:44:04
	 */
	public String getUserText() {
		loginPage.moveElement(loginPage.myPhoto());
		String userText=loginPage.myUserText().getText();
		return userText;
	}
}
