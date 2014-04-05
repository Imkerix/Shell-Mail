package floatingObjects;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;				
import java.util.Date;

@SuppressWarnings("serial")
/**
 * Represents a Mail.
 */
public class Mail implements Serializable
{

    /**
     * The subject of the mail.
     */
    private String subject;
    /**
     * The content of the mail, as one long {@link java.lang.String}.
     */
    private String content;
    /**
     * The E-Mail address of the sender.
     */
    private String senderEmail;
    /**
     * The E-Mail address of the recipient.
     */
    private String recipientEmail;
    /**
     * The E-Mail of an additional recipient.
     */
    private String cc;
    /**
     * The E-Mail of another additional recipient.
     */
    private String bcc;
    /**
     * The virtual folder this {@link floatingObjects.Mail} is inside. For Example 'drafts'.
     */
    private String folder;
    /**
     * The date this mail was send.
     */
	private Date date = new Date();
    /**
     * A id to identify this {@link floatingObjects.Mail}.
     */
	private int mail_id;
    /**
     * A list containing all attachments as path to the attached {@link java.io.File}.
     */
	private ArrayList<String> attachments = new ArrayList<String>();

    /**
     * Constructs a new {@link floatingObjects.Mail}.
     * @param p_mail_id The id that will be used to identify this {@link floatingObjects.Mail}.
     */
    public Mail(int p_mail_id)
	{
		mail_id = p_mail_id;
	}

    /**
     * Adds all new paths in form of {@link java.lang.String}´s to the {@see attachments}.
     * @param p_allAtachments The new attachments paths.
     */
	public void addAttachments(String[] p_allAtachments)
	{
		for(String string : p_allAtachments)
		{
			attachments.add(string);
		}
	}

    /**
     * Replaces all {@see attachments} with the ones in the parameters. This method will override any attachment given before.
     * @param p_allAtachments The new attachments paths.
     */
	public void replaceAttachments(String[] p_allAtachments)
	{
		attachments.clear();
		addAttachments(p_allAtachments);
	}
	
//// Begin : Ultimative getter ////
    /**
     * Returns a property of this {@link floatingObjects.Mail}.
     * @param p_ArgumentToGet The property to get.
     * @return The requested property, most times a {@link java.lang.String} but not always. It is also possible to get an {@link java.lang.Integer}, a {@link java.util.Date} or a {@link java.lang.String}[].
     */
    public Object get(String p_ArgumentToGet)
    {
        switch (p_ArgumentToGet)
        {
            case "subject": return subject;        
            case "content": return content;
            case "senderemail": return senderEmail;
            case "recipientemail": return recipientEmail;
            case "cc": return cc;
            case "bcc": return bcc;
            case "date": return date;
            case "mail_id": return mail_id;
            case "attachments": return attachments;
            case "folder": return folder;
    
            default: return "Mail oder Argument fehlerhaft";        
        }
    }
//// End : Ultimative getter ////        
//// Begin : Ultimative setter ////
    /**
     * Sets a new value to a property of this {@link floatingObjects.Mail}.
     * @param p_setting The property to change. {@see help.txt}
     * @param p_value The new Property.
     */
    public void set(String p_setting, String[] p_value)
    {
        switch (p_setting)
        {
            case "subject":subject = p_value[0]; break;
            case "content":
            		content = "";
            		for(String s : p_value)
            		{
            			content += s+" ";
            		} break;
            case "senderemail":senderEmail = p_value[0]; break;
            case "recipientemail":recipientEmail = p_value[0]; break;
            case "cc":cc = p_value[0]; break;
            case "bcc":bcc = p_value[0]; break;
            case "date":
                    try
                    {
                            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                            date = formatter.parse(p_value[0]);
                    } catch (ParseException e) {
                            e.printStackTrace();
                    } break;
            case "mail_id":mail_id = Integer.parseInt(p_value[0]); break;
            case "attachments_add":addAttachments(p_value); break;
            case "attachments_replace":replaceAttachments(p_value);break;
            case "folder" :folder = p_value[0]; break;
        }
    }
//// End : Ultimative setter ////
}
