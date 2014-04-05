package floatingObjects;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
/**
 * Represents a Contact.
 */
public class Contact implements Serializable
{

    /**
     * The first name of the person represented by this {@link floatingObjects.Contact}.
     */
    private String name;
    /**
     * The last name of the person represented by this {@link floatingObjects.Contact}.
     */
    private String familyname;
    /**
     * The E-Mail address of the person represented by this {@link floatingObjects.Contact}.
     */
    private String email;
    /**
     * The telefone number of the person represented by this {@link floatingObjects.Contact}.
     */
    private String tel;
    /**
     * The mobile number of the person represented by this {@link floatingObjects.Contact}.
     */
    private String mobile;
    /**
     * The street the person represented by this {@link floatingObjects.Contact} lives in.
     */
    private String street;
    /**
     * The name of the country the person represented by this {@link floatingObjects.Contact} lives in.
     */
    private String country;
    /**
     * The housenumber of the persons home.
     */
    private int housenumber;
    /**
     * The birthday of the person.
     */
    private Date birthday = new Date();
    /**
     * A id to identify this {@link floatingObjects.Contact}.
     */
	private int contact_id;

    /**
     * Constructs a new {@link floatingObjects.Contact}.
     * @param p_contact_id The id that will be used to identify this {@link floatingObjects.Contact}.
     */
    public Contact(int p_contact_id)
	{
		contact_id = p_contact_id;
	}

	//// Begin : Ultimative getter ////
    /**
     * Returns a property of this {@link floatingObjects.Contact}.
     * @param p_valueToGet The property to get.
     * @return The requested property, most times a {@link java.lang.String} but not always. It is also possible to get an {@link java.lang.Integer} or a {@link java.util.Date}.
     */
	public Object get(String p_valueToGet)
	{
		switch (p_valueToGet)
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
		case "contact_id":
			return contact_id;
		}
		return null;
	}
	//// End : Ultimative getter ////

	//// Begin : Ultimative setter ////
    /**
     * Sets a new value to a property of this {@link floatingObjects.Contact}.
     * @param p_setting The property to change. {@see help.txt}
     * @param p_value The new Property.
     */
	public void set(String p_setting, String p_value)
	{
		switch (p_setting)
		{
		case "name":
			name = p_value;
			break;
		case "familyname":
			familyname = p_value;
			break;
		case "email":
			email = p_value;
			break;
		case "tel":
			tel = p_value;
			break;
		case "mobile":
			mobile = p_value;
			break;
		case "street":
			street = p_value;
			break;
		case "housenumber":
			housenumber = Integer.parseInt(p_value);
			break;
		case "country":
			country = p_value;
			break;
		case "birthday":
			try
			{
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				birthday = formatter.parse(p_value);
			} catch (ParseException e)
			{
				e.printStackTrace();
			}
			break;
		case "contact_id":
			contact_id = Integer.parseInt(p_value);
			break;
		}
	}
	//// End : Ultimative setter ////

}