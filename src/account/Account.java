package account;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import logic.MethodBearer;
import logic.ToItterate;
import floatingObjects.Contact;
import floatingObjects.Mail;

@SuppressWarnings("serial")
public class Account implements Serializable, ToItterate
{

  private String accName;	
  private InboxServer inboxServer;
  private OutboxServer outboxServer;
  private MethodBearer methodBearer = new MethodBearer();
  
  private HashMap<Mail, String> mails = new HashMap<Mail, String>();
  private HashMap<Contact, String> contacts = new HashMap<Contact, String>();
  
  public Account(String p_accName, String p_inboxServer, String p_inboxServerPort, String p_outboxServer, String p_outboxServerPort)
  {
	  accName = p_accName;
	  inboxServer = new InboxServer(p_inboxServer, Integer.parseInt(p_inboxServerPort));
	  outboxServer = new OutboxServer(p_outboxServer, Integer.parseInt(p_outboxServerPort));
  }
	
	//// Begin : Mail ////
		public void mkMail(int p_mail_id)
		{
			mails.put(new Mail(p_mail_id), "drafts");
		}
		public void rmMail(int p_mail_id) 
		{
			int i = 0;
			while (i < mails.keySet().size()) 
			{
				if(Integer.parseInt((String) ((Mail) mails.keySet().toArray()[i]).get("mailid")) == p_mail_id)
		        {
					// no i++; here because a Hashmap shrinks if you delete stuff so i++; would make the code jump over one entry.
		        	mails.remove(mails.keySet().toArray()[i]);
		        }
				else
				{
					// nothing is removed so i++;
					i++;
				}
			}
		}
		public void getMail(int p_mail_id, String p_ArgumentToGet)
		{
			Iterator<Entry<Mail, String>> iterator = mails.entrySet().iterator();
			
		    while (iterator.hasNext()) 
		    {
		        Map.Entry<Mail, String> pair = (Entry<Mail, String>)iterator.next();
		        
		        if(Integer.parseInt((String) pair.getKey().get("mailid")) == p_mail_id)
		        {
		        	System.out.println(pair.getKey().get(p_ArgumentToGet));
		        }
		    }
		}
		public void getMail()
		{
			Object obj = methodBearer.returnStuff(mails);
			if(obj!=null)
			{
				 System.out.println(((Entry<Mail, String>) obj).getKey().get("mailid"));
			}
			
//			Iterator<Entry<Mail, String>> iterator = mails.entrySet().iterator();
//			
//		    while (iterator.hasNext()) 
//		    {
//		        Map.Entry<Mail, String> pair = (Entry<Mail, String>)iterator.next();
//		        
//		        System.out.println(pair.getKey().get("mailid"));
//		    }
		}
		public void modMail(String[] args)
		{
			Iterator<Entry<Mail, String>> iterator = mails.entrySet().iterator();
			
		    while (iterator.hasNext()) 
		    {
		        Map.Entry<Mail, String> pair = (Entry<Mail, String>)iterator.next();
		        
		        if(Integer.parseInt((String) pair.getKey().get("mailid")) == Integer.parseInt(args[2]))
		        {
		        	pair.getKey().set(args);
		        }
		    }
		}
	//// End : Mail //// 
	//// Begin : Contact ////	
		public void mkContact(int p_contact_id, String p_name, String p_familyname, String p_email, String p_tel, String p_mobile, String p_street,int p_housenumber,String p_country,Date p_birthday)
		{
			contacts.put(new Contact(p_contact_id, p_name, p_familyname, p_email, p_tel, p_mobile, p_street, p_housenumber, p_country, p_birthday), "Personal adress book");
		}
		public void rmContact(int p_contact_id)
		{
			
			int i = 0;
			while (i < contacts.keySet().size()) 
			{
				if((int)(((Contact) contacts.keySet().toArray()[i]).get("contactid")) == p_contact_id)
		        {
					// no i++; here because a Hashmap shrinks if you delete stuff so i++; would make the code jump over one entry.
					contacts.remove(contacts.keySet().toArray()[i]);
		        }
				else
				{
					// nothing is removed so i++;
					i++;
				}
			}
		}
		public void getContact(int p_Contact_id, String p_ArgumentToGet) 
		{
			Iterator<Entry<Contact, String>> iterator = contacts.entrySet().iterator();
			
		    while (iterator.hasNext()) 
		    {
		        Map.Entry<Contact, String> pair = (Entry<Contact, String>)iterator.next();
		        
		        if((int)(pair.getKey().get("contactid")) == p_Contact_id)
		        {
		        	System.out.println(pair.getKey().get(p_ArgumentToGet));
		        }
		    }
		}
		public void getContact() 
		{
			Iterator<Entry<Contact, String>> iterator = contacts.entrySet().iterator();
			
		    while (iterator.hasNext()) 
		    {
		        Map.Entry<Contact, String> pair = (Entry<Contact, String>)iterator.next();
		        
		        	System.out.println(pair.getKey().get("contactid"));
		    }
		}
		public void modContact(String[] args)
		{
			Iterator<Entry<Contact, String>> iterator = contacts.entrySet().iterator();
			
		    while (iterator.hasNext()) 
		    {
		        Map.Entry<Contact, String> pair = (Entry<Contact, String>)iterator.next();
		        
		        if((int)(pair.getKey().get("contactid")) == Integer.parseInt(args[2]))
		        {
		        	pair.getKey().set(args[3],args[4]);
		        }
		    }
		}
	//// End : Contact //// 	

	//// Begin : Ultimative getter ////
		public Object get(String p_ArgumentToGet)
		{
			switch (p_ArgumentToGet) 
			{
				case "accountname": return accName;	
				case "inboxserver": return inboxServer.getinboxServer();
				case "inboxserverport": return inboxServer.getPort();
				case "outboxserver": return outboxServer.getOutboxServer();
				case "outboxserverport": return outboxServer.getPort();
			
				default: return "Account oder Argument fehlerhaft";	
			}
		}
	//// Begin : Ultimative getter ////	
	//// Begin : Ultimative setter ////
		public Object set(String p_ArgumentToChange, String p_ValueToSet)
		{
			switch (p_ArgumentToChange) 
			{
				case "accountname": 
					accName = p_ValueToSet;
				return p_ArgumentToChange+"="+p_ValueToSet;	
				
				case "inboxserver": 
					inboxServer.setInboxServer(p_ValueToSet);
				return p_ArgumentToChange+"="+p_ValueToSet;
				
				case "inboxserverport": 
					inboxServer.setPort(Integer.parseInt(p_ValueToSet));
				return p_ArgumentToChange+"="+p_ValueToSet;
				
				case "outboxServer":
					outboxServer.setOutboxServer(p_ValueToSet);
				return p_ArgumentToChange+"="+p_ValueToSet;
				
				case "outboxServerport":
					outboxServer.setPort(Integer.parseInt(p_ValueToSet));
				return p_ArgumentToChange+"="+p_ValueToSet;
			
				default: return "Account oder Argument fehlerhaft";	
			}
		}
	//// Begin : Ultimative setter ////		
}
