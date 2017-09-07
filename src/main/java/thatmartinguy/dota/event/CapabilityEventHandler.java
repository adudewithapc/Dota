package thatmartinguy.dota.event;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.Clone;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import thatmartinguy.dota.capability.CapabilityProvider;
import thatmartinguy.dota.capability.HeroCapability;
import thatmartinguy.dota.capability.IHeroCapability;
import thatmartinguy.dota.util.Reference;

@EventBusSubscriber(modid = Reference.MOD_ID)
public class CapabilityEventHandler
{
    @CapabilityInject(IHeroCapability.class)
    public static final Capability<IHeroCapability> HERO_CAPABILITY = null;

    @SubscribeEvent
    public static void attachCapabilities(AttachCapabilitiesEvent<Entity> event)
    {
        if(event.getObject() instanceof EntityPlayer)
        {
            HeroCapability heroInstance = new HeroCapability((EntityPlayer) event.getObject());
            event.addCapability(HeroCapability.ID, new CapabilityProvider(HERO_CAPABILITY, heroInstance));
        }
    }

    @SubscribeEvent
    public static void loginAttach(PlayerLoggedInEvent event)
    {
        if(event.player.hasCapability(HERO_CAPABILITY, null))
        {
            IHeroCapability newHeroCapability = event.player.getCapability(HERO_CAPABILITY, null);
        }
    }

    @SubscribeEvent
    public static void cloneAttach(Clone event)
    {
        if(event.getOriginal().hasCapability(HERO_CAPABILITY, null) && event.getEntityPlayer().hasCapability(HERO_CAPABILITY, null))
        {
            IHeroCapability originalHeroCap = event.getOriginal().getCapability(HERO_CAPABILITY, null);
            IHeroCapability newHeroCap = event.getEntityPlayer().getCapability(HERO_CAPABILITY, null);
            if(!event.isWasDeath())
            {
                newHeroCap.setHero(originalHeroCap.getHero());
            }
        }
    }
}
