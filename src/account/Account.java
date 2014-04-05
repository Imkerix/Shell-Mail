package account;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import floatingObjects.Contact;
import floatingObjects.Mail;

@SuppressWarnings("serial")
/**
 *  Represents a mail account
 */
public class Account implements Serializable
{
    /**
     * A name to identifiy the {@link account.Account} for example 'Eriks Mails' or 'erik.heinisch@aol.de'
     */
	private String name;
    /**
     * The inbox server used by the {@link account.Account}.
     */
	private InboxServer inboxServer;
    /**
     * The outbox server used by the {@link account.Account}
     */
	private OutboxServer outboxServer;

    /**
     * A {@link java.util.ArrayList} used to store {@link floatingObjects.Mail} objects.
     */
	private ArrayList<Mail> mails = new ArrayList<Mail>();
    /**
     * A {@link java.util.ArrayList} used to store {@link floatingObjects.Contact} objects.
     */
    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    /**
     * Constructs a new Account using the given parameter to initialize all needed informations.
     * @param p_accName A name to identifiy the {@link account.Account} for example 'Eriks Mails' or 'erik.heinisch@aol.de'
     * @param p_inboxServer The url used by the {@link account.InboxServer} of the {@link account.Account}.
     * @param p_inboxServerPort The port used by the {@link account.InboxServer}.
     * @param p_outboxServer The url used by the {@link account.OutboxServer} of the {@link account.Account}
     * @param p_outboxServerPort The port used by the {@link account.OutboxServer}.
     */
	public Account(String p_accName, String p_inboxServer, int p_inboxServerPort, String p_outboxServer, int p_outboxServerPort)
	{
		name = p_accName;
		inboxServer = new InboxServer(p_inboxServer, p_inboxServerPort);
		outboxServer = new OutboxServer(p_outboxServer, p_outboxServerPort);
	}

	//// Begin : Mail ////

    /**
     * Creates a new {@link floatingObjects.Mail} if the given mail_id is not yet used.
     * @param p_mail_id The id of the new {@link floatingObjects.Mail}.
     */
    public void mkMail(int p_mail_id)
	{ 
		if(mail_id_used(p_mail_id))
		{
			mails.add(new Mail(mails.size() + 1));
		}
	}

    /**
     * Removes the {@link floatingObjects.Mail} with the given mail_id.
     * @param p_mail_id The id of the {@link floatingObjects.Mail} to remove.
     */
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

    /**
     * Returns the id&#180;s of all {@link floatingObjects.Mail} objects {@see Account.mails} contains.
     */
    public void getMail()
	{
		for (Mail m : mails)
		{
			System.out.println(m.get("mail_id"));
		}
	}

    /**
     * Returns a property of the {@link floatingObjects.Mail} represented by the parameters.
     * @param p_mail_id The id of the {@link floatingObjects.Mail} to get the property from.
     * @param p_ArgumentToGet The name of the property to get.
     */
    public void getMail(int p_mail_id, String p_ArgumentToGet)
	{
		for (Mail mail : mails)
		{
			if ((int) mail.get("mail_id") == p_mail_id)
			{
				if(p_ArgumentToGet.equals("attachments"))
				{
					for(String s : (ArrayList<String>) mail.get(p_ArgumentToGet))
					{
						System.out.println(s);
					}
				}
				else if(p_ArgumentToGet.equals("date"))
				{
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    System.out.println(formatter.format((Date)mail.get("date")));
				}
				else
				{
					System.out.println(mail.get(p_ArgumentToGet));
				}
			}
		}
	}

    /**
     * Modifies a {@link floatingObjects.Mail} and sets a new value for one of its properties.
     * @param p_mail_id The id of the {@link floatingObjects.Mail} to modify.
     * @param p_setting The property to modify.{@see help.txt}
     * @param strings The new value/values to set. (property dependent) {@see help.txt}
     */
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

    /**
     * Creates a new {@link floatingObjects.Contact} if the given id is not yet used.
     * @param p_contact_id The id of the new {@link floatingObjects.Contact}.
     */
    public void mkContact(int p_contact_id)
	{ 
		if(contact_id_used(p_contact_id))
		{
			contacts.add(new Contact(p_contact_id));
		}
	}

    /**
     * Removes the {@link floatingObjects.Contact} with the given id.
     * @param p_contact_id The id of the {@link floatingObjects.Contact} to remove.
     */
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

    /**
     * Returns the id&#180;s of all {@link floatingObjects.Contact} objects {@see Account.contacts} contains.
     */
	public void getContact()
	{
		for (Contact c : contacts)
		{
			System.out.println(c.get("contact_id"));
		}
	}

    /**
     * Returns a property of the {@link floatingObjects.Contact} represented by the parameters.
     * @param p_contact_id The id of the {@link floatingObjects.Contact} to get the property from.
     * @param p_ArgumentToGet The name of the property to get.
     */
    public void getContact(int p_contact_id, String p_ArgumentToGet)
	{
		for (Contact contact : contacts)
		{
			if ((int) contact.get("contact_id") == p_contact_id)
			{
				if(p_ArgumentToGet.equals("birthday"))
				{
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
					Date d = (Date)contact.get("birthday");
					System.out.println(formatter.format((Date)contact.get("birthday")));
				}
				else
				{
					System.out.println(contact.get(p_ArgumentToGet));
				}
			}
		}
	}

    /**
     * Modifies a {@link floatingObjects.Contact} and sets a new value for one of its properties.
     * @param p_contact_id  The id of the {@link floatingObjects.Contact} to modify.
     * @param p_setting The property to modify.{@see help.txt}
     * @param value The new value to set. {@see help.txt}
     */
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

    /**
     * Checks if an id is in use to identify a {@link floatingObjects.Mail} at the moment.
     * @param mail_id The id to check for.
     * @return returns false if the id is used, true if the id is NOT used. It is this way around, because this method is
     *  mostly used to determinate if you can use an id, so true means you are free to use it.
     */
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

    /**
     * Checks if an id is in use to identify a {@link floatingObjects.Contact} at the moment.
     * @param contact_id The id to check for.
     * @return returns false if the id is used, true if the id is NOT used. It is this way around, because this method is
     *  mostly used to determinate if you can use an id, so true means you are free to use it.
     */
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

    /**
     * Returns a property of this {@link account.Account}.
     * @param p_ArgumentToGet The property to get.
     * @return The requested property, most times a {@link java.lang.String} but not always. It is also possible to get an {@link java.lang.Integer}.
     */
    public Object get(String p_ArgumentToGet)
	{
		switch (p_ArgumentToGet)
		{
		case "name":
			return name;
		case "inboxserver":
			return inboxServer.getInboxServer();
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

    /**
     * Sets a new value to a property of this {@link account.Account}.
     * @param p_ArgumentToChange The property to change. {@see help.txt}
     * @param p_ValueToSet The new Property.
     */
    public void set(String p_ArgumentToChange, String p_ValueToSet)
	{
		switch (p_ArgumentToChange)
		{
		case "name":
			name = p_ValueToSet;
			break;
		case "inboxserver":
			inboxServer.setInboxServer(p_ValueToSet);
			break;
		case "inboxserverport":
			inboxServer.setPort(Integer.parseInt(p_ValueToSet));
			break;
		case "outboxserver":
			outboxServer.setOutboxServer(p_ValueToSet);
			break;
		case "outboxserverport":
			outboxServer.setPort(Integer.parseInt(p_ValueToSet));
			break;
		}
	}
	//// End : Ultimative setter ////   
}
