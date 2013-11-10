package floatingObjects;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import logic.ToItterate;

@SuppressWarnings("serial")
public class Contact implements Serializable, ToItterate
{

	private String name,familyname,email,tel,mobile,street,country;
	private int housenumber;
	private Date birthday;
	
	private int contact_id;
	
	public Contact(int p_contact_id, String p_name, String p_familyname, String p_email, String p_tel, String p_mobile, String p_street,int p_housenumber,String p_country,Date p_birthday )
	{
		name = p_name;
		familyname = p_familyname;
		email = p_email;
		tel = p_tel;
		mobile = p_mobile;
		street = p_street;
		housenumber = p_housenumber;
		country = p_country;
		birthday = p_birthday;
		contact_id = p_contact_id;
	}

//// Begin : Ultimative getter ////	
	public Object get(String p_ValueToGet)
	{
		switch (p_ValueToGet) 
		{
			case "name": return name;	
			case "familyname": return familyname;
			case "email": return email;
			case "tel": return tel;
			case "mobile": return mobile;
			case "street": return street;
			case "housenumber": return housenumber;
			case "country": return country;
			case "birthday": return birthday;
			case "contactid": return contact_id;
				
			default: return "Contact oder Argument fehlerhaft";
		}
	}
//// End : Ultimative getter ////
//// Begin : Ultimative setter ////	
	public Object set(String p_ArgumentToChange, String p_ValueToSet)
	{
		switch (p_ArgumentToChange) 
		{
			case "name": 
				name = p_ValueToSet;
			return p_ArgumentToChange+"="+p_ValueToSet;	
			
			case "familyname":
				familyname = p_ValueToSet;
			return p_ArgumentToChange+"="+p_ValueToSet;
			
			case "email": 
				email = p_ValueToSet;
			return p_ArgumentToChange+"="+p_ValueToSet;
			
			case "tel": 
				tel = p_ValueToSet;
			return p_ArgumentToChange+"="+p_ValueToSet;
			
			case "mobile":
				mobile = p_ValueToSet;
			return p_ArgumentToChange+"="+p_ValueToSet;
			
			case "street": 
				street = p_ValueToSet;
			return p_ArgumentToChange+"="+p_ValueToSet;
			
			case "housenumber":
				housenumber = Integer.parseInt(p_ValueToSet);
			return p_ArgumentToChange+"="+p_ValueToSet;
			
			case "country":
				country = p_ValueToSet;
			return p_ArgumentToChange+"="+p_ValueToSet;
			
			case "birthday":
				try 
				{
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
					birthday = formatter.parse(p_ValueToSet);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			return p_ArgumentToChange+"="+p_ValueToSet;
			
			case "contactid":
				contact_id = Integer.parseInt(p_ValueToSet);
			return p_ArgumentToChange+"="+p_ValueToSet;
				
			default: return "Contact oder Argument fehlerhaft";
		}
	}
//// End : Ultimative setter ////
	
}