package cat.yoink.dream.api.command;

import cat.yoink.dream.api.util.LoggerUtil;

/**
 * @author yoink
 * @since 9/21/2020
 */
public class Command
{
	private String name;
	private String[] alias;
	private String usage;

	public Command(String name, String[] alias, String usage)
	{
		setName(name);
		setAlias(alias);
		setUsage(usage);
	}

	public void onTrigger(String arguments) {}

	public void printUsage()
	{
		LoggerUtil.sendMessage("Usage: " + CommandManager.INSTANCE.getPrefix() + usage);
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String[] getAlias()
	{
		return alias;
	}

	public void setAlias(String[] alias)
	{
		this.alias = alias;
	}

	public String getUsage()
	{
		return usage;
	}

	public void setUsage(String usage)
	{
		this.usage = usage;
	}
}
