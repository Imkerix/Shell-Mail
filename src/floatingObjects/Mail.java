package floatingObjects;

import java.io.Serializable;
import java.util.ArrayList;				
import java.util.Date;

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

//// Begin : Subject ////
	public String getSubject() 
	{
		return subject;
	}


	public void setSubject(String subject) 
	{
		this.subject = subject;
	}
//// End : Subject ////
//// Begin : Content ////
	public String getContent() 
	{
		return content;
	}


	public void setContent(String content) 
	{
		this.content = content;
	}
//// End : Content ////
//// Begin : SenderEmail ////
	public String getSenderEmail() 
	{
		return senderEmail;
	}


	public void setSenderEmail(String senderEmail) 
	{
		this.senderEmail = senderEmail;
	}
//// End : SenderEmail ////
//// Begin : RecipientEmail ////	
	public String getRecipientEmail() {
		return recipientEmail;
	}


	public void setRecipientEmail(String recipientEmail) 
	{
		this.recipientEmail = recipientEmail;
	}
//// End : RecipientEmail ////
//// Begin : cc ////
	public String getCc() 
	{
		return cc;
	}


	public void setCc(String cc) 
	{
		this.cc = cc;
	}
//// End : cc ////
//// Begin : bcc ////
	public String getBcc() 
	{
		return bcc;
	}


	public void setBcc(String bcc) 
	{
		this.bcc = bcc;
	}
//// End : bcc ////
//// Begin : Attachements ////
	public ArrayList<String> getAttachements() 
	{
		return attachements;
	}


	public void setAttachements(ArrayList<String> attachements) 
	{
		this.attachements = attachements;
	}
//// End : Attachements ////	
	
	public int getMail_id()
	{
		return mail_id;
	}
	
	
	
}
