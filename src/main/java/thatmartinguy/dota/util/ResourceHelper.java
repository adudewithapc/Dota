package thatmartinguy.dota.util;

import net.minecraft.util.ResourceLocation;

public class ResourceHelper
{
    public static ResourceLocation createResource(String location)
    {
        return new ResourceLocation(Reference.MOD_ID, location);
    }
}
