package thatmartinguy.dota.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public interface ICapability
{
    public ResourceLocation getID();

    public NBTTagCompound writeToNBT();

    public void readFromNBT(NBTBase nbt);
}
