package floatingObjects;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;				
import java.util.Date;

import com.sun.org.apache.regexp.internal.recompile;

@SuppressWarnings("serial")
public class Mail implements Serializable
{

	private String subject,content,senderEmail,recipientEmail,cc,bcc,folder;
	private Date date = new Date();
	private int mail_id;
	private ArrayList<String> attachements = null;
	
	public Mail(int p_mail_id)
	{
		mail_id = p_mail_id;
	}
	
	public void addAttachments(String p_allAtachments)
	{
		String[] splitedAttechments = p_allAtachments.split(" ");
		for(String string : splitedAttechments)
		{
			attachements.add(string);
		}
	}
	public void replaceAttachments(String p_allAtachments)
	{
		attachements.clear();
		addAttachments(p_allAtachments);
	}
	
//// Begin : Ultimative getter ////
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
            case "date": return date.toString();
            case "mail_id": return mail_id;
            case "attachements": return attachements;
            case "folder": return folder;
    
            default: return "Mail oder Argument fehlerhaft";        
        }
    }
//// End : Ultimative getter ////        
//// Begin : Ultimative setter ////
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
            case "attachements_add":addAttachments(p_value[0]); break;
            case "attachements_replace":replaceAttachments(p_value[0]);break;
            case "folder" :folder = p_value[0]; break;
        }
    }
//// End : Ultimative setter ////
}
