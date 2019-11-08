package dong.com.page;
/** 

* @Description: 
* @param:
* @return:
* @author: zhangdongdong

* @Date: 2019年11月7日 上午10:59:17
 

*/

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import dong.com.utils.propUtil;


public class BasePage {
	public WebDriver driver;
	private static Logger logger =Logger.getLogger(BasePage.class);
	public BasePage(WebDriver driver) {
		this.driver =driver;
	
	}
	
	/**
	 * 
	 *@description 该方法是获取定位元素
	 *@param elementFilePath
	 *@param key
	 *@return
	 *2019年11月7日下午2:37:18
	 */
	public WebElement getElement(String elementFilePath,String key) {
		WebElement element =null;
		element = driver.findElement(getLocation(elementFilePath, key));
		return element;
	}
	
	/**
	 * 
	 *@description 该方法主要是通过获取properties 文件key获取到的valus 值，根据values 来区分定位方式 
	 *@param elementFilePath：元素定位的properties文件位置
	 *@param key： properties文件 里面具体的某个元素的key
	 *@return 元素的定位方法
	 *2019年11月7日下午2:19:44
	 */
	public By getLocation(String elementFilePath,String key) {
		propUtil prop= new propUtil(elementFilePath);
		logger.debug("需要定位的元素是："+key);
		String locator =prop.getProp(key);
		logger.debug("定位到的元素是："+locator);
		String locatorName = locator.split(">")[0];
		String locatorValue = locator.split(">")[1];
		//properties文件格式： email(自定义的页面元素的名字) = className(定位方式)>js_emaliname(定位的值)
		if (locatorName.equals("id")) {
			return By.id(locatorValue);
		}else if (locatorName.equals("className")) {
			return By.className(locatorValue);
		}else if (locatorName.equals("name")) {
			return By.name(locatorValue);
			
		}else if (locatorName.equals("partLinkText")){
			return By.partialLinkText(locatorValue);
		}else {
			return By.xpath(locatorValue);
		}
	}
	
	/**
	 * 
	 *@description 该方法是将鼠标移动到某个元素上面
	 *@param toElement
	 *2019年11月7日下午2:48:39
	 */
	public void moveElement(WebElement toElement) {
		Actions actions = new Actions(driver);
		actions.moveToElement(toElement).perform();;
		
	}
	
	public boolean getCookie(String key) {
		boolean flag =false;
		Set<Cookie> cookies= driver.manage().getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(key)) {
				flag =true;
			}
		}
		return flag;
	}
	
}
