package thatmartinguy.dota.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import thatmartinguy.dota.client.keybinding.ModKeyBindings;

public class ClientProxy implements IProxy
{
    private final Minecraft MINECRAFT = Minecraft.getMinecraft();

    @Override
    public void preInit()
    {
        ModKeyBindings.registerKeyBindings();
    }

    @Override
    public void init()
    {

    }

    @Override
    public EntityPlayer getClientPlayer()
    {
        return MINECRAFT.player;
    }

    @Override
    public World getClientWorld()
    {
        return MINECRAFT.world;
    }
}
