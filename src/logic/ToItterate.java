package logic;

import floatingObjects.Contact;
import floatingObjects.Mail;
import account.Account;

public interface ToItterate
{
	public Account account = null;
//	public Mail mail = null;
	public Contact contact = null;
	public Object get(String str);
	public Object set(String str, String value);
}
