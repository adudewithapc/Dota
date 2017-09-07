package thatmartinguy.dota;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import thatmartinguy.dota.capability.CapabilityStorage;
import thatmartinguy.dota.capability.HeroCapability;
import thatmartinguy.dota.capability.IHeroCapability;
import thatmartinguy.dota.proxy.IProxy;

import static thatmartinguy.dota.util.Reference.*;

@Mod(modid = MOD_ID, name = MOD_NAME, version = MOD_VERSION)
public class Dota
{
    public static final CreativeTabs TAB_DOTA = new CreativeTabs("tabDota")
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(Items.CHORUS_FRUIT);
        }
    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        CapabilityManager.INSTANCE.register(IHeroCapability.class, new CapabilityStorage<>(), HeroCapability.class);
    }

    public void init(FMLInitializationEvent event)
    {

    }

    @SidedProxy(clientSide = CLIENT_PROXY_LOCATION, serverSide = SERVER_PROXY_LOCATION)
    public static IProxy proxy;

    @Mod.Instance
    public static Dota instance;
}
