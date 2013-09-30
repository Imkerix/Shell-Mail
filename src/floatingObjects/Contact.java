package floatingObjects;

//import java.util.ArrayList;
import java.util.Date;

public class Contact 
{

	private String name,familyname,email,tel,mobile,street,country;
	private int housenumber;
	private Date birthday;
	
	public Contact(String p_name, String p_familyname, String p_email, String p_tel, String p_mobile, String p_street,int p_housenumber,String p_country,Date p_birthday )
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
	}
//// Begin : name ////
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
//// End : name ////
//// Begin : Familyname ////
	public String getFamilyname() 
	{
		return familyname;
	}

	public void setFamilyname(String familyname) 
	{
		this.familyname = familyname;
	}
//// End : Familyname ////
//// Begin : Email ////
	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}
//// End : Email ////
//// Begin : Tel ////
	public String getTel() 
	{
		return tel;
	}

	public void setTel(String tel) 
	{
		this.tel = tel;
	}
//// End : Tel ////
//// Begin : Mobile ////
	public String getMobile() 
	{
		return mobile;
	}

	public void setMobile(String mobile) 
	{
		this.mobile = mobile;
	}
//// End : Mobile ////
//// Begin : Street ////
	public String getStreet() 
	{
		return street;
	}

	public void setStreet(String street) 
	{
		this.street = street;
	}
//// End : Street ////
//// Begin : Country ////
	public String getCountry() 
	{
		return country;
	}

	public void setCountry(String country) 
	{
		this.country = country;
	}
//// End : Country ////
//// Begin : Housenumber ////
	public int getHousenumber() 
	{
		return housenumber;
	}

	public void setHousenumber(int housenumber) 
	{
		this.housenumber = housenumber;
	}
//// End : Housenumber ////
//// Begin : Birthday ////
	public Date getBirthday() 
	{
		return birthday;
	}

	public void setBirthday(Date birthday) 
	{
		this.birthday = birthday;
	}
//// End : Birthday ////
	
	
//	public Object get(String p_ValueToGet){
//		switch (p_ValueToGet) {
//		case "name": return name;	
//		case "familyname": return familyname;
//		case "email": return email;
//		case "tel": return tel;
//		case "mobile": return mobile;
//		case "street": return street;
//		case "housenumber": return housenumber;
//		case "country": return country;
//		case "birthday": return birthday;
//			
//		default: ArrayList<Object> contactData = new ArrayList<Object>();
//				contactData.add(name);
//				contactData.add(familyname);
//				contactData.add(email);
//				contactData.add(tel);
//				contactData.add(mobile);
//				contactData.add(street);
//				contactData.add(housenumber);
//				contactData.add(country);
//				contactData.add(birthday);
//				
//			return contactData;	
//		}
//	}
	
}