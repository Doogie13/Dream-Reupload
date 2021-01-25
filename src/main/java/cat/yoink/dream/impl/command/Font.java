package cat.yoink.dream.impl.command;

import cat.yoink.dream.Client;
import cat.yoink.dream.api.command.Command;
import cat.yoink.dream.api.util.LoggerUtil;
import cat.yoink.dream.api.util.font.CustomFontRenderer;
import cat.yoink.dream.api.util.font.FontUtil;

/**
 * @author yoink
 * @since 9/21/2020
 */
public class Font extends Command
{
	public Font(String name, String[] alias, String usage)
	{
		super(name, alias, usage);
	}

	@Override
	public void onTrigger(String arguments)
	{
		if (arguments.equals(""))
		{
			printUsage();
			return;
		}

		if (FontUtil.validateFont(arguments))
		{
			try
			{
				Client.customFontRenderer = new CustomFontRenderer(new java.awt.Font(arguments, java.awt.Font.PLAIN, 19), true, false);
				LoggerUtil.sendMessage("New font set to " + arguments);
			}
			catch (Exception e)
			{
				LoggerUtil.sendMessage("Failed to set font");
			}
		}
		else
		{
			LoggerUtil.sendMessage("Invalid font");
		}
	}
}
