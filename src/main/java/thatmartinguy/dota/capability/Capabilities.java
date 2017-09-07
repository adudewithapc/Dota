package thatmartinguy.dota.capability;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class Capabilities
{
    @CapabilityInject(IHeroCapability.class)
    public static final Capability<IHeroCapability> HERO_CAPABILITY = null;
}
