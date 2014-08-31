package me.TMAC_Kratos.InfiniteChests;

import java.util.logging.Logger;

public class StackableLogger
{
	protected Logger logger;
	protected String prefix;
	public static final String MINECRAFT_LOGGER = "Minecraft";

	public StackableLogger(String prefix)
	{
		this.logger = Logger.getLogger("Minecraft");
		this.prefix = prefix;
	}

	public void config(String msg)
	{
		this.logger.config(this.prefix + ": " + msg);
	}

	public void fine(String msg)
	{
		this.logger.fine(this.prefix + ": " + msg);
	}

	public void finer(String msg)
	{
		this.logger.finer(this.prefix + ": " + msg);
	}

	public void finest(String msg)
	{
		this.logger.finest(this.prefix + ": " + msg);
	}

	public void info(String msg)
	{
		this.logger.info(this.prefix + ": " + msg);
	}

	public void severe(String msg)
	{
		this.logger.severe(this.prefix + ": " + msg);
	}

	public void warning(String msg)
	{
		this.logger.warning(this.prefix + ": " + msg);
	}
}