package thatmartinguy.dota.capability;

import thatmartinguy.dota.hero.EnumHero;

public interface IHeroCapability extends ICapability
{
    public EnumHero getHero();

    public void setHero(EnumHero hero);
}
