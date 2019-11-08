package dong.com.cases;
/** 

* @Description: 
* @param:
* @return:
* @author: zhangdongdong

* @Date: 2019年11月7日 下午4:30:48
 

*/

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseCase {
	public WebDriver driver;
	private static Logger logger = Logger.getLogger(BaseCase.class);
	public WebDriver my_getDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\workspace\\seleniumSource\\lib\\chromedriver.exe");
			driver =new ChromeDriver();
			logger.debug("打开 Chrome 浏览器");
		}else {
		  	System.setProperty("webdriver.gecko.driver", "D:\\java\\geckodriver\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		  	driver = new FirefoxDriver();
			logger.debug("打开 Firefox 浏览器");

		}
		
		return driver;
	}
	
	public void my_openUrl(String url) {
		driver.get(url);
		logger.debug("打开网址："+url);
	}
	
	public String my_getTitle() {
		String title =driver.getTitle();
		return title;
	}

}
