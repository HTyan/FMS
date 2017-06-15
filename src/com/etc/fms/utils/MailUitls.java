package com.etc.fms.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 閭欢鍙戦�宸ュ叿
 * @author YHT
 *
 */
public class MailUitls {
	/**
	 * 鍙戦�閭欢鐨勬柟娉�	 * @param to	:鏀朵欢浜�	 * @param code	:婵�椿鐮�	 */
	public static void sendMail(String to,String code){
		/**
		 * 1.鑾峰緱涓�釜Session瀵硅薄.
		 * 2.鍒涘缓涓�釜浠ｈ〃閭欢鐨勫璞essage.
		 * 3.鍙戦�閭欢Transport
		 */
		// 1.鑾峰緱杩炴帴瀵硅薄
		Properties props = new Properties();
		props.setProperty("mail.host", "localhost");
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("service@shop.com", "111");
			}
			
		});
		// 2.鍒涘缓閭欢瀵硅薄:
		Message message = new MimeMessage(session);
		// 璁剧疆鍙戜欢浜�
		try {
			message.setFrom(new InternetAddress("service@shop.com"));
			// 璁剧疆鏀朵欢浜�
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			// 鎶勯� CC   瀵嗛�BCC
			// 璁剧疆鏍囬
			message.setSubject("鏉ヨ嚜璐墿澶╁爞shop鍟嗗煄瀹樻柟婵�椿閭欢");
			// 璁剧疆閭欢姝ｆ枃:
			message.setContent("<h1>璐墿澶╁爞Shop鍟嗗煄瀹樻柟婵�椿閭欢!鐐逛笅闈㈤摼鎺ュ畬鎴愭縺娲绘搷浣�/h1><h3><a href='http://127.0.0.1:8080/SSH/user_active.action?code="+code+"'>http://192.168.12.248:8080/shop/user_active.action?code="+code+"</a></h3>", "text/html;charset=UTF-8");
			// 3.鍙戦�閭欢:
			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		sendMail("a@shop.com","11111111111111");
	}
}
