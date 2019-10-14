package dong.test;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import dong.com.spEnterprise.po.LoginSpEnterprise;

/** 

* @Description: 
* @param:
* @return:
* @author: zhangdongdong

* @Date: 2019年9月4日 下午5:28:51
 

*/
public class TestLoginSpEnterprise {
	
	public static WebDriver driver;
	private static Logger logger = Logger.getLogger(TestLoginSpEnterprise.class);
	@DataProvider
	public Object[][] lg(){
		return new Object[][] {
//			    {"","admin","a111111"},
//			    {"fan1","","a111111"},
				{"fan1","admin","a111111","Y497209128"},
				
		};
	}
	@Test(dataProvider="lg",description="测试登录自服务平台")
	public void testLogin(String username,String userid,String password,String result) {
		logger.info("进行登录操作！");
		LoginSpEnterprise ls = PageFactory.initElements(driver, LoginSpEnterprise.class);
		ls.my_open("http://10.10.178.152:8080/spEnterprise/authenticationPos!login.action");
		ls.login(username, userid, password);
		Assert.assertTrue(driver.getPageSource().contains(result));
		
	}
	@BeforeSuite
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "E:\\workspace\\seleniumSource\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@AfterSuite
	public void quit() {
		driver.quit();

	}
}
