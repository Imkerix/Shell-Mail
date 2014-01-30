package account;

import java.io.Serializable;
import java.util.ArrayList;
import floatingObjects.Contact;
import floatingObjects.Mail;

@SuppressWarnings("serial")
public class Account implements Serializable
{

	private String accName;
	private InboxServer inboxServer;
	private OutboxServer outboxServer;

	private ArrayList<Mail> mails = new ArrayList<Mail>();
	private ArrayList<Contact> contacts = new ArrayList<Contact>();

	public Account(String p_accName, String p_inboxServer, int p_inboxServerPort, String p_outboxServer, int p_outboxServerPort)
	{
		accName = p_accName;
		inboxServer = new InboxServer(p_inboxServer, p_inboxServerPort);
		outboxServer = new OutboxServer(p_outboxServer, p_outboxServerPort);
	}

	//// Begin : Mail ////
	public void mkMail(int p_mail_id)
	{ 
		if(mail_id_used(p_mail_id))
		{
			mails.add(new Mail(mails.size() + 1));
		}
	}

	public void rmMail(int p_mail_id)
	{
		int i = 0;
		while (i < mails.size())
		{
			if ((int) mails.get(i).get("mail_id") == p_mail_id)
			{
				mails.remove(i);
			} else
			{
				i++;
			}
		}
	}

	public void getMail(int p_mail_id, String p_ArgumentToGet)
	{
		for (Mail mail : mails)
		{
			if ((int) mail.get("mail_id") == p_mail_id)
			{
				System.out.println(mail.get(p_ArgumentToGet));
			}
		}
	}

	public void getMail()
	{
		for (Mail m : mails)
		{
			System.out.println(m.get("mail_id"));
		}
	}

	public void modMail(int p_mail_id, String p_setting, String[] strings)
	{
		for (Mail mail : mails)
		{
			if ((int) mail.get("mail_id") == p_mail_id)
			{
				mail.set(p_setting, strings);
			}
		}
	}
	//// End : Mail //// 
	//// Begin : Contact ////	
	public void mkContact(int p_contact_id)
	{ 
		if(contact_id_used(p_contact_id))
		{
			contacts.add(new Contact(p_contact_id));
		}
	}

	public void rmContact(int p_contact_id)
	{
		int i = 0;
		while (i < contacts.size())
		{
			if ((int) contacts.get(i).get("contact_id") == p_contact_id)
			{
				contacts.remove(i);
			} else
			{
				i++;
			}
		}
	}

	public void getContact()
	{
		for (Contact c : contacts)
		{
			System.out.println(c.get("contact_id"));
		}
	}

	public void getContact(int p_contact_id, String p_ArgumentToGet)
	{
		for (Contact contact : contacts)
		{
			if ((int) contact.get("contact_id") == p_contact_id)
			{
				System.out.println(contact.get(p_ArgumentToGet));
			}
		}
	}

	public void modContact(int p_contact_id, String p_setting, String value)
	{
		for (Contact contact : contacts)
		{
			if ((int) contact.get("contact_id") == p_contact_id)
			{
				contact.set(p_setting, value);
			}
		}
	}
	//// End : Contact //// 	

	//// Begin : Helpers
	public boolean mail_id_used(int mail_id)
	{
		for(Mail mail : mails)
		{
			if((int)mail.get("mail_id") == mail_id)
			{
				return false;
				
			}
		}
		return true;
	}
	
	public boolean contact_id_used(int contact_id)
	{
		for(Contact contact : contacts)
		{
			if((int)contact.get("contact_id") == contact_id)
			{
				return false;
				
			}
		}
		return true;
	}
	//// End : Helpers
	
	
	//// Begin : Ultimative getter ////
	public Object get(String p_ArgumentToGet)
	{
		switch (p_ArgumentToGet)
		{
		case "name":
			return accName;
		case "inboxserver":
			return inboxServer.getinboxServer();
		case "inboxserverport":
			return inboxServer.getPort();
		case "outboxserver":
			return outboxServer.getOutboxServer();
		case "outboxserverport":
			return outboxServer.getPort();

		default:
			return "Account oder Argument fehlerhaft";
		}
	}
	//// End : Ultimative getter ////        

	//// Begin : Ultimative setter ////
	public void set(String p_ArgumentToChange, String p_ValueToSet)
	{
		switch (p_ArgumentToChange)
		{
		case "name":
			accName = p_ValueToSet;
			break;
		case "inboxserver":
			inboxServer.setInboxServer(p_ValueToSet);
			break;
		case "inboxserverport":
			inboxServer.setPort(Integer.parseInt(p_ValueToSet));
			break;
		case "outboxServer":
			outboxServer.setOutboxServer(p_ValueToSet);
			break;
		case "outboxServerport":
			outboxServer.setPort(Integer.parseInt(p_ValueToSet));
			break;
		}
	}
	//// End : Ultimative setter ////   
}
