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
import java.util.ArrayList;

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
					case "-mkAccount": mkAccount(args); break;
					case "-help": printHelp(); break;
				}
			}
			else 
			{
				printHelp();
			}
		serialize(saveFile);
	}
	
	private void mkAccount(String[] args) 
	{
		String accName = null;
		
		for (int i = 0; i < args.length; i++) 
		{
			String arg = args[i];
			
			if(arg.equalsIgnoreCase("-acc_name") && args[i+1]!=null)
			{
				accName= args[i+1];
			}
		}
		
		if(accName!=null)
		{
			accounts.add(new Account(accName));
		}
		
	}

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

// Begin : Serialize and Deserialize //
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
		    	fos = new FileOutputStream(p_saveFilePath+File.separator+acc.getAccName());
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
// End : Serialize and Deserialize //	
}
