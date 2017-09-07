package thatmartinguy.dota.ability;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.RayTraceResult;
import thatmartinguy.dota.util.LogHelper;

import javax.annotation.Nullable;

public class AbilityTest extends Ability
{
    public AbilityTest()
    {
        super("test");
    }

    @Override
    protected void execute(EntityPlayer player, @Nullable RayTraceResult traceResult)
    {
        LogHelper.info("Incredible test!!!!");
    }
}
