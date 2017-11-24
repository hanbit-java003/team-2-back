package com.hanbit.team2.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hanbit.team2.vo.ContactVO;

@RestController
@RequestMapping("/api")
public class ContactController {

	@RequestMapping("/send")
	@Transactional
	public static void main(@RequestParam("sender") String sender,
			@RequestParam("name") String name,
			@RequestParam("title") String title,
			@RequestParam("subject") String subject,
			HttpServletResponse response, HttpServletRequest request)throws Exception {

		ContactVO contactVO = new ContactVO();
		contactVO.setName(name);
		contactVO.setTitle(title);
		contactVO.setText(subject);

		sender = request.getParameter("sender");
		title = contactVO.getTitle();
		name = contactVO.getName();

		System.out.println(sender);

		Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.user", name);

		Session session =  Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("qorrnakstp@gmail.com", "luljdkhrrwjxcsjz");
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(MimeUtility.encodeText(name), MimeUtility.encodeText(sender)));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress("qorrnakstp@gmail.com"));
			message.setSubject(contactVO.getTitle());
			message.setText(contactVO.getText());

			Transport.send(message);
		}
		catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
