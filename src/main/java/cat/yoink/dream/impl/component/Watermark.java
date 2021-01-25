package cat.yoink.dream.impl.component;

import cat.yoink.dream.api.component.Component;

public class Watermark extends Component
{
    public Watermark(String name)
    {
        super(name);

        setW(mc.fontRenderer.getStringWidth("Dream"));
        setH(mc.fontRenderer.FONT_HEIGHT);
    }

    @Override
    public void render()
    {
        mc.fontRenderer.drawStringWithShadow("Dream", getX(), getY(), -1);
    }
}
