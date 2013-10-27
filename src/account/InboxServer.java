package account;

import java.io.Serializable;

@SuppressWarnings("serial")
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

	public void setInboxServer(String inboxServer) 
	{
		this.inboxServer = inboxServer;
	}

	public int getPort() 
	{
		return port;
	}
	
	public void setPort(int port) 
	{
		this.port = port;
	}
}
