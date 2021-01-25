package cat.yoink.dream.impl.module.combat;

import cat.yoink.dream.api.module.Category;
import cat.yoink.dream.api.module.Module;
import cat.yoink.dream.api.setting.Setting;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AutoLog extends Module
{
    private final Setting health = new Setting("Health", this, 10, 1, 30);

    public AutoLog(String name, String description, Category category)
    {
        super(name, description, category);

        addSetting(health);
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event)
    {
        if (nullCheck()) return;

        if (mc.player.getHealth() <= health.getIntegerValue())
        {
            disable();
            mc.world.sendQuittingDisconnectingPacket();
            mc.loadWorld(null);
            mc.displayGuiScreen(new GuiMainMenu());
        }
    }
}
