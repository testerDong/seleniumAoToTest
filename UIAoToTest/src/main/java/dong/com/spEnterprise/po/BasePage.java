package dong.com.spEnterprise.po;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

/** 

* @Description: 页面元素基本操作封装类
* @param:
* @return:
* @author: zhangdongdong
* @Date: 2019年10月12日 下午3:01:08
 
*/
public class BasePage {
	
	WebDriver driver;
	String pageTitle;
	Actions action;

	/**
	 * @Description: 构造方法 初始化driver
	 * @param driver
	 */
	public BasePage(WebDriver driver) {
		this.driver = driver;
		action = new Actions(this.driver);
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	/**
	 * 
	 *@description 打开一个指定的url
	 *@param url 
	 *2019年10月12日下午3:12:04
	 */
	public void my_open(String url) {
		// browser 浏览器最大化
		this.driver.manage().window().maximize();
		this.driver.get(url);
		Reporter.log("打开网址：" + url);
	}

	
	/**
	 * 
	 *@description  点击操作 
	 *@param element
	 *2019年10月12日下午3:12:42
	 */
	public void my_click(WebElement element) {
		try {

			element.click();
			Reporter.log("点击:" + my_getResult(element));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 
	 *@description 文本款输入指定的值
	 *@param element 输入框元素
	 *@param text 输入文本框的值
	 *2019年10月12日下午3:13:10
	 */
	public void my_input_text(WebElement element, String text) {
		try {
			element.sendKeys(text);
			Reporter.log("文本框输入的值为：" + text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 *@description 清空一个文本框并输入指定的值
	 *@param element 输入框元素
	 *@param text 输入文本框的值
	 *2019年10月12日下午3:14:10
	 */
	
	public void my_clear_input(WebElement element, String text) {
		try {
			element.clear();
			Reporter.log("文本框的值已清空！");
			element.sendKeys(text);
			Reporter.log("文本框输入的值为：" + text);
		} catch (Exception e) {
			e.printStackTrace();
		}

	} 


	/**
	 * 
	 *@description 获取页面的title
	 *@return
	 *2019年10月12日下午3:14:43
	 */
	public String my_getpage_title() {
		pageTitle = this.driver.getTitle();
		Reporter.log("获取到的页面title是" + pageTitle);
		return pageTitle;
	}

	/**
	 * 
	 *@description 关闭浏览器 
	 *2019年10月12日下午3:15:00
	 */
	public void my_quit() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.driver.close();
	}

	/**
	 * 
	 *@description 获取元素文本内容
	 *@param element
	 *@return
	 *2019年10月12日下午3:15:18
	 */
	public String my_getResult(WebElement element) {
		return element.getText();
	}

	/**
	 * 
	 *@description 提交按钮 
	 *@param element
	 *2019年10月12日下午3:15:39
	 */
	public void my_click_button(WebElement element) {
		element.click();
		Reporter.log("点击提交按钮完成！");
	}

	/**
	 * 
	 *@description  切换frame框架
	 *@param frameName 框架name
	 *2019年10月12日下午3:15:49
	 */
	public void my_switch_frame(String frameName) {
		try {
			this.driver.switchTo().frame(frameName);
			Reporter.log("切换frame到：" + frameName);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 
	 *@description 退出当前框架切换到新的frame框架
	 *@param frameName 需要切换到的framename
	 *2019年10月12日下午3:16:15
	 */
	public void my_clsw_frame(String frameName) {
		try {

			this.driver.switchTo().parentFrame();
			this.driver.switchTo().frame(frameName);
			Reporter.log("切换到新的frame：" + frameName);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 
	 *@description 鼠标悬浮
	 *@param element
	 *2019年10月12日下午3:16:46
	 */
	public void my_clickHold(WebElement element) {
		try {
			action.clickAndHold(element);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 
	 *@description 通过vale获取下拉框的值
	 *@param webElement
	 *@param value
	 *2019年10月12日下午3:17:16
	 */
 	public void my_getSelects(WebElement webElement, String value) {
		try {

			Select select = new Select(webElement);
			select.selectByValue(value);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
