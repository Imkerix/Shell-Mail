package MailProcessing;

/**
 * Created by erik on 4/5/14.
 */
import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail
{
    public void sendMail(String outboxserver, final String username, final String passwd, String senderAddress, String recipientAddress, String ccAdress, String bccAdress, String subject,String text,ArrayList<String> attachments)
    {
        Authenticator authenticator = new Authenticator()
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, passwd);
            }
        };

        Properties properties = new Properties();
        properties.put("mail.smtp.host", outboxserver);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getDefaultInstance(properties, authenticator);

        try
        {
            // create new mail
            MimeMessage message = new MimeMessage(session);

            // set recipient and sender
            message.setFrom(new InternetAddress(senderAddress));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientAddress, false));

                if (ccAdress != null)
                {
                    message.addRecipient(Message.RecipientType.CC, new InternetAddress(ccAdress));
                }
                if (bccAdress != null)
                {
                    message.addRecipient(Message.RecipientType.BCC,new InternetAddress(bccAdress));
                }

            // Der Betreff und Body der Message werden gesetzt
            message.setSubject(subject);
            MimeBodyPart messagePart = new MimeBodyPart();
            messagePart.setText(text);

            // Adds all attachments to the mail
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(messagePart);
                for (String attachment : attachments)
                {
                    FileDataSource dataSource = new FileDataSource(attachment);
                    MimeBodyPart attachmentPart = new MimeBodyPart();
                    attachmentPart.setDataHandler(new DataHandler(dataSource));
                    attachmentPart.setFileName(dataSource.getName());
                    multipart.addBodyPart(attachmentPart);
                }

                message.setContent(multipart);


            // more settings
            message.setSentDate(new Date());

            // send mail
            Transport.send(message);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
