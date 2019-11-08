package dong.com.handle;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

/** 

* @Description: 
* @param:
* @return:
* @author: zhangdongdong

* @Date: 2019年11月7日 下午3:17:33
 

*/
public class BaseHandle {
	public WebDriver driver;
	public BaseHandle(WebDriver driver) {
		this.driver =driver;
	}

	public void setCookie() {
		
		String value="";
		driver.manage().deleteAllCookies();
		Cookie cookie =new Cookie("", value, "", "/", null);
	}

}
