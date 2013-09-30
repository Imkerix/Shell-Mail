package account;

public class OutboxServer 
{
	private String outboxServer;
	private int port;
	
	public OutboxServer(String p_outboxServer, int p_port)
	{
		outboxServer = p_outboxServer;
		port = p_port;
	}

	public String getOutboxServer() 
	{
		return outboxServer;
	}

	public int getPort() 
	{
		return port;
	}
	
}