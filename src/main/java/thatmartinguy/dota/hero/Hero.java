package thatmartinguy.dota.hero;

import net.minecraft.entity.player.EntityPlayer;
import thatmartinguy.dota.ability.Ability;

import java.util.ArrayList;
import java.util.List;

public class Hero
{
    private String name;

    private final float strengthBase;
    private final float agilityBase;
    private final float intelligenceBase;
    private final float strengthGain;
    private final float agilityGain;
    private final float intelligenceGain;

    private final List<Ability> ABILITY_LIST = new ArrayList<>();

    public Hero(String name, float strengthBase, float agilityBase, float intelligenceBase, float strengthGain, float agilityGain, float intelligenceGain)
    {
        this.name = name;
        this.strengthBase = strengthBase;
        this.agilityBase = agilityBase;
        this.intelligenceBase = intelligenceBase;
        this.strengthGain = strengthGain;
        this.agilityGain = agilityGain;
        this.intelligenceGain = intelligenceGain;
    }

    /**
     * Gets the hero's current attributes
     * @param player The player to get the attributes from
     * @return An array of attributes, going in the order [strengthGain, agilityGain, intelligenceGain]
     */
    public float[] getAttributes(EntityPlayer player)
    {
        return new float[] {strengthBase + strengthGain * Math.min(player.experienceLevel, 25), agilityBase + agilityGain * Math.min(player.experienceLevel, 25), intelligenceBase + intelligenceGain * Math.min(player.experienceLevel, 25)};
    }

    public String getName()
    {
        return name;
    }

    protected void addAbilities(Ability... abilities)
    {
        if(/*abilities.length >= 3 &&*/ abilities.length <= 5)
        {
            for(Ability ability : abilities)
            {
                ABILITY_LIST.add(ability);
            }
        }
        else
        {
            throw new AbilitySizeException(abilities.length + " abilities on hero " + this.getName() + " when the only amount of accepted abilities is between 3 and 5");
        }
    }

    public Ability getAbilityByIndex(int index)
    {
        return ABILITY_LIST.get(index);
    }

    private class AbilitySizeException extends RuntimeException
    {
        public AbilitySizeException(String message)
        {
            super(message);
        }
    }
}
