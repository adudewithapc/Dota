package thatmartinguy.dota.hero;

public enum EnumHero
{
    NONE(new HeroNone()),
    OMNIKNIGHT(new HeroOmniknight());

    private Hero hero;

    EnumHero(Hero hero)
    {
        this.hero = hero;
    }

    @Override
    public String toString()
    {
        return hero.getName();
    }

    public String getName()
    {
        return hero.getName();
    }
}
