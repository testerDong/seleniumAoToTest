package dong.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import dong.com.spEnterprise.untils.SendEmail;

/**
 * 
 * @Description:
 * @param:
 * @return:
 * @author: zhangdongdong
 * 
 * @Date: 2019年9月6日 下午6:06:04
 * 
 * 
 */
public class TestSendReport {
	private static Logger logger = Logger.getLogger(TestSendReport.class);

	@Test
	public void sendReport() {
		// CreateZip.createZips("E:\\workspace\\testngSelenium\\test-output");
		List<String> attachments = new ArrayList<String>();
		attachments.add(System.getProperty("user.dir") + "\\test-output\\index.html");
		SendEmail.sendEmails("331157985@qq.com", "331157985@qq.com", "testNG测试报告发送", "详情请查看附件", attachments);
		logger.info("自动化测试报告，邮件发送成功");
	}

}
