package thatmartinguy.dota.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import thatmartinguy.dota.capability.HeroProvider;
import thatmartinguy.dota.util.Reference;
import thatmartinguy.dota.util.ResourceHelper;

@EventBusSubscriber(modid = Reference.MOD_ID)
public class CapabilityEventHandler
{
    private static final ResourceLocation HERO_KEY = ResourceHelper.createResource("hero");

    @SubscribeEvent
    public static void attachCapabilities(AttachCapabilitiesEvent<EntityPlayer> event)
    {
        event.addCapability(HERO_KEY, new HeroProvider());
    }
}
