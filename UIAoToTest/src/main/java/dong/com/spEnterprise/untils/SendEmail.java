package dong.com.spEnterprise.untils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

/**
 * 
 *@title 邮件发送类
 *@description 通过QQ邮箱发送邮件
 *@author ZDD
 *@date 2019年10月9日上午11:05:25
 */
public class SendEmail {
	
	/**
	 * 
	 *@description sendEmails方法，用于发送邮件，可以给多人发送包括多个附件
	 *@param fromAddress  发件人邮箱地址
	 *@param toAddress    收件人邮箱地址
	 *@param emailSubject 邮件主题
	 *@param bodyText     邮件正文
	 *@param attachments  邮件附件内容
	 *@date 2019年10月9日上午11:08:25
	 */
	public static void sendEmails(String fromAddress, String toAddress, String emailSubject, String bodyText,
			List<String> attachments) {
		// 创建一个Property文件对象
		Properties props = new Properties();
		try {
			FileInputStream in = new FileInputStream(".\\resources\\emails.properties");
			props.load(in);
			in.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// 身份验证实现
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				// 第二个参数，就是我QQ开启smtp的授权码
				return new PasswordAuthentication(props.getProperty("userName"), props.getProperty("password"));

			}

		});

		try {

			// 创建一个MimeMessage类的实例对象
			Message message = new MimeMessage(session);

			// 设置发件人邮箱地址
			message.setFrom(new InternetAddress(fromAddress));

			// 设置收件人邮箱地址
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
//					设置多个收件人邮箱地址
//					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("331157985@qq.com,768163577@qq.com"));
			// 设置邮件主题
			message.setSubject(emailSubject);

			// 创建一个MimeBodyPart的对象，以便添加内容
			BodyPart messageBodyPart = new MimeBodyPart();

			// 设置邮件正文内容
			messageBodyPart.setText(bodyText);

			// 创建一个MimeMultipart类的实例对象
			Multipart multipart = new MimeMultipart();
			
			// 添加多个附件
			if (attachments != null) {

				for (int i = 0; i < attachments.size(); i++) {
					MimeBodyPart attachmentBodyPart = new MimeBodyPart();
					DataSource source = new FileDataSource(attachments.get(i));
					attachmentBodyPart.setDataHandler(new DataHandler(source));
					// MimeUtility.encodeWord可以避免文件名乱码
					try {
						attachmentBodyPart.setFileName(MimeUtility.encodeWord(attachments.get(i)));
					} catch (UnsupportedEncodingException e) {
						System.out.println(e);
					}
					multipart.addBodyPart(attachmentBodyPart);
					
				}
				 
			}

			// 添加正文1内容
			multipart.addBodyPart(messageBodyPart);

			// 设置内容
			message.setContent(multipart);

			// 最终发送邮件
			Transport.send(message);

		} catch (MessagingException e) {

			throw new RuntimeException(e);

		}

	}

}
