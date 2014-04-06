package logic;

import MailProcessing.CheckMail;
import MailProcessing.SendMail;
import com.martiansoftware.jsap.JSAPException;

/**
 * The class to start the {@link logic.Backbone}.
 */
public class Main 
{
    /**
     * Creates a new {@link logic.Backbone}.
     * @param args The arguments given to the JVM.
     * @throws JSAPException Parsing problems by {@link com.martiansoftware.jsap.JSAPException}.
     */
	public static void main(String[] args) throws JSAPException
	{
		@SuppressWarnings("unused")
        /**
         * The {@link logic.Backbone} object.
         */
        Backbone mylogic = new Backbone(args);
//        CheckMail checkMail = new CheckMail();
//        checkMail.check("imap.aol.com","143","imap","erik.heinisch@aol.de","1LOLOtrolo");

//        SendMail sendMail = new SendMail();
//        String[] attachments = {}; //{"/home/erik/test","/home/erik/test1","/home/erik/test2"};
//        sendMail.sendMail("smtp.aol.de","erik.heinisch@aol.de","1LOLOtrolo","erik.heinisch@aol.de","Imkerixus@gmail.com","Imkerix@live.de",null,"You got it","content",attachments);
	}
}
