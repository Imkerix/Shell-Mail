package account;

/**
 * Implements {@link java.io.Serializable} because it will be serialized to a file.
 */
import java.io.Serializable;

@SuppressWarnings("serial")
/**
 * Represents the outbox server of the mail account and stores the used information about it.
 */
public class OutboxServer implements Serializable
{
    /**
     * The url of the outbox server, for Example 'smtp.aol.com'.
     */
	private String outboxServer;
    /**
     * The port of the outbox server, for Example '134'
     */
	private int port;

    /**
     * Constructs a new {@link account.OutboxServer} with the given parameters.
     * @param p_outboxServer The url to the Server, for example 'smtp.aol.com'
     * @param p_port The port used by the outbox server, for example '134'
     */
	public OutboxServer(String p_outboxServer, int p_port)
	{
		outboxServer = p_outboxServer;
		port = p_port;
	}

	////Getter and Setter ////
        /**
         * Returns the url of the outbox server.
         * @return The {@link java.lang.String} representing the url of the outbox server.
         */
        public String getOutboxServer()
		{
			return outboxServer;
		}

        /**
         * Replaces the url of the outbox server with the given parameter.
         * @param outboxServer The new url of the outbox server.
         */
		public void setOutboxServer(String outboxServer) 
		{
			this.outboxServer = outboxServer;
		}

        /**
         * Returns the port of the outbox server.
         * @return An {@link java.lang.Integer} representing the port of the outbox server.
         */
		public int getPort() 
		{
			return port;
		}

        /**
         * Replaces the port of the outbox server with the given parameter.
         * @param port The new port of the outbox server.
         */
		public void setPort(int port) 
		{
			this.port = port;
		}
	////Getter and Setter ////
	
}