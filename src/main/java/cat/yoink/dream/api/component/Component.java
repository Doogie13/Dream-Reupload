package cat.yoink.dream.api.component;

import net.minecraft.client.Minecraft;

public class Component
{
    protected final Minecraft mc = Minecraft.getMinecraft();
    private final String name;
    private int x;
    private int y;
    private int w;
    private int h;
    private boolean showing;

    public Component(String name)
    {
        this.name = name;
    }

    public void render() { }

    public String getName()
    {
        return name;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getW()
    {
        return w;
    }

    public void setW(int w)
    {
        this.w = w;
    }

    public int getH()
    {
        return h;
    }

    public void setH(int h)
    {
        this.h = h;
    }

    public boolean isShowing()
    {
        return showing;
    }

    public void setShowing(boolean showing)
    {
        this.showing = showing;
    }
}
