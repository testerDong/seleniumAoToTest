package dong.com.cases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import dong.com.handle.LoginHandle;
/** 

* @Description: 
* @param:
* @return:
* @author: zhangdongdong

* @Date: 2019年11月7日 下午4:26:34
 

*/

public class TestLoginCase extends BaseCase {
	public WebDriver driver;
	public LoginHandle loginHandle;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browser,String url) {
		
		driver = my_getDriver(browser);
		driver.manage().window().maximize();
		my_openUrl(url);
		loginHandle =new LoginHandle(driver);
	}
	
	@Parameters({"username","password"})
	@Test(description = "验证登录失败")
	public void testLogin(String username,String password) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		loginHandle.sendUserName(username);
		loginHandle.sendPassword(password);
		loginHandle.clickSubmit();
		Assert.assertEquals(loginHandle.getUserText(), "慕仔9502487");
	}
	
	  @AfterClass
	  public void afterClass() {
		  driver.close();
	  }

}
