package logic;

import com.martiansoftware.jsap.JSAPException;

/**
 * The class to start the {@link logic.Backbone}.
 */
public class Main 
{
    /**
     * Creates a new {@link logic.Backbone}.
     * @param args The arguments given to the JVM.
     * @throws JSAPException Parsing problems by {@link com.martiansoftware.jsap.JSAPException}.
     */
	public static void main(String[] args) throws JSAPException
	{
		@SuppressWarnings("unused")
        /**
         * The {@link logic.Backbone} object.
         */
        Backbone mylogic = new Backbone(args);
	}
}
