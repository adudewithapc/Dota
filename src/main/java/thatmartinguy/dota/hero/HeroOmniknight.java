package thatmartinguy.dota.hero;

import thatmartinguy.dota.ability.AbilityTest;

public class HeroOmniknight extends Hero
{
    public HeroOmniknight()
    {
        super("Omniknight", 1, 1, 1,1, 1, 1);
        this.addAbilities(new AbilityTest());
    }
}
