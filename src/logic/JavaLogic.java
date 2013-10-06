/**
 * A Package containing the main flow of the program
 */
package logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import account.Account;

/**
 * @author erik heinisch 
 * 
 */
public class JavaLogic 
{
	
	private  String saveFile = "SaveFile";
	private  ArrayList<Account> accounts = new ArrayList<Account>();

	public JavaLogic(String[] args)
	{
		deserialize(saveFile);
			if(args.length>0)
			{
				switch (args[0])
				{
					case "-mkAccount":	 mkAccount(args);	break;
					case "-rmAccount":	 rmAccount(args);	break;
					case "-mkMail":		 mkMail(args);		break;
					case "-rmMail":		 rmMail(args);		break;
					case "-mkContact":	 mkContact(args);	break;
					case "-rmContact":	 rmContact(args); 	break;
					case "-help":		 printHelp(); 		break;
				}
			}
			else 
			{
				printHelp();
			}
		serialize(saveFile);
	}

	//// Begin : Account
		private void mkAccount(String[] args) 
		{
			//Account := accName inboxServer inboxServerPort outboxServer outboxServerPort
			accounts.add(new Account(args[1],args[2],args[3],args[4],args[5]));
		}
		private void rmAccount(String[] args) 
		{
			//Account := accName
			for (Account acc : accounts ) 
			{
				if(acc.getAccName().equals(args[1]))
				{
					accounts.remove(acc);
				}
			}
		}
	//// End : Account
	////Begin : Mail
		private void mkMail(String[] args) 
		{
			//Mail := accountName mail_id
			for (Account acc : accounts) 
			{
				if(acc.getAccName().equals(args[1]))
				{
					acc.mkMail(Integer.parseInt(args[2]));
				}
			}
		}
		//!!!! need modify method
		private void rmMail(String[] args) 
		{
			//Mail := accountname mail_id
			for (Account acc : accounts) 
			{
				if(acc.getAccName().equals(args[1]))
				{
					acc.rmMail(Integer.parseInt(args[2]));
				}
			}
		}
	//// End : Mail
	////Begin : Contact
		private void mkContact(String[] args)  
		{
			//Contact := accountName contact_id name familyname, email, tel, mobile, street, housenumber, country, birthday_like:dd-MM-yyyy
			for (Account acc : accounts) 
			{
				if(acc.getAccName().equals(args[1]))
				{
					try 
					{
						String dateString = args[11];
						Date date = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(dateString);
						acc.mkContact(Integer.parseInt(args[2]), args[3], args[4], args[5], args[6], args[7],args[8], Integer.parseInt(args[9]), args[10], date);
					}
					catch (ParseException e) 
					{
						e.printStackTrace();
					}
				}
			}
		}
		private void rmContact(String[] args) 
		{
			//Contact := accountname contact_id
			for (Account acc : accounts) 
			{
				if(acc.getAccName().equals(args[1]))
				{
					acc.rmContact(Integer.parseInt(args[2]));
				}
			}
		}
	//// End : Contact
	
	

	private void printHelp() 
	{
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader("help.txt"));
	    
			
			for(String line = br.readLine(); line!=null; line=br.readLine())
			{
				System.out.println(line);
			}
	    	br.close();
		} 
		catch (IOException e) {e.printStackTrace();}
	}

//// Begin : Serialize and Deserialize ////
	public  void serialize(String p_saveFilePath)
	{
		  OutputStream fos = null;

		  try
		  {
			// Begin : saveDirectory //
				File saveDirectory = new File(p_saveFilePath); // root directory
		    	if(!saveDirectory.exists())
		    	{
		    		saveDirectory.mkdir();
		    	}   
		    // End : saveDirectory //
		    for(Account acc : accounts)
		    {
		    	fos = new FileOutputStream(p_saveFilePath+File.separator+acc.getAccName(), false);
		    	ObjectOutputStream o = new ObjectOutputStream( fos );
		    	o.writeObject(acc);
		    	fos.close();
		    }
		    
		  }
		  catch ( IOException e ) { System.err.println( e ); }
		
	}
	
	public void deserialize(String p_readFilePath)
	{
		// Begin : Preparation //
			accounts.clear(); // In case this method is called more than one time the entries won't be doubled.
		// End : Preparation //
		try
    	{
			File saveFolder = new File(p_readFilePath);
			
			if (saveFolder.listFiles()!=null) 
			{
				for (File fileEntry : saveFolder.listFiles()) 
				{
					if (!fileEntry.isDirectory()) 
					{
						InputStream fis = new FileInputStream(
								fileEntry.getAbsoluteFile());
						ObjectInputStream o = new ObjectInputStream(fis);

						accounts.add((Account) o.readObject());
						fis.close();
					}
				}
			}
    	}
    	catch ( IOException|ClassNotFoundException e ) { System.err.println( e ); }
	}
//// End : Serialize and Deserialize ////
}
