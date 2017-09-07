package thatmartinguy.dota.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class CapabilityStorage<T extends ICapability> implements Capability.IStorage<T>
{
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<T> capability, T instance, EnumFacing side)
    {
        return instance.writeToNBT();
    }

    @Override
    public void readNBT(Capability<T> capability, T instance, EnumFacing side, NBTBase nbt)
    {
        instance.readFromNBT(nbt);
    }
}