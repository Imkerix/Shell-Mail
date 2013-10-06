package account;

import java.io.Serializable;

public class InboxServer implements Serializable
{
	private String inboxServer;
	private int port;
	
	public InboxServer(String p_inboxServer, int p_port)
	{
		inboxServer = p_inboxServer;
		port = p_port;
	}

	public String getinboxServer() 
	{
		return inboxServer;
	}

	public int getPort() 
	{
		return port;
	}
}
