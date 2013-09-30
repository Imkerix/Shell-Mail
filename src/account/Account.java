package account;

import java.io.Serializable;
import java.util.Map;

import floatingObjects.Contact;
import floatingObjects.Mail;

public class Account implements Serializable
{

  private String accName;	
  private InboxServer inboxServer;
  private OutboxServer outboxServer;
  
  private Map<Mail, String> mails;
  private Map<Contact, String> contacts;
  
  public Account(String p_accName)
  {
	  accName = p_accName;
  }
  
	
	public String getAccName()
	{
		return accName;
	}
}
