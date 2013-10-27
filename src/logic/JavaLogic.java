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
import java.util.Locale;
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
			if(args.length>0 && (accounts.size()>0 || args[0].equals("-mkAccount") || args[0].equals("-help")))
			{
					switch (args[0])
					{
					case "-mkAccount":	 mkAccount(args);	break;
					case "-rmAccount":	 rmAccount(args);	break;
					case "-modAccount":	 modAccount(args);	break;
					case "-getAccount":	 getAccount(args);	break;
					
					case "-mkMail":		 mkMail(args);		break;
					case "-rmMail":		 rmMail(args);		break;
					case "-modMail":	 modMail(args);	break;
					case "-getMail":	 getMail(args);	break;
					
					case "-mkContact":	 mkContact(args);	break;
					case "-rmContact":	 rmContact(args); 	break;
					case "-modContact":	 modContact(args);	break;
					case "-getContact":	 getContact(args);	break;
					
					case "-help":		 printHelp(); 		break;
					}
			}
			else if (args.length>0)
			{
				noAccounts();
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
			//Account := accountName inboxServer inboxServerPort outboxServer outboxServerPort
			accounts.add(new Account(args[1],args[2],args[3],args[4],args[5]));
		}
		private void rmAccount(String[] args) 
		{
			//Account := accountName
			int i = 0;
			while (i < accounts.size()) 
			{
				if(accounts.get(i).get("accountname").equals(args[1]))
				{
					i++;
					File oldAccount = new File (saveFile+File.separator+accounts.get(i-1).get("accountname"));
					if(oldAccount.exists())
					{
						oldAccount.delete();
					}
					accounts.remove(i-1);
				}
				else
				{
					i++;
				}
			}
		}
		private void getAccount(String[] args)
		{
			//Account := accountName attributToGet
			for (Account acc : accounts ) 
			{
				if(args.length == 1)
				{
					System.out.println(acc.get("accountname"));
				}
				else if(acc.get("accountname").equals(args[1]))
				{
						System.out.println(acc.get(args[2]));
				}
			}
		}
		private void modAccount(String[] args)
		{
			//Account := accountName attributToSet Value
			for (Account acc : accounts ) 
			{
				if(acc.get("accountname").equals(args[1]))
				{
					acc.set(args[2], args[3]);
				}
			}
		}
	//// End : Account
	////Begin : Mail
		private void mkMail(String[] args) 
		{
			//Mail := accountName mail_id attributToSet Value
			for (Account acc : accounts) 
			{
				if(acc.get("accountname").equals(args[1]))
				{
					acc.mkMail(Integer.parseInt(args[2]));
				}
			}
		}
		private void rmMail(String[] args) 
		{
			//Mail := accountname mail_id
			for (Account acc : accounts) 
			{
				if(acc.get("accountname").equals(args[1]))
				{
					acc.rmMail(Integer.parseInt(args[2]));
				}
			}
		}
		private void getMail(String[] args) 
		{
			//Mail := accountname mail_id attributToGet
			for (Account acc : accounts) 
			{
				if(acc.get("accountname").equals(args[1]))
				{
					if(args.length == 2)
					{
						acc.getMail();
					}
					else
					{
						acc.getMail(Integer.parseInt(args[2]), args[3]);
					}
				}
			}
		}
		private void modMail(String[] args) 
		{
			//Mail := accountname mail_id
			for (Account acc : accounts) 
			{
				if(acc.get("accountname").equals(args[1]))
				{
					acc.modMail(args);
				}
			}
		}
	//// End : Mail
	////Begin : Contact
		private void mkContact(String[] args)  
		{
			//Contact := accountName contact_id name familyname email tel mobile street housenumber country birthday_like:"dd-MM-yyyy"
			for (Account acc : accounts) 
			{
				if(acc.get("accountname").equals(args[1]))
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
				if(acc.get("accountname").equals(args[1]))
				{
					acc.rmContact(Integer.parseInt(args[2]));
				}
			}
		}
		private void getContact(String[] args)
		{
			//Contact := accountname contact_id attributToGet
			for (Account acc : accounts) 
			{
				
				if(acc.get("accountname").equals(args[1]))
				{
					if(args.length == 2)
					{
						acc.getContact();
					}
					else
					{
						acc.getContact(Integer.parseInt(args[2]), args[3]);
					}
				}
			}
		}
		private void modContact(String[] args)
		{
			//Contact := accountname contact_id
			for (Account acc : accounts) 
			{
				if(acc.get("accountname").equals(args[1]))
				{
					acc.modContact(args);
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
	public void serialize(String p_saveFilePath)
	{
		  OutputStream fos = null;

		  try
		  {
			// Begin : saveDirectory //
				File saveDirectory = new File(p_saveFilePath); // root directory
				deleteFolder(saveDirectory);
		    	if(!saveDirectory.exists())
		    	{
		    		saveDirectory.mkdir();
		    	}   
		    // End : saveDirectory //
		    for(Account acc : accounts)
		    {
		    	fos = new FileOutputStream(p_saveFilePath+File.separator+acc.get("accountname"), false);
		    	ObjectOutputStream o = new ObjectOutputStream( fos );
		    	o.writeObject(acc);
		    	fos.close();
		    }
		    
		  }
		  catch ( IOException e ) { System.err.println( e ); }
		
	}
	// Begin : Help method to clean up folder in serialize
	public void deleteFolder(File p_saveFolder) 
	{
		File[] accountFiles = p_saveFolder.listFiles();
		if(accountFiles!=null) //test for empty dirs
		{ 
			for(File accfile: accountFiles) 
			{
				if(accfile.isDirectory()) 
				{
					deleteFolder(accfile);
				} else 
				{
					accfile.delete();
				}
			}
		}
		
	}
	// End : Help method to clean up folder in serialize
	public void deserialize(String p_readFilePath)
	{
		// Begin : Preparation //
			accounts.clear(); // In case this method is called more than one time the entries won't be doubled.
		// End : Preparation //
		try
    	{
			File saveFolder = new File(p_readFilePath);
			
			if (saveFolder.list().length != 0) 
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
	
	private void noAccounts() 
	{
		System.err.println("Es gibt keine Accounts im dafür vorgesehenen ordner");
		System.err.println("Also hier --> "+new File(saveFile).getAbsolutePath());
	}
}