package dong.com.ImocTest;

import java.io.UnsupportedEncodingException;

import javax.mail.internet.MimeUtility;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;

import dong.com.utils.TestCaseReport;

/** 

* @Description: 
* @param:
* @return:
* @author: zhangdongdong

* @Date: 2019年11月8日 下午5:23:01
 

*/
public class SendEmail {
	public static void main(String[] args) throws EmailException {
		TestCaseReport t =new TestCaseReport();
		System.out.println("this is test----------------->");
		   EmailAttachment attachment = new EmailAttachment();  
	        // 设置附件路径  
	        attachment.setPath("E:\\workspace\\ImocTest\\16时56分35秒report.html");  
	        attachment.setDisposition(EmailAttachment.ATTACHMENT);  
	        // 附件描述  
	        attachment.setDescription("This is Smile picture");  
	        String fileName = "中文名附件.html";  
	        try {  
	            fileName = MimeUtility.encodeText(fileName); // 解决中文附件乱码  
	        } catch (UnsupportedEncodingException e) {  
	            e.printStackTrace();  
	        }  
	        attachment.setName(fileName);  
	        // 创建一个含附件的email  
	        MultiPartEmail multipartemail = new MultiPartEmail();  
	        multipartemail.setHostName("smtp.qq.com");// 设置主机名称  
	        multipartemail.setCharset("GBK");// 设置字符编码  
			multipartemail.addTo("35353535@qq.com");
			multipartemail.setFrom("35345345@qq.com", "3535");  
			multipartemail.setAuthentication("331157985@qq.com", "dssadsotoganwcrje");// 设置用户名和密码  
			multipartemail.setSubject("测试发送附件");// 设置主题  
			multipartemail.setMsg("暂无");// 设置邮件内容  
			multipartemail.attach(attachment);// 添加附件  
			multipartemail.send();// 发送邮件
			} 
	}


