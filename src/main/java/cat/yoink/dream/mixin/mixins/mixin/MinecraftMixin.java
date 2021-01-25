package cat.yoink.dream.mixin.mixins.mixin;

import cat.yoink.dream.mixin.mixins.accessor.IMinecraft;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Timer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/**
 * @author yoink
 * @since 9/20/2020
 */
@Mixin(value = Minecraft.class, priority =  634756347)
public class MinecraftMixin implements IMinecraft
{
	@Final @Shadow private Timer timer;

	@Override
	public Timer getTimer()
	{
		return timer;
	}
}
