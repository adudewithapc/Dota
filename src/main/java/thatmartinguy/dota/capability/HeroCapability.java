package thatmartinguy.dota.capability;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import thatmartinguy.dota.hero.EnumHero;
import thatmartinguy.dota.util.ResourceHelper;

public class HeroCapability implements IHeroCapability
{
    public static final ResourceLocation ID = ResourceHelper.createResource("hero");
    private int heroID;
    private EntityPlayer player;

    public HeroCapability(EntityPlayer player)
    {
        this.player = player;
    }

    @Override
    public EnumHero getHero()
    {
        return EnumHero.values()[heroID];
    }

    @Override
    public void setHero(EnumHero hero)
    {
        this.heroID = hero.ordinal();
    }

    @Override
    public NBTTagCompound writeToNBT()
    {
        NBTTagCompound compound = new NBTTagCompound();

        compound.setInteger("HeroID", heroID);

        return compound;
    }

    @Override
    public void readFromNBT(NBTBase nbt)
    {
        NBTTagCompound compound = (NBTTagCompound) nbt;
        this.heroID = compound.getInteger("HeroID");
    }

    @Override
    public ResourceLocation getID()
    {
        return ID;
    }
}
