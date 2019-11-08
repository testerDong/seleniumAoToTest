package dong.com.ImocTest;

import org.apache.log4j.Logger;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


/** 

* @Description: 
* @param:
* @return:
* @author: zhangdongdong

* @Date: 2019年11月7日 下午4:56:58
 

*/
public class TestLogin {
	private WebDriver driver;
	static Logger logger = Logger.getLogger(TestLogin.class);
	@Test
	public void testL() {
		System.setProperty("webdriver.chrome.driver", "E:\\workspace\\seleniumSource\\lib\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://passport.tujia.com/PortalSite/LoginPage/");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//form[@id='userLoginForm']/div[5]/input")).click();;
	}

}
