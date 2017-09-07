package thatmartinguy.dota.capability;

import thatmartinguy.dota.hero.EnumHero;
import thatmartinguy.dota.hero.Hero;

public interface IHeroCapability extends ICapability
{
    public Hero getHero();

    public EnumHero getEnumHero();

    public void setHero(EnumHero hero);

    public float getMaxMana();

    public float getMana();

    public void setMana(float mana);

    public void modifyMana(int mana);

    public void regenMana();
}
