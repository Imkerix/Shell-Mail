package floatingObjects;

import java.util.ArrayList;				

public class Mail 
{

	private String subject,content,senderEmail,recipientEmail,cc,bcc;
	private ArrayList<String> attachements = null;
	
	
	public Mail(String p_subject,String p_content,String p_senderEmail,String p_recipientEmail,String p_cc,String p_bcc, ArrayList<String> p_attachments)
	{
		subject = p_subject;
		content = p_content;
		senderEmail = p_senderEmail;
		recipientEmail = p_recipientEmail;
		cc = p_cc;
		bcc = p_bcc;
		attachements = p_attachments;
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
	
	
	
	
}
