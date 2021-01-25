package cat.yoink.dream.api.component;

import cat.yoink.dream.impl.component.Watermark;

import java.util.ArrayList;

public enum ComponentManager
{
    INSTANCE;

    private final ArrayList<Component> components = new ArrayList<>();

    ComponentManager()
    {
        components.add(new Watermark("Watermark"));
    }

    public ArrayList<Component> getComponents()
    {
        return components;
    }
}
