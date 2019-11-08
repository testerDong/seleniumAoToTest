package dong.com.utils;

import java.io.UnsupportedEncodingException;

import javax.mail.internet.MimeUtility;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.log4j.Logger;
import org.testng.IExecutionListener;

/**
 * 
 * @Description:
 * @param:
 * @return:
 * @author: zhangdongdong
 * 
 * @Date: 2019年11月8日 下午5:12:34
 * 
 * 
 */
public class TestNGListennerSendEmail implements IExecutionListener {
	private Logger logger = Logger.getLogger(TestNGListennerSendEmail.class);

	public void onExecutionStart() {
		logger.debug("开始执行用例");
	}

	public void onExecutionFinish() {
		

		try {

			MultiPartEmail multipartemail = new MultiPartEmail();
			// 设置主机名称
			multipartemail.setHostName("smtp.qq.com");
			// 设置字符编码
			multipartemail.setCharset("GBK");
			multipartemail.addTo("wrwrwrwre@qq.com");
			multipartemail.setFrom("rewrwerwr@qq.com", "张方法");
			// 设置用户名和密码
			multipartemail.setAuthentication("331157985@qq.com", "tertrte");
			// 设置主题
			multipartemail.setSubject("selenium测试报告");
			multipartemail.setMsg("测试报告，详情见附件");
			EmailAttachment attachment = new EmailAttachment();
			// 设置附件路径
			attachment.setPath(TestCaseReport.emailPath);
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			String fileName = "测试报告.html";
			// 附件名解决中文附件乱码
			fileName = MimeUtility.encodeText(fileName);
			attachment.setName(fileName);
			// 添加附件
			multipartemail.attach(attachment);
			// 发送邮件
			multipartemail.send();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("测试报告发送成功");
	}

}
