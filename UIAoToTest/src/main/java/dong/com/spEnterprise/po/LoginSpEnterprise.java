package dong.com.spEnterprise.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @Description:
 * @param:
 * @return:
 * @author: zhangdongdong
 * 
 * @Date: 2019年9月4日 下午5:13:40
 * 
 * 
 */
public class LoginSpEnterprise extends BasePage {

	public LoginSpEnterprise(WebDriver driver) {
		super(driver);
	}

	// 定位页面元素

	@FindBy(id = "assistid")
	WebElement useName;
	
	@FindBy(id = "userid")
	WebElement useId;
	
	@FindBy(id = "passWord")
	WebElement passWord;
	
	@FindBy(xpath="//input[@value='登录']")
	WebElement login_button;

	
	public void login(String username,String userid,String password) {
		//输入用户名
		my_input_text(useName, username);
		//输入用户id
		my_input_text(useId, userid);
		//输入密码
		my_input_text(passWord, password);
		//点击登录
		my_click_button(login_button);
	}
}
