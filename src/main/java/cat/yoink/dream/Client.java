package cat.yoink.dream;

import cat.yoink.dream.api.EventHandler;
import cat.yoink.dream.api.config.Config;
import cat.yoink.dream.api.gui.clickgui.ClickGUI;
import cat.yoink.dream.api.gui.hudeditor.HUDEditor;
import cat.yoink.dream.api.util.font.CustomFontRenderer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import java.awt.*;

/**
 * @author yoink
 * @since 9/20/2020
 */
@Mod(modid = "dream", name = "Dream", version = "b1")
public class Client
{
	public static CustomFontRenderer customFontRenderer;
	public static ClickGUI clickGUI;
	public static HUDEditor hudEditor;

	@Mod.EventHandler
	public void initialize(FMLInitializationEvent event)
	{
		customFontRenderer = new CustomFontRenderer(new Font("Verdana", Font.PLAIN, 19), true, true);
		clickGUI = new ClickGUI();
		hudEditor = new HUDEditor();

		Config.loadConfig();

		Runtime.getRuntime().addShutdownHook(new Config());
		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}
}
