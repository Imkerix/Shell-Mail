package account;

/**
 * Implements {@link java.io.Serializable} because it will be serialized to a file.
 */
import java.io.Serializable;

@SuppressWarnings("serial")
/**
 * Represents the inbox server of the mail account and stores the used information about it.
 */
public class InboxServer implements Serializable
{
    /**
     * The url of the inbox server, for Example 'imap.aol.com'.
     */
    private String inboxServer;
    /**
     * The port of the inbox server, for Example '134'
     */
	private int port;

    /**
     * Constructs a new {@link account.InboxServer} with the given parameters.
     * @param p_inboxServer The url to the Server, for example 'imap.aol.com'
     * @param p_port The port used by the inbox server, for example '134'
     */
    public InboxServer(String p_inboxServer, int p_port)
	{
		inboxServer = p_inboxServer;
		port = p_port;
	}
	
	////Getter and Setter ////

        /**
         * Returns the url of the inbox server.
         * @return The {@link java.lang.String} representing the url of the inbox server.
         */
		public String getInboxServer()
		{
			return inboxServer;
		}

        /**
         * Replaces the url of the inbox server with the given parameter.
         * @param inboxServer The new url of the inbox server.
         */
		public void setInboxServer(String inboxServer) 
		{
			this.inboxServer = inboxServer;
		}

        /**
         * Returns the port of the inbox server.
         * @return An {@link java.lang.Integer} representing the port of the inbox server.
         */
		public int getPort() 
		{
			return port;
		}

        /**
         * Replaces the port of the inbox server with the given parameter.
         * @param port The new port of the inbox server.
         */
		public void setPort(int port) 
		{
			this.port = port;
		}
	////Getter and Setter ////
	
}
