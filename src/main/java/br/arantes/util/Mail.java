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

import br.arantes.admin.entity.User;

public class Mail {

	private final String username = "sup.start.project@gmail.com";

	private final String password = "#St4rt3r!";

	private String from = "sup.start.project@gmail.com";

	private String host = "smtp.gmail.com";

	private String port = "587";

	public void sendMailPasswordRecovery(User user, String token) {

		Properties props = getProperties(this.getHost(), this.getPort());
		Session session = getSession(props, this.getUsername(), this.getPassword());
		String subject = "Recuperação de senha.";
		String bodyMessage = ""
				+ "<table align=\"center\" style=\"width: 538px;\">                                                                                                                                                                        "
				+ "	<tbody>                                                                                                                                                                                                                "
				+ "		<tr>                                                                                                                                                                                                               "
				+ "			<td bgcolor=\"#313b4f\">                                                                                                                                                                                       "
				+ "				<table width=\"470\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"padding-left: 5px; padding-right: 5px; padding-bottom: 10px\">                                              "
				+ "					<tbody>                                                                                                                                                                                                "
				+ "						<tr bgcolor=\"#313b4f\">                                                                                                                                                                           "
				+ "							<td style=\"padding-top: 32px\">                                                                                                                                                               "
				+ "								<span style=\"font-size: 24px; color: rgb(102, 192, 244); font-family: Arial, Helvetica, sans-serif, serif, EmojiFont; font-weight: bold; \">Olá, " + user.getName()
				+ "</span><br>                                                                                                                                                                                                             "
				+ "							</td>                                                                                                                                                                                          "
				+ "						</tr>                                                                                                                                                                                              "
				+ "						<tr>                                                                                                                                                                                               "
				+ "							<td style=\"padding-top: 12px; font-size: 17px; color: white; font-family: Arial, Helvetica, sans-serif; font-weight: bold\">                                                                  "
				+ "								Aqui está o código que você precisa para mudar sua senha:                                                                                                                                  "
				+ "							</td>                                                                                                                                                                                          "
				+ "						</tr>                                                                                                                                                                                              "
				+ "						<tr>                                                                                                                                                                                               "
				+ "							<td style=\"padding-top: 24px; padding-bottom: 24px\">                                                                                                                                         "
				+ "								<div>                                                                                                                                                                                      "
				+ "									<span style=\"font-size: 24px; color: rgb(102, 192, 244); font-family: Arial, Helvetica, sans-serif, serif, EmojiFont; font-weight: bold;\">" + token
				+ "</span> <br>                                                                                                                                                                                                            "
				+ "								</div>                                                                                                                                                                                     "
				+ "							</td>                                                                                                                                                                                          "
				+ "						</tr>                                                                                                                                                                                              "
				+ "						<tr bgcolor=\"#121a25\">                                                                                                                                                                           "
				+ "							<td style=\"padding: 20px; font-size: 12px; line-height: 17px; color: #c6d4df; font-family: Arial, Helvetica, sans-serif\">                                                                    "
				+ "								Se você não está tentando alterar sua senha, ignore este e-mail.                                                                                                                           "
				+ "								É possível que outro usuário inseriu suas informações de login incorretamente.                                                                                                             "
				+ "							</td>                                                                                                                                                                                          "
				+ "						</tr>                                                                                                                                                                                              "
				+ "					</tbody>                                                                                                                                                                                               "
				+ "				</table>                                                                                                                                                                                                   "
				+ "			</td>                                                                                                                                                                                                          "
				+ "		</tr>                                                                                                                                                                                                              "
				+ "	</tbody>                                                                                                                                                                                                               "
				+ "</table>";

		try {
			Message message = new MimeMessage(session);
			message = constructMessageHeader(message, from, user.getEmail(), subject);
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

		try {
			message.setContent(bodyMessage, "text/html");
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



