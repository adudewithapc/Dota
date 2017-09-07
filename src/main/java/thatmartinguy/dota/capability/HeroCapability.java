package thatmartinguy.dota.capability;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import thatmartinguy.dota.hero.EnumHero;
import thatmartinguy.dota.hero.Hero;
import thatmartinguy.dota.util.ResourceHelper;

public class HeroCapability implements IHeroCapability
{
    public static final ResourceLocation ID = ResourceHelper.createResource("hero");

    private int heroID;
    private float mana;

    private EntityPlayer player;

    public HeroCapability(EntityPlayer player)
    {
        this.player = player;
    }

    @Override
    public Hero getHero()
    {
        return EnumHero.getHeroByID(heroID);
    }

    @Override
    public EnumHero getEnumHero()
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
        compound.setFloat("Mana", mana);

        return compound;
    }

    @Override
    public void readFromNBT(NBTBase nbt)
    {
        NBTTagCompound compound = (NBTTagCompound) nbt;
        this.heroID = compound.getInteger("HeroID");
        this.setMana(compound.getInteger("Mana"));
    }

    @Override
    public float getMaxMana()
    {
        float intelligence = EnumHero.getHeroByID(heroID).getAttributes(player)[2];
        return 75 + 11 * intelligence;
    }

    @Override
    public float getMana()
    {
        return this.mana;
    }

    @Override
    public void setMana(float mana)
    {
        if(mana > getMaxMana())
            this.mana = getMaxMana();
        this.mana = mana;
    }

    @Override
    public void modifyMana(int mana)
    {
        this.setMana(this.mana + mana);
    }

    @Override
    public void regenMana()
    {
        float intelligence = EnumHero.getHeroByID(heroID).getAttributes(player)[2];
        this.modifyMana(Math.round(0.01f + 0.04f * intelligence));
    }

    @Override
    public ResourceLocation getID()
    {
        return ID;
    }
}
