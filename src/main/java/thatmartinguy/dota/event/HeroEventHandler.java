package thatmartinguy.dota.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import thatmartinguy.dota.capability.Capabilities;
import thatmartinguy.dota.capability.IHeroCapability;

@EventBusSubscriber
public class HeroEventHandler
{
    @SubscribeEvent
    public static void regenMana(LivingUpdateEvent event)
    {
        if(event.getEntityLiving() instanceof EntityPlayer)
        {
            IHeroCapability heroCapability = (event.getEntityLiving()).getCapability(Capabilities.HERO_CAPABILITY, null);
            if(((EntityPlayer) event.getEntityLiving()).world.getWorldTime() % 20 == 0)
                heroCapability.regenMana();
        }
    }
}
