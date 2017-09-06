package thatmartinguy.dota.capability;

import thatmartinguy.dota.hero.EnumHero;

public class HeroCapability implements IHeroCapability
{
    private EnumHero hero;

    @Override
    public EnumHero getHero()
    {
        return hero;
    }

    @Override
    public void setHero(EnumHero hero)
    {
        this.hero = hero;
    }
}
