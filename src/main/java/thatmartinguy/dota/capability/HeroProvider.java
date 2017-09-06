package thatmartinguy.dota.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import thatmartinguy.dota.hero.EnumHero;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class HeroProvider implements ICapabilitySerializable<NBTBase>
{
    @CapabilityInject(IHeroCapability.class)
    public static final Capability<IHeroCapability> HERO_CAPABILITY = null;

    private static IHeroCapability instance = HERO_CAPABILITY.getDefaultInstance();

    public static void register()
    {
        CapabilityManager.INSTANCE.register(IHeroCapability.class, new Capability.IStorage<IHeroCapability>()
        {
            @Nullable
            @Override
            public NBTBase writeNBT(Capability<IHeroCapability> capability, IHeroCapability instance, EnumFacing side)
            {
                NBTTagCompound compound = new NBTTagCompound();

                compound.setInteger("Hero", instance.getHero().ordinal());

                return compound;
            }

            @Override
            public void readNBT(Capability<IHeroCapability> capability, IHeroCapability instance, EnumFacing side, NBTBase nbt)
            {
                NBTTagCompound compound = (NBTTagCompound) nbt;

                instance.setHero(EnumHero.values()[compound.getInteger("Hero")]);
            }
        }, HeroCapability::new);
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing)
    {
        return capability == HERO_CAPABILITY;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing)
    {
        return capability == HERO_CAPABILITY ? (T) instance : null;
    }

    @Override
    public NBTBase serializeNBT()
    {
        return HERO_CAPABILITY.getStorage().writeNBT(HERO_CAPABILITY, instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt)
    {
        HERO_CAPABILITY.getStorage().readNBT(HERO_CAPABILITY, instance, null, nbt);
    }
}
