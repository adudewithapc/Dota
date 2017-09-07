package thatmartinguy.dota.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public interface IProxy
{
    public void preInit();

    public void init();

    public EntityPlayer getClientPlayer();

    public World getClientWorld();

    class WrongSideException extends RuntimeException
    {
        public WrongSideException(String message)
        {
            super(message);
        }
    }
}
