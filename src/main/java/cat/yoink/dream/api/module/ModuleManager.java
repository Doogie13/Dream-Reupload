package cat.yoink.dream.api.module;

import cat.yoink.dream.impl.module.combat.AutoLog;
import cat.yoink.dream.impl.module.combat.AutoTrap;
import cat.yoink.dream.impl.module.combat.Criticals;
import cat.yoink.dream.impl.module.combat.Surround;
import cat.yoink.dream.impl.module.component.Watermark;
import cat.yoink.dream.impl.module.exploit.Blink;
import cat.yoink.dream.impl.module.exploit.PacketMine;
import cat.yoink.dream.impl.module.misc.ChatSuffix;
import cat.yoink.dream.impl.module.misc.Timer;
import cat.yoink.dream.impl.module.movement.LongJump;
import cat.yoink.dream.impl.module.movement.ReverseStep;
import cat.yoink.dream.impl.module.movement.Speed;
import cat.yoink.dream.impl.module.movement.Sprint;
import cat.yoink.dream.impl.module.render.ClickGUI;
import cat.yoink.dream.impl.module.render.CustomFont;
import cat.yoink.dream.impl.module.render.HUDEditor;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author yoink
 * @since 9/20/2020
 */
public enum ModuleManager
{
	INSTANCE;

	private final ArrayList<Module> modules = new ArrayList<>();

	ModuleManager()
	{
		modules.add(new ClickGUI("ClickGUI", "Toggle modules by clicking on them", Category.RENDER));
		modules.add(new CustomFont("CustomFont", "Use a custom font render instead of Minecraft's default", Category.RENDER));
		modules.add(new PacketMine("PacketMine", "Mine blocks with packets", Category.EXPLOIT));
		modules.add(new Timer("Timer", "Speeds up your game", Category.MISC));
		modules.add(new Criticals("Criticals", "Deal critical hits without jumping", Category.COMBAT));
		modules.add(new LongJump("LongJump", "Jumps far", Category.MOVEMENT));
		modules.add(new Sprint("Sprint", "Sprints, Obviously", Category.MOVEMENT));
		modules.add(new ChatSuffix("ChatSuffix", "Adds a suffix to your chat messages", Category.MISC));
		modules.add(new Speed("Speed", "Allows you to move faster", Category.MOVEMENT));
		modules.add(new Surround("Surround", "Places blocks around you", Category.COMBAT));
		modules.add(new AutoTrap("AutoTrap", "Traps players", Category.COMBAT));
		modules.add(new Blink("Blink", "Fake lag", Category.EXPLOIT));
		modules.add(new AutoLog("AutoLog", "Automatically logs out when your health is low", Category.COMBAT));
		modules.add(new ReverseStep("ReverseStep", "Moves you faster down", Category.MOVEMENT));
		modules.add(new Watermark("Watermark", Category.COMPONENT));
		modules.add(new HUDEditor("HUDEditor", Category.RENDER));
	}

	public ArrayList<Module> getModules()
	{
		return modules;
	}

	public Module getModule(String name)
	{
		for (Module module : modules)
		{
			if (module.getName().equalsIgnoreCase(name)) return module;
		}

		return null;
	}

	public ArrayList<Module> getModules(Category category)
	{
		ArrayList<Module> mods = new ArrayList<>();

		for (Module module : modules)
		{
			if (module.getCategory().equals(category)) mods.add(module);
		}

		return mods;
	}

	public ArrayList<Module> getEnabledModules()
	{
		return modules.stream().filter(Module::isEnabled).collect(Collectors.toCollection(ArrayList::new));
	}
}
