package thatmartinguy.dota.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class CapabilityProvider implements ICapabilitySerializable<NBTBase>
{
    private Capability capability;
    private ICapability instance;

    public CapabilityProvider(Capability capability, ICapability instance)
    {
        this.capability = capability;
        this.instance = instance;
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing)
    {
        return this.capability == capability;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing)
    {
        return capability == this.capability ? (T) this.instance : null;
    }

    @Override
    public NBTBase serializeNBT()
    {
        return this.capability.getStorage().writeNBT(this.capability, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt)
    {
        this.capability.getStorage().readNBT(this.capability, this.instance, null, nbt);
    }
}
