package thatmartinguy.dota.client.keybinding;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import org.lwjgl.input.Keyboard;
import thatmartinguy.dota.Dota;
import thatmartinguy.dota.capability.Capabilities;
import thatmartinguy.dota.capability.IHeroCapability;
import thatmartinguy.dota.util.LogHelper;
import thatmartinguy.dota.util.Reference;

public class ModKeyBindings
{
    private static final String CATEGORY_PREFIX = "key.category." + Reference.MOD_ID;
    private static final String CATEGORY_ABILITY = CATEGORY_PREFIX + ":abilities";
    private static final String CATEGORY_ITEM = CATEGORY_PREFIX + ":items";

    private static final String DESC_PREFIX = "key." + Reference.MOD_ID;
    private static final String DESC_ABILITY = DESC_PREFIX + ":ability";

    public static final KeyBinding ABILITY_0 = new KeyBinding(DESC_ABILITY + "0", KeyConflictContext.IN_GAME, Keyboard.KEY_NUMPAD1, CATEGORY_ABILITY);

    public static void registerKeyBindings()
    {
        ClientRegistry.registerKeyBinding(ABILITY_0);
    }

    @EventBusSubscriber
    public static class KeyEventHandler
    {
        @SubscribeEvent
        public static void handleKeyTick(ClientTickEvent event)
        {
            if(event.phase != TickEvent.Phase.END) return;

            if(ModKeyBindings.ABILITY_0.isPressed())
            {
                IHeroCapability heroCapability = Dota.proxy.getClientPlayer().getCapability(Capabilities.HERO_CAPABILITY, null);
                heroCapability.getHero().getAbilityByIndex(0).cast(Dota.proxy.getClientPlayer(), null);
            }
        }
    }
}
