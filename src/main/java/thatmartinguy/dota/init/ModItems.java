package thatmartinguy.dota.init;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import thatmartinguy.dota.item.ItemBase;
import thatmartinguy.dota.item.ItemHeroChecker;
import thatmartinguy.dota.util.Reference;

@ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    @ObjectHolder("itemherochecker")
    public static final ItemBase HERO_CHECKER = null;

    @EventBusSubscriber(modid = Reference.MOD_ID)
    public static class RegistryHandler
    {
        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event)
        {
            final Item[] MOD_ITEMS = {
                    new ItemHeroChecker("itemherochecker")
            };

            event.getRegistry().registerAll(MOD_ITEMS);
        }
    }
}
