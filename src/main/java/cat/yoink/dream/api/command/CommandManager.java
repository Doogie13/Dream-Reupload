package cat.yoink.dream.api.command;

import cat.yoink.dream.api.util.LoggerUtil;
import cat.yoink.dream.impl.command.Font;
import cat.yoink.dream.impl.command.Help;
import cat.yoink.dream.impl.command.Login;
import cat.yoink.dream.impl.command.Prefix;

import java.util.ArrayList;

/**
 * @author yoink
 * @since 9/21/2020
 */
public enum CommandManager
{
	INSTANCE;

	private final ArrayList<Command> commands = new ArrayList<>();
	private String prefix = ".";

	CommandManager()
	{
		commands.add(new Help("Help", new String[]{"h", "help"}, "help"));
		commands.add(new Prefix("Prefix", new String[]{"prefix"}, "prefix <char>"));
		commands.add(new Login("Login", new String[]{"login"}, "login <email> <password>"));
		commands.add(new Font("Font", new String[]{"font"}, "font <font>"));
	}

	public void runCommand(String args)
	{
		boolean found = false;
		String[] split = args.split(" ");
		String startCommand = split[0];
		String arguments = args.substring(startCommand.length()).trim();

		for (Command command : getCommands())
		{
			for (String alias : command.getAlias())
			{
				if (startCommand.equals(getPrefix() + alias))
				{
					command.onTrigger(arguments);
					found = true;
				}
			}
		}

		if (!found)
		{
			LoggerUtil.sendMessage("Unknown command");
		}
	}

	public ArrayList<Command> getCommands()
	{
		return commands;
	}

	public String getPrefix()
	{
		return prefix;
	}

	public void setPrefix(String prefix)
	{
		this.prefix = prefix;
	}
}
