package MailProcessing;

import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

/**
 * Created by erik on 4/5/14.
 */
public class CheckMail
{
    public void check(String server, String port, String storeType, String user, String password)
    {
        Properties properties = new Properties();
        properties.put("mail.pop3.host",server);
        properties.put("mail.pop3.port", port);
        properties.put("mail.pop3.starttls.enable", "true");
        Session emailSession = Session.getDefaultInstance(properties);


        try
        {
            Store store = emailSession.getStore("imap");
            store.connect(server, user, password);

            Folder[] emailFolders = store.getPersonalNamespaces();
            for (Folder folder : emailFolders)
            {
                System.out.println(folder.getFolder("SEND").getName());
                System.out.println(folder.getFolder("DRAFT").getName());
                System.out.println(folder.getFolder("INBOX").getName());
                System.out.println(folder.getFolder("OUTBOX").getName());
                System.out.println(folder.getFolder("JUNK").getName());
                System.out.println(folder.getFolder("TRdfdSH").getName());
            }
//            emailFolder.open(Folder.READ_ONLY);
            //Messages are Ready to get used

//            Message[] messages = emailFolder.getMessages();
//            System.out.println(messages.length);
//            emailFolder.close(false);
            store.close();
        }
        catch (MessagingException e){
            e.printStackTrace();
        }




    }
}
