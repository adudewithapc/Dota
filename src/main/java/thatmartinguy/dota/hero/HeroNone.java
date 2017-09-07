package thatmartinguy.dota.hero;

import thatmartinguy.dota.ability.AbilityTest;

public class HeroNone extends Hero
{
    public HeroNone()
    {
        super("None", 0, 0, 0,0, 0, 0);
        addAbilities(new AbilityTest());
    }
}
