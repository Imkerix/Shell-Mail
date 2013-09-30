package account;

public class InboxServer 
{
	private String inboxServer;
	private int port;
	
	public InboxServer(String p_outboxServer, int p_port)
	{
		inboxServer = p_outboxServer;
		port = p_port;
	}

	public String getOutboxServer() 
	{
		return inboxServer;
	}

	public int getPort() 
	{
		return port;
	}
}
