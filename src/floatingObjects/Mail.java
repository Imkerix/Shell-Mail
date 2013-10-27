package floatingObjects;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;				
import java.util.Date;

@SuppressWarnings("serial")
public class Mail implements Serializable
{

	private String subject,content,senderEmail,recipientEmail,cc,bcc;
	private Date date = new Date();
	private int mail_id;
	private ArrayList<String> attachements = null;
	
	public Mail(int p_mail_id)
	{
		mail_id = p_mail_id;
	}
	
////Begin : Ultimative getter ////
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
			case "mailid": return Integer.toString(mail_id);
			case "attachements": return attachements;
		
			default: return "Mail oder Argument fehlerhaft";	
		}
	}
//// Begin : Ultimative getter ////	
	
////Begin : Ultimative setter ////
	public Object set(String[] args)
	{
		switch (args[3]) 
		{
			case "subject": 
				subject = args[4]; 
			return args[3]+"="+args[4];	
			
			case "content": 
				String temp_content = "";
				for(int i = 4; i<args.length; i++)
				{
					temp_content+=args[i]+" ";
				}
				content = temp_content;
			return args[3]+"="+args[4];
			
			case "senderemail": 
				senderEmail = args[4];
			return args[3]+"="+args[4];
			
			case "recipientemail": 
				recipientEmail = args[4];
			return args[3]+"="+args[4];
			
			case "cc": 
				cc = args[4];
			return args[3]+"="+args[4];
			
			case "bcc": 
				bcc = args[4];
			return args[3]+"="+args[4];
			
			case "date":
				try 
				{
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
					date = formatter.parse(args[4]);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			return args[3]+"="+args[4];
			
			case "mail_id": 
				mail_id = Integer.parseInt(args[4]);
			return args[3]+"="+args[4];
			
			case "attachements_add":
				for (String arg : args) 
				{
					attachements.add(arg);
				}
			return args[3]+"="+"all Added";
			
			case "attachements_replace":
				attachements.clear();
				for (String arg : args) 
				{
					attachements.add(arg);
				}
			return args[3]+"="+"all Added";
		
			default: return "Mail oder Argument fehlerhaft";	
		}
	}
//// Begin : Ultimative setter ////	
	
	
}
