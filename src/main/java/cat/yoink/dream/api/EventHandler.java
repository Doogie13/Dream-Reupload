package cat.yoink.dream.api;

import cat.yoink.dream.Client;
import cat.yoink.dream.api.command.CommandManager;
import cat.yoink.dream.api.component.Component;
import cat.yoink.dream.api.component.ComponentManager;
import cat.yoink.dream.api.module.Module;
import cat.yoink.dream.api.module.ModuleManager;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

/**
 * @author yoink
 * @since 9/20/2020
 */
public class EventHandler
{
	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event)
	{
		if (!Keyboard.getEventKeyState() || Keyboard.getEventKey() == Keyboard.KEY_NONE) return;

		for (Module module : ModuleManager.INSTANCE.getModules())
		{
			if (module.getBind() == Keyboard.getEventKey())
			{
				module.toggle();
			}
		}
	}

	@SubscribeEvent
	public void onChatSend(ClientChatEvent event)
	{
		if (Minecraft.getMinecraft().player == null || Minecraft.getMinecraft().world == null) return;

		if (event.getMessage().startsWith(CommandManager.INSTANCE.getPrefix()))
		{
			event.setCanceled(true);
			Minecraft.getMinecraft().ingameGUI.getChatGUI().addToSentMessages(event.getMessage());
			CommandManager.INSTANCE.runCommand(event.getMessage());
		}
	}

	@SubscribeEvent
	public void onRenderGameOverlay(RenderGameOverlayEvent event)
	{
		if (Minecraft.getMinecraft().player == null || Minecraft.getMinecraft().world == null || !event.getType().equals(RenderGameOverlayEvent.ElementType.TEXT)) return;

		ComponentManager.INSTANCE.getComponents().stream().filter(Component::isShowing).forEach(Component::render);
	}
}
