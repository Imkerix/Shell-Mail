package floatingObjects;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class Contact implements Serializable
{

	private String name, familyname, email, tel, mobile, street, country;
	private int housenumber;
	private Date birthday;

	private int contact_id;

	public Contact(int p_contact_id)
	{
		contact_id = p_contact_id;
	}

	//// Begin : Ultimative getter ////        
	public Object get(String p_ValueToGet)
	{
		switch (p_ValueToGet)
		{
		case "name":
			return name;
		case "familyname":
			return familyname;
		case "email":
			return email;
		case "tel":
			return tel;
		case "mobile":
			return mobile;
		case "street":
			return street;
		case "housenumber":
			return housenumber;
		case "country":
			return country;
		case "birthday":
			return birthday;
		case "contactid":
			return contact_id;

		default:
			return "Contact oder Argument fehlerhaft";
		}
	}
	//// End : Ultimative getter ////

	//// Begin : Ultimative setter ////        
	public void set(String p_setting, String p_Value)
	{
		switch (p_setting)
		{
		case "name":
			name = p_Value;
			break;
		case "familyname":
			familyname = p_Value;
			break;
		case "email":
			email = p_Value;
			break;
		case "tel":
			tel = p_Value;
			break;
		case "mobile":
			mobile = p_Value;
			break;
		case "street":
			street = p_Value;
			break;
		case "housenumber":
			housenumber = Integer.parseInt(p_Value);
			break;
		case "country":
			country = p_Value;
			break;
		case "birthday":
			try
			{
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				birthday = formatter.parse(p_Value);
			} catch (ParseException e)
			{
				e.printStackTrace();
			}
		case "contact_id":
			contact_id = Integer.parseInt(p_Value);
			break;
		}
	}
	//// End : Ultimative setter ////

}