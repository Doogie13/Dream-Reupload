package cat.yoink.dream.impl.module.render;

import cat.yoink.dream.Client;
import cat.yoink.dream.api.module.Category;
import cat.yoink.dream.api.module.Module;

public class HUDEditor extends Module
{
    public HUDEditor(String name, Category category)
    {
        super(name, category);
    }

    @Override
    public void onEnable()
    {
        mc.displayGuiScreen(Client.hudEditor);
    }
}
