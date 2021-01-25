package cat.yoink.dream.api.gui.hudeditor;

import cat.yoink.dream.api.component.Component;
import cat.yoink.dream.api.component.ComponentManager;
import cat.yoink.dream.api.module.ModuleManager;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;

import java.awt.*;

public class HUDEditor extends GuiScreen
{
    private boolean dragging;
    private int dragX;
    private int dragY;
    private Component dragComponent;

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        for (Component component : ComponentManager.INSTANCE.getComponents())
        {
            if (dragging && dragComponent.equals(component))
            {
                component.setX(mouseX - dragX);
                component.setY(mouseY - dragY);
            }

            if (!ModuleManager.INSTANCE.getModule(component.getName()).isEnabled()) continue;

            Gui.drawRect(component.getX() - 2, component.getY() - 2, component.getX() + component.getW() + 2, component.getY() + component.getH() + 2, isHover(component.getX(), component.getY(), component.getW(), component.getH(), mouseX, mouseY) ? new Color(0x72000000, true).getRGB() : new Color(0x4F000000, true).getRGB());
            component.render();
        }
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton)
    {
        for (Component component : ComponentManager.INSTANCE.getComponents())
        {
            if (ModuleManager.INSTANCE.getModule(component.getName()).isEnabled() && isHover(component.getX() - 2, component.getY() - 2, component.getW() + 2, component.getH() + 2, mouseX, mouseY))
            {
                dragComponent = component;
                dragging = true;

                dragX = mouseX - component.getX();
                dragY = mouseY - component.getY();
            }
        }
    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state)
    {
        dragging = false;
        dragComponent = null;
    }

    @Override
    public void onGuiClosed()
    {
        dragComponent = null;
        dragging = false;

        ModuleManager.INSTANCE.getModule("HUDEditor").disable();
    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    private boolean isHover(int X, int Y, int W, int H, int mX, int mY)
    {
        return mX >= X && mX <= X + W && mY >= Y && mY <= Y + H;
    }
}
