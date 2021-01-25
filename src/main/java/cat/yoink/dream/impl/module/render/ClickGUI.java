package cat.yoink.dream.impl.module.render;

import cat.yoink.dream.Client;
import cat.yoink.dream.api.module.Category;
import cat.yoink.dream.api.module.Module;
import cat.yoink.dream.api.setting.Setting;
import org.lwjgl.input.Keyboard;

import java.util.Arrays;

/**
 * @author yoink
 * @since 9/20/2020
 */
public class ClickGUI extends Module
{
	public ClickGUI(String name, String description, Category category)
	{
		super(name, description, category);

		setBind(Keyboard.KEY_RSHIFT);

		addSetting(new Setting("Color", this, Arrays.asList(
				"Red",
				"Green",
				"Blue"
		)));
	}

	@Override
	public void onEnable()
	{
		mc.displayGuiScreen(Client.clickGUI);
	}
}
