package br.arantes.util;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mail {

	private final String username = "suporte@grupocereal.com.br";

	private final String password = "#8uB84L0o,1";

	private String from = "suporte@grupocereal.com.br";

	private String host = "smtp.exchangecorp.com.br";

	private String port = "587";

	public void sendMailPasswordRecovery(String to, String randomToken) {

		Properties props = getProperties(this.getHost(), this.getPort());
		Session session = getSession(props, this.getUsername(), this.getPassword());

		String subject = "Recuperação de senha.";
		String bodyMessage = "Esta é uma mensagem automática. Não responda a este e-mail. "
				+ "\n\nCaso não solicitou redefinição de senha, favor desconsiderar esta mensagem." + "\n\n" + "Token: "
				+ randomToken + "\n\n" + "Insira o token na página em que solicitou a recuperação de senha." + "\n\n\n";

		try {
			Message message = new MimeMessage(session);
			message = constructMessageHeader(message, from, to, subject);
			message = construckBodyMessage(message, bodyMessage);
			Transport.send(message);
		} catch (java.lang.Exception e) {
			System.out.println(e);
		}
	}

	public void sendMail(String to, String subject, String bodyMessage) {

		Properties props = getProperties(this.getHost(), this.getPort());
		Session session = getSession(props, this.getUsername(), this.getPassword());

		try {
			Message message = new MimeMessage(session);
			message = constructMessageHeader(message, from, to, subject);
			message = construckBodyMessage(message, bodyMessage);
			Transport.send(message);
		} catch (java.lang.Exception e) {
			System.out.println(e);
		}
	}

	public void sendMailwithAttachment(String to, File file, String subject, String bodyMessage) {
		Properties props = getProperties(this.getHost(), this.getHost());

		Session session = getSession(props, this.getUsername(), this.getPassword());

		try {
			Message message = new MimeMessage(session);
			message = constructMessageHeader(message, from, to, subject);
			message = construckBodyMessageMailwithAttachment(message, bodyMessage, file);
			Transport.send(message);
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}

	private Message constructMessageHeader(Message message, final String from, final String to, String subject) {
		try {
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	private Message construckBodyMessage(Message message, String bodyMessage) {
		BodyPart messageBodyPart = new MimeBodyPart();

		try {
			messageBodyPart.setText(bodyMessage);

			Multipart multipart = new MimeMultipart();

			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	private Message construckBodyMessageMailwithAttachment(Message message, String bodyMessage, File file) {
		BodyPart messageBodyPart = new MimeBodyPart();
		BodyPart messageBodyPart2 = new MimeBodyPart();
		try {
			messageBodyPart2.setText(bodyMessage);

			Multipart multipart = new MimeMultipart();

			multipart.addBodyPart(messageBodyPart);
			multipart.addBodyPart(messageBodyPart2);
			DataSource source = new FileDataSource(file);

			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName("anexo.pdf");
			message.setContent(multipart);
		} catch (java.lang.Exception e) {
			System.out.println(e);
		}
		return message;
	}

	private Properties getProperties(String host, String port) {
		Properties props = new Properties();
		props.setProperty("mail.smtp.ssl.trust", "*");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.host", host);
		props.setProperty("mail.smtp.port", port);
		return props;
	}

	private Session getSession(Properties props, final String username, final String password) {
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		return session;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
