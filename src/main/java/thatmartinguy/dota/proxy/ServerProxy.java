package thatmartinguy.dota.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ServerProxy implements IProxy
{
    @Override
    public void preInit()
    {

    }

    @Override
    public void init()
    {

    }

    @Override
    public EntityPlayer getClientPlayer()
    {
        throw new WrongSideException("Tried to get the client player on the server.");
    }

    @Override
    public World getClientWorld()
    {
        throw new WrongSideException("Tried to get the client world on the server.");
    }
}
