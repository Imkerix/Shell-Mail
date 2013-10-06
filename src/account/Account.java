package account;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import floatingObjects.Contact;
import floatingObjects.Mail;

public class Account implements Serializable
{

  private String accName;	
  private InboxServer inboxServer;
  private OutboxServer outboxServer;
  
  private HashMap<Mail, String> mails;
  private HashMap<Contact, String> contacts;
  
  public Account(String p_accName, String p_inboxServer, String p_inboxServerPort, String p_outboxServer, String p_outboxServerPort)
  {
	  accName = p_accName;
	  inboxServer = new InboxServer(p_inboxServer, Integer.parseInt(p_inboxServerPort));
	  outboxServer = new OutboxServer(p_outboxServer, Integer.parseInt(p_outboxServerPort));
  }
	
	public String getAccName()
	{
		return accName;
	}
	
	
	//// Begin : Mail ////
		public void mkMail(int p_mail_id)
		{
			mails.put(new Mail(p_mail_id), "drafts");
		}
	
		
		public void rmMail(int p_mail_id) 
		{
			Iterator<Entry<Mail, String>> iterator = mails.entrySet().iterator();
			
		    while (iterator.hasNext()) 
		    {
		        Map.Entry<Mail, String> pair = (Entry<Mail, String>)iterator.next();
		        
		        if(pair.getKey().getMail_id() == p_mail_id)
		        {
		        	mails.remove(pair.getKey());
		        }
		        
		        iterator.remove(); // avoids a ConcurrentModificationException
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
			Iterator<Entry<Contact, String>> iterator = contacts.entrySet().iterator();
			
		    while (iterator.hasNext()) 
		    {
		        Entry<Contact, String> pair = (Entry<Contact, String>)iterator.next();
		        
		        if(pair.getKey().getContact_id() == p_contact_id)
		        {
		        	contacts.remove(pair.getKey());
		        }
		        
		        iterator.remove(); // avoids a ConcurrentModificationException
		    }
		}
	//// End : Contact //// 	
}
