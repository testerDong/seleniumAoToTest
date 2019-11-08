package dong.com.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.google.common.io.Files;
import dong.com.cases.BaseCase;

/** 

* @Description: 该类继承了 TestListenerAdapter监听，实现了截图
* @param:
* @return:
* @author: zhangdongdong

* @Date: 2019年11月8日 上午11:06:02
 

*/
public class TestNGListenerScreen extends TestListenerAdapter {
	
	@Override
	  public void onTestFailure(ITestResult tr) {
		
		BaseCase tc =(BaseCase)tr.getInstance();
		
		WebDriver driver = tc.driver;
		this.takeScreenShot(driver,tr.getTestClass().getName());
		 super.onTestFailure(tr);
	  }
	
	/**
	 * 
	 *@description 该类主要是生成截图
	 *@param driver
	 *2019年11月8日下午2:24:23
	 */
	public void takeScreenShot(WebDriver driver,String curClassName) {
		//图片保存路径
		//获取当前时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String curTime = sdf.format(new Date());
		//获取当前类名
//		String curClassName = this.getClass().getSimpleName();
		//图片名称
		String photoName = curClassName + "_" + curTime + ".png";
		
		//图片保存路径
		String photoPath = System.getProperty("user.dir")+ "\\takeScreenShot";
		
		//生成截图
		File ScrFile = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(ScrFile, new File(photoPath+"\\"+photoName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
